package project.mc.blog.portfolio.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import project.mc.blog.portfolio.domain.PortfolioVO;
import project.mc.blog.portfolio.service.PortfolioSvc;
import project.mc.blog.resume.service.ResumeSvc;
import project.mc.blog.user.domain.UserVO;

@Controller
public class Portfolio_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PortfolioSvc pfSvc;
	@Autowired
	ResumeSvc RsSvc;
	
	@RequestMapping(value="blog/portfolio_view_tmp1.do", method = RequestMethod.GET)
	public ModelAndView portfolio_view_tmp1(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/portfolio/portfolio_view_tmp1");
		
		//int pf_id = 0;
		int pf_id = 63;//디버그용
		
		if(req.getParameter("pf_id") != null)
			pf_id = Integer.parseInt(req.getParameter("pf_id").toString());
		else {
			//TODO null 처리
			log.debug("pf_id를 찾지 못하였습니다.");
		}
		
		PortfolioVO inVO = new PortfolioVO();
		inVO.setPf_id(pf_id);
		
		PortfolioVO pfVO = null;
		pfVO = (PortfolioVO) pfSvc.do_searchByPf_id(inVO);
		
		log.debug("pfVO: "+pfVO.toString());
		
		mav.addObject("pfVO", pfVO);
		
		return mav;
	}
	
	@RequestMapping(value="blog/portfolio_view_tmp2.do", method = RequestMethod.GET)
	public ModelAndView portfolio_view_tmp2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/portfolio/portfolio_view_tmp2");
		
		return mav;
	}
	
	@RequestMapping(value="blog/portfolio_edit_tmp1.do", method = RequestMethod.GET)
	public ModelAndView portfolio_edit_tmp1(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/portfolio/portfolio_edit_tmp1");
		
		int pf_id = 0;
		
		if(req.getParameter("pf_id") != null) {
			pf_id = Integer.parseInt(req.getParameter("pf_id").toString());
			
		} else {
			//TODO 템플릿 첫 화면
			log.debug("새 템플릿 등록.");
			return mav;
		}
		
		PortfolioVO inVO = new PortfolioVO();
		inVO.setPf_id(pf_id);
		
		PortfolioVO pfVO = null;
		pfVO = (PortfolioVO) pfSvc.do_searchByPf_id(inVO);
		
		log.debug("pfVO: "+pfVO.toString());
		
		mav.addObject("pfVO", pfVO);
		
		return mav;
	}
	
	@RequestMapping(value="blog/portfolio_edit_tmp2.do", method = RequestMethod.GET)
	public String portfolio_edit_tmp2() {
		return "blog/portfolio/portfolio_edit_tmp2";
	}
	
	@RequestMapping(value="blog/portfolio_save.do", method = RequestMethod.POST)
	public String portfolio_save(MultipartHttpServletRequest mreq) throws DataAccessException, IOException {
		log.debug("=====Portfolio_controller: portfolio_save=start==========");
		
		int flag = -1;
		flag = pfSvc.do_save(mreq);
		
		log.debug("flag: "+flag);
		log.debug("=====Portfolio_controller: portfolio_save=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_delete.do", method = RequestMethod.GET)
	public String portfolio_delete(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_delete=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		int pf_id = Integer.parseInt(req.getParameter("pf_id").toString());
		inVO.setPf_id(pf_id);
		
		int flag = -1;
		flag = pfSvc.do_delete(inVO);
		
		log.debug("flag: "+flag);
		log.debug("=====Portfolio_controller: portfolio_delete=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_deleteAll.do", method = RequestMethod.POST)
	public String portfolio_deleteAll(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_deleteAll=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		int flag = -1;
		flag = pfSvc.do_deleteAll(inVO);
		
		log.debug("flag: "+flag);
		log.debug("=====Portfolio_controller: portfolio_deleteAll=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_upsert.do", method = RequestMethod.POST)
	public String portfolio_upsert(MultipartHttpServletRequest mreq) throws DataAccessException, IOException {
		
		log.debug("=====Portfolio_controller: portfolio_upsert=start==========");
		PortfolioVO inVO = new PortfolioVO();
		int flag = -1;
		
		String workDiv = mreq.getParameter("workDiv").toString();
		log.debug("workDiv: "+workDiv);
		
		if(workDiv != null && workDiv.equals("do_save")) {
			log.debug("do_save start");
			flag = pfSvc.do_save(mreq);
			log.debug("flag: "+flag);
			
		}else if(workDiv != null && workDiv.equals("do_update")){
			//TODO 사진들 업데이트, 서비스에서 실행
			log.debug("do_update start");
			flag = pfSvc.do_update(mreq);
			log.debug("flag: "+flag);
			
		}else {
			log.debug("wordDiv error");
			
		}
		
		
		log.debug("=====Portfolio_controller: portfolio_upsert=end==========");
		
		return "redirect:portfolio_view_tmp1.do";
	}
	
	@RequestMapping(value="blog/portfolio_update.do", method = RequestMethod.POST)
	public String portfolio_update(HttpServletRequest req) {
		log.debug("=====Portfolio_controller: portfolio_update=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		int pf_id = Integer.parseInt(req.getParameter("pf_id").toString());
		inVO.setPf_id(pf_id);
		String user_id = req.getParameter("user_id").toString();
		inVO.setUser_id(user_id);
		int tmp_no = Integer.parseInt(req.getParameter("tmp_no").toString());
		inVO.setTmp_no(tmp_no);
		
		int flag = -1;
		//flag = pfSvc.do_update(inVO);
		
		log.debug("flag: "+flag);
		log.debug("=====Portfolio_controller: portfolio_update=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_do_search.do", method = RequestMethod.POST)
	public String portfolio_do_search(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_do_search=start==========");
		PortfolioVO inVO = new PortfolioVO();
						
		List<PortfolioVO> list = new ArrayList<PortfolioVO>();
		list = (List<PortfolioVO>) pfSvc.do_search(inVO);
		
		log.debug("list: "+list.toString());
		log.debug("=====Portfolio_controller: portfolio_do_search=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_do_searchByPf_id.do", method = RequestMethod.POST)
	public String portfolio_do_searchByPf_id(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_do_searchByPf_id=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		int pf_id = Integer.parseInt(req.getParameter("pf_id").toString());
		inVO.setPf_id(pf_id);
				
		PortfolioVO pfVO = null;
		pfVO = (PortfolioVO) pfSvc.do_searchByPf_id(inVO);
		
		log.debug("pfVO: "+pfVO.toString());
		log.debug("=====Portfolio_controller: portfolio_do_searchByPf_id=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_do_searchByUser_id.do", method = RequestMethod.POST)
	public String portfolio_do_searchByUser_id(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_do_searchByUser_id=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		String user_id = req.getParameter("user_id").toString();
		inVO.setUser_id(user_id);
		
		List<PortfolioVO> list = new ArrayList<PortfolioVO>();
		list = (List<PortfolioVO>) pfSvc.do_searchByUser_id(inVO);
		
		log.debug("list: "+list.toString());
		log.debug("=====Portfolio_controller: portfolio_do_searchByUser_id=end==========");
		
		return "";
	}
	
	
	
	@RequestMapping(value="portfolio_menu.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String portfolio_menu(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		log.debug("portfolio_menu*");
		String user_id = req.getParameter("user_id").toString();
		log.debug("user_id"+user_id);
		String login_id = req.getParameter("login_id").toString();
		log.debug("login_id"+login_id);
		String contextPath = req.getContextPath();
		contextPath = "http://localhost:8080" + contextPath;
		log.debug("contextPath"+contextPath);
		
		PortfolioVO inVO = new PortfolioVO();
		inVO.setUser_id(user_id);
		List<PortfolioVO> list = (List<PortfolioVO>) pfSvc.do_searchByUser_id(inVO);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<ul class='pf_menu' style='display:none'>");
		
		if(user_id != null && user_id.equals(login_id)) {
			sb.append("<li><a href='"+contextPath+"/blog/portfolio_edit_tmp1.do'><img src='' alt='새 템플릿'/></a></li>\n");
		}
		
		for(PortfolioVO outVO : list) {
			int pf_id = outVO.getPf_id();
			int tmp_no = outVO.getTmp_no();
			
			sb.append("<li><a href='"+contextPath+"/blog/portfolio_view_tmp"+tmp_no+".do?pf_id="+pf_id+"'><img src='' alt='템플릿_"+pf_id+"'/></a></li>\n");
		}
		
		sb.append("</ul>");
		
//		Gson gson = new Gson();
//        String json = gson.toJson(list);
		
		String outStr = sb.toString();
		log.debug("outStr: "+outStr);
		//URLEncoder.encode(outStr , "UTF-8");
		return outStr;
	}
	
}
