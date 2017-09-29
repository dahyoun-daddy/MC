package project.mc.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.mc.blog.user.domain.UserVO;
import project.mc.blog.user.service.UserSvc;

@Controller
public class Main_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserSvc userSvc;
	
	
	@RequestMapping(value="main/home_main.do", method=RequestMethod.GET)
	public String main_start() {
		log.debug("main start");
		
		
		
		
		return "main/home_main";
	}
	
	
	@RequestMapping(value="main/blog_search.do", method=RequestMethod.GET)
	public String blog_search(HttpServletRequest req) {
		log.debug("blog_search===============");
		UserVO userVO = new UserVO();
		userVO.setUser_id("sist");
		
		int flag = userSvc.do_idCheck(userVO);
		log.debug("flag: "+flag);
		System.out.println("flag: "+flag);
		
		
		return "main/blog_list";
	}
	
	
	@RequestMapping(value="main/blog_list.do", method=RequestMethod.GET)
	public String blog_list() {
		log.debug("blog_list");
		
		
		
		
		return "main/blog_list";
	}
	
	
}
