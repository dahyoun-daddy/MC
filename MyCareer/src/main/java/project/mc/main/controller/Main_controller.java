package project.mc.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.mc.blog.user.domain.UserVO;
import project.mc.blog.user.service.UserSvc;

@Controller
public class Main_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserSvc userSvc;
	
	
	@RequestMapping(value="main/home_main.do", method= {RequestMethod.GET , RequestMethod.POST})
	public String main_start() {
		
		return "main/home_main";
	}
	
	
	@RequestMapping(value="main/blog_search.do", method=RequestMethod.GET)
	public String blog_search(HttpServletRequest req) {
		log.debug("blog_search===============");
		
		
		return "main/blog_list/blog_list";
	}
	
	@RequestMapping(value="blog/header_title.do", method= RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String header_title(HttpServletRequest req) {
		String user_id = req.getParameter("user_id").toString();
		log.debug("user_id"+user_id);
//		String contextPath = req.getContextPath();
//		contextPath = "http://localhost:8080" + contextPath;
//		log.debug("contextPath"+contextPath);
		
		UserVO inVO = new UserVO();
		inVO.setUser_id(user_id);
		UserVO outVO = userSvc.viewMember(inVO);
		String user_name = outVO.getUser_name();
		
		String str = "<img src='' alt='"+user_name+" 님의 구직 블로그'/>";
		
		return str;
	}
	
	
}
