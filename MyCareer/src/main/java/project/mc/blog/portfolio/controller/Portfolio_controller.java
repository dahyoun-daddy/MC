package project.mc.blog.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.mc.blog.portfolio.domain.PortfolioVO;
import project.mc.blog.portfolio.service.PortfolioSvc;
import project.mc.blog.user.domain.UserVO;

@Controller
public class Portfolio_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PortfolioSvc pfSvc;
	
	@RequestMapping(value="blog/portfolio.do", method = RequestMethod.GET)
	public String portfolio_view() {
		return "blog/portfolio/portfolio";
	}
	
	@RequestMapping(value="blog/portfolio_edit.do", method = RequestMethod.GET)
	public String portfolio_edit() {
		return "blog/portfolio/portfolio_edit";
	}
	
	@RequestMapping(value="blog/portfolio_save.do", method = RequestMethod.POST)
	public String portfolio_save(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_save=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		int user_no = Integer.parseInt(req.getParameter("user_no").toString());
		inVO.setUser_no(user_no);
		int tmp_no = Integer.parseInt(req.getParameter("tmp_no").toString());
		inVO.setTmp_no(tmp_no);
				
		int flag = -1;
		flag = pfSvc.do_save(inVO);
		
		log.debug("flag: "+flag);
		log.debug("=====Portfolio_controller: portfolio_save=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_delete.do", method = RequestMethod.POST)
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
		flag = pfSvc.do_delete(inVO);
		
		log.debug("flag: "+flag);
		log.debug("=====Portfolio_controller: portfolio_deleteAll=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_update.do", method = RequestMethod.POST)
	public String portfolio_update(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_update=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		int pf_id = Integer.parseInt(req.getParameter("pf_id").toString());
		inVO.setPf_id(pf_id);
		int user_no = Integer.parseInt(req.getParameter("user_no").toString());
		inVO.setUser_no(user_no);
		int tmp_no = Integer.parseInt(req.getParameter("tmp_no").toString());
		inVO.setTmp_no(tmp_no);
				
		int flag = -1;
		flag = pfSvc.do_delete(inVO);
		
		log.debug("flag: "+flag);
		log.debug("=====Portfolio_controller: portfolio_update=end==========");
		
		return "";
	}
	
	@RequestMapping(value="blog/portfolio_do_search.do", method = RequestMethod.POST)
	public String portfolio_do_search(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_do_search=start==========");
		PortfolioVO inVO = new PortfolioVO();
						
		List<PortfolioVO> list = new ArrayList<PortfolioVO>();
		list = (List<PortfolioVO>) pfSvc.do_searchByPf_id(inVO);
		
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
	
	@RequestMapping(value="blog/portfolio_do_searchByUser_no.do", method = RequestMethod.POST)
	public String portfolio_do_searchByUser_no(HttpServletRequest req) {
		
		log.debug("=====Portfolio_controller: portfolio_do_searchByUser_no=start==========");
		PortfolioVO inVO = new PortfolioVO();
		
		int user_no = Integer.parseInt(req.getParameter("user_no").toString());
		inVO.setUser_no(user_no);
				
		List<PortfolioVO> list = new ArrayList<PortfolioVO>();
		list = (List<PortfolioVO>) pfSvc.do_searchByUser_no(inVO);
		
		log.debug("list: "+list.toString());
		log.debug("=====Portfolio_controller: portfolio_do_searchByUser_no=end==========");
		
		return "";
	}
	
	
}
