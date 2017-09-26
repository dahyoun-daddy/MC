package project.mc.blog.portfolio.controller;

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
	
	
}
