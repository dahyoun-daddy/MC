package project.mc.blog.post.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;


import project.mc.blog.post.domain.PostDTO;
import project.mc.blog.post.domain.StringUtil;
import project.mc.blog.post.service.PostSvc;

@Controller
public class PostController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	PostSvc postSvc;
	
	
	@RequestMapping(value = "blog/post/post_doSelectOne.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView doSelectoOne (HttpServletRequest req) {
		PostDTO inVO = new PostDTO();
		inVO.setPost_id(Integer.parseInt(req.getParameter("post_id")));
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("blog/post/post_view");
		
		PostDTO  vo = (PostDTO)postSvc.do_searchOne(inVO);
		
		modelAndView.addObject("PostDTO",vo);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "blog/post/post_edit_form.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView doedit_form (HttpServletRequest req, HttpSession session) {
		PostDTO inVO = new PostDTO();
		inVO.setPost_id(Integer.parseInt(req.getParameter("post_id")));
		
		
		ModelAndView modelAndView=new ModelAndView();
		//modelAndView.setViewName("blog/post/post_edit_form");
		modelAndView.setViewName("blog/post/post_edit_form");
		
		PostDTO  vo = (PostDTO)postSvc.do_searchOne(inVO);
		
		modelAndView.addObject("PostDTO",vo);
		
		return modelAndView;
	}
	

	@RequestMapping(value = "blog/post/post_doSave.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String doSave_View (HttpServletRequest req) throws IOException{
		
		return "blog/post/post_form";
	}
	
	@RequestMapping(value = "blog/post/post_doSave_form.do",method = {RequestMethod.GET, RequestMethod.POST})
	public void doSave (HttpServletRequest req, HttpServletResponse res) throws IOException{
		log.debug("do_save!start");
		PostDTO inVO = new PostDTO();
		
		String contextPath = req.getContextPath();
		contextPath = "http://localhost:8080" + contextPath;
		String user_id = req.getParameter("user_id");
		
		//inVO.setBlog_id(Integer.parseInt(req.getParameter("blog_id")));
		inVO.setPost_title(req.getParameter("post_title"));
		inVO.setPost_content(req.getParameter("post_content"));
		String post_content = req.getParameter("post_content").toString();
		
		inVO.setReg_id(req.getParameter("reg_id"));
		
		inVO.setMod_id(req.getParameter("reg_id"));
		
		inVO.setReg_dt("1");
		inVO.setMod_dt("1");
		
		int flag = 0;
		
		flag =postSvc.do_save(inVO);
	
		List<PostDTO> list = (List<PostDTO>)postSvc.do_search(inVO);
   	    int totalCnt   = 0;
   	    if(list !=null && list.size()>0)totalCnt = list.get(0).getTotal_cnt();
   	    
   	    
   	    res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		if(flag == 1) {
			
			String msg = "";
			msg = "포스트 저장 완료.";
			
			String str="";
			str = "<script language='javascript'>"; 
			str += "alert('"+ msg + "');";   //얼럿창 띄우기
			str += "location.href = '"+contextPath+"/blog/post/post_doSearch.do?user_id=<%=user_id%>";
			str += "</script>";
			out.print(str);
		}else {
			String msg = "에러 발생.";
			String str="";
			
			str = "<script language='javascript'>"; 
			str += "alert('"+ msg + "');";   //얼럿창 띄우기
			str += "history.go(-1);";
			str += "</script>";
			out.print(str);
		}
   	    
	}

	@RequestMapping(value="blog/post/post_doSearchAll.do" ,method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView do_searchALL(HttpServletRequest req) {
		
		PostDTO inVO = new PostDTO();
		Hashtable<String, String> 
		searchParam = new Hashtable<String, String>();//
		String p_pageSize = StringUtil.nvl(req.getParameter("page_size"),"10");
		String p_pageNo  = StringUtil.nvl(req.getParameter("page_num"),"1");
		String p_searchDiv = StringUtil.nvl(req.getParameter("searchDiv"),"");
		String p_searchWord = StringUtil.nvl(req.getParameter("searchWord"),"");
		
		searchParam.put("pageSize", p_pageSize);
		searchParam.put("pageNo", p_pageNo);
		searchParam.put("searchDiv", p_searchDiv);
		searchParam.put("searchWord", p_searchWord);
		
		//request 
		Enumeration<String> params = req.getParameterNames();
		Hashtable<String, String> 
		sParam = new Hashtable<String, String>();	
		while(params.hasMoreElements()){
		  String name = (String)params.nextElement();
		  req.getParameter(name);
		  sParam.put(name, StringUtil.nvl(req.getParameter(name),""));
		}
        
		
		inVO.setParam(searchParam);
		List<PostDTO> list = (List<PostDTO>)postSvc.do_search(inVO);
   	    int totalCnt   = 0;
   	    if(list !=null && list.size()>0)totalCnt = list.get(0).getTotal_cnt();
   	    
		ModelAndView modelAndView =new ModelAndView();
		
		modelAndView.addObject("list",list);
		modelAndView.addObject("totalCnt",totalCnt);
		modelAndView.setViewName("blog/post/post_list");
		
		return modelAndView;
	}
	
	@RequestMapping(value="blog/post/post_doSearch.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView do_search(HttpServletRequest req) {
		
		
		PostDTO inVO = new PostDTO();
		
		Hashtable<String, String> 
		searchParam = new Hashtable<String, String>();//寃��깋議곌굔
		String p_pageSize = StringUtil.nvl(req.getParameter("page_size"),"10");
		String p_pageNo  = StringUtil.nvl(req.getParameter("page_num"),"1");
		String p_searchDiv = StringUtil.nvl(req.getParameter("searchDiv"),"");
		String p_searchWord = StringUtil.nvl(req.getParameter("searchWord"),"");
		String user_id = req.getParameter("user_id");
		
		searchParam.put("pageSize", p_pageSize);
		searchParam.put("pageNo", p_pageNo);
		searchParam.put("searchDiv", p_searchDiv);
		searchParam.put("searchWord", p_searchWord);
		
		inVO.setParam(searchParam);
		inVO.setReg_id(user_id);
		
		List<PostDTO> list = (List<PostDTO>)postSvc.do_search(inVO);
   	    int totalCnt   = 0;
   	    if(list !=null && list.size()>0)totalCnt = list.get(0).getTotal_cnt();
   	    
		ModelAndView modelAndView =new ModelAndView();
		
		modelAndView.addObject("list",list);
		
		//total count
		modelAndView.addObject("totalCnt",totalCnt);
		if(user_id != null) {
			modelAndView.setViewName("blog/post/post_list");
		}else {
			modelAndView.setViewName("main/blog_list/blog_list");
		}
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="blog/post/do_checkedDelete.do",produces="application/json;charset=utf8", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String do_checkedDelete(HttpServletRequest req) throws IOException {
		//in
		String ret = req.getParameter("idList");//JSON
		log.debug("ret :"+ret);
		
		Gson gson=new Gson();
		List<String> idList = gson.fromJson(ret, List.class);
		
		String firstId = "";
		
		for(int i=0;i<idList.size();i++) {
			firstId = idList.get(i);
		}
		
		idList.add(firstId);
		
		int flag = postSvc.do_checkedDelete(idList);
		//--in
		
		return flag+"";
	}
	
	
	@RequestMapping(value="blog/post/post_do_Update.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String do_Update(HttpServletRequest request) {
		PostDTO inVO = new PostDTO();

		inVO.setPost_id(Integer.parseInt(request.getParameter("post_id")));
		inVO.setPost_title(request.getParameter("post_title"));
		inVO.setPost_content(request.getParameter("post_content"));
		inVO.setMod_id(request.getParameter("mod_id"));
		String user_id = null;
		user_id = request.getParameter("user_id");
		
		int flag = postSvc.do_update(inVO);
		
		List<PostDTO> list = (List<PostDTO>)postSvc.do_search(inVO);
		int totalCnt   = 0;
   	    if(list !=null && list.size()>0)totalCnt = list.get(0).getTotal_cnt();
   	  	
		return "redirect:post_doSearch.do?user_id="+user_id;
	}



	
}
