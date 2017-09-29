package project.mc.blog.post.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.mc.blog.post.common.PostDTO;
import project.mc.blog.post.common.StringUtil;
import project.mc.blog.post.service.PostSvc;
import project.mc.blog.post.service.PostSvcImpl;

@Controller
public class PostController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	PostSvc postSvc;
	
//	int post_id        ; //포스트 id
//	int blog_id        ; //소속 블로그 id
//	int sup_post_id    ; //상위 게시글 id
//	String post_title  ; //제목
//	String post_content; //내용
//	String reg_id      ; //작성자 id
//	String reg_dt      ; //작성일자
//	String mod_id      ; //수정자 id
//	String mod_dt      ; //수정일자
//	int del_flag       ; //삭제 플래그
	
	
	@RequestMapping(value = "blog/post/post_doSelectOne.do", method = RequestMethod.GET)
	public ModelAndView doSelectoOne (HttpServletRequest req, ServletRequest request) {
		PostDTO inVO = new PostDTO();
		inVO.setPost_id(Integer.parseInt(request.getParameter("post_id")));
		inVO.setBlog_id(Integer.parseInt(request.getParameter("blog_id")));
		inVO.setSup_post_id(Integer.parseInt(request.getParameter("sup_post_id")));
		inVO.setPost_title(request.getParameter("post_title"));
		inVO.setPost_content(request.getParameter("post_content"));
		inVO.setReg_id(request.getParameter("reg_id"));
		inVO.setReg_dt(request.getParameter("reg_dt"));
		inVO.setMod_id(request.getParameter("mod_id"));
		inVO.setMod_dt(request.getParameter("mod_dt"));
		inVO.setDel_flag(Integer.parseInt(request.getParameter("del_flag")));
		
		log.debug("1=========================");
		log.debug(inVO.toString());
		log.debug("1=========================");
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("blog/post_form");
		
		PostDTO  vo = (PostDTO)postSvc.do_searchOne(inVO);
		log.debug("vo"+vo);
		log.debug("=========================");
		
		modelAndView.addObject("PostDTO",vo);
		
		return modelAndView;
	}
	@RequestMapping(value = "blog/post/post_doSave.do")
	public String doSave_View (HttpServletRequest req, ServletRequest request) throws IOException{
		
		return "blog/post_form";
	}
	
	@RequestMapping(value = "blog/post_doSave.do",method = RequestMethod.POST)
	public String doSave (HttpServletRequest req, ServletRequest request) throws IOException{
		PostDTO inVO = new PostDTO();
		
		inVO.setPost_id(Integer.parseInt(request.getParameter("post_id")));
		inVO.setBlog_id(Integer.parseInt(request.getParameter("blog_id")));
		inVO.setPost_title(request.getParameter("post_title"));
		inVO.setPost_content(request.getParameter("post_content"));
		inVO.setReg_id(request.getParameter("reg_id"));
		
		String workDiv = req.getParameter("workdDiv");
		
		int flag = 0;
		if(workDiv ==null||workDiv.trim().equals("")) {
			flag =postSvc.do_save(inVO);
		}else {
			
		}
		log.debug("flag : "+flag);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", postSvc.do_save(inVO));
		modelAndView.setViewName("blog/post_list");
		
		return "redirect:post_list.do";
	}

	@RequestMapping(value="blog/post/post_doSearch.do")
	public ModelAndView do_search(HttpServletRequest req) {
		
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
        log.debug("sParam:"+sParam.toString());
		
		inVO.setParam(searchParam);
		List<PostDTO> list = (List<PostDTO>)postSvc.do_search(inVO);
   	    int totalCnt   = 0;
   	    if(list !=null && list.size()>0)totalCnt = list.get(0).getTotal_cnt();
   	    
		//TO_DO: pageing
		ModelAndView modelAndView =new ModelAndView();
		
		modelAndView.addObject("list",list );
		//total count
		modelAndView.addObject("totalCnt",totalCnt);
		modelAndView.setViewName("");
		
		return modelAndView;
	}
	
	@RequestMapping(value="blog/post/post_do_Delete.do")
	public ModelAndView do_Delete(HttpServletRequest request) {
		PostDTO inVO = new PostDTO();
		String id = request.getParameter("id");
		inVO.setPost_id(Integer.parseInt(request.getParameter("post_id")));
		postSvc.do_delete(inVO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", postSvc.do_search(inVO));
		modelAndView.setViewName("blog/post_list");
		
		return modelAndView;
	}

	
	
}
