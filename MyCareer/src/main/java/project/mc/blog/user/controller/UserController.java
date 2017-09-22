package project.mc.blog.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.mc.blog.user.domain.UserVO;
import project.mc.blog.user.service.UserSvc;
import project.mc.commons.DTO;
/**
 * UserController.java
 * @author sist
 *
 */
@Controller
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	UserSvc userSvc;
	
	@RequestMapping(value="user/do_save.do", method=RequestMethod.GET)
	public String do_save(HttpServletRequest req) throws IOException{
		
		UserVO inVO = new UserVO();
		
		
		int user_no = Integer.parseInt(req.getParameter("user_no").toString());
		inVO.setNo(user_no);
		inVO.setUser_id(req.getParameter("user_id"));
		inVO.setUser_password(req.getParameter("user_password"));
		int user_div = Integer.parseInt(req.getParameter("user_div").toString());
		inVO.setUser_div(user_div);
		inVO.setUser_name(req.getParameter("user_name"));
		int gender = Integer.parseInt(req.getParameter("gender").toString());
		inVO.setGender(gender);
		int age = Integer.parseInt(req.getParameter("age").toString());
		inVO.setAge(age);
		inVO.setEmail(req.getParameter("email"));
		inVO.setAddress(req.getParameter("address"));
		inVO.setPhone(req.getParameter("phone"));
		int withdraw_flag = Integer.parseInt(req.getParameter("withdraw_flag").toString());
		inVO.setWithdraw_flag(withdraw_flag);
		
		int flag = 0;
		flag = userSvc.do_save(inVO);
		
		log.debug("flag: "+flag);
		
		return "user/do_save.do";
	}
	
	@RequestMapping(value="user/do_look.do",
    		method=RequestMethod.GET)
	public String do_look() {
		log.debug("===================");
		log.debug("//do_look==========");
		log.debug("===================");
		
		return "user/user_register";
	}

//	@RequestMapping(value="user/do_idCheck.do")
//	public String id_check(HttpServletRequest req) throws DataAccessException{
//		UserVO inVO = new UserVO();
//		
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
