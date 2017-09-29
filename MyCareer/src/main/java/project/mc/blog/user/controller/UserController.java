package project.mc.blog.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
	
	
	@RequestMapping(value="user/login_page.do", method={RequestMethod.GET ,RequestMethod.POST})
	public String login_page(HttpServletRequest req) throws IOException {
		
		return "blog/user/user_login";
	}
	@RequestMapping(value="user/user_login.do", method={RequestMethod.GET ,RequestMethod.POST})
	public String to_login(HttpServletRequest req) throws IOException {
		
		UserVO inVO = new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		inVO.setUser_password(req.getParameter("user_password"));
		
		int flag = 0;
		flag = userSvc.do_login(inVO);
		log.debug("***********************");
		log.debug("flag: "+flag);
		log.debug("***********************");
		
		
		return "mc/main/home_main.do";
	}
	
	@RequestMapping(value="user/user_modify.do", method= {RequestMethod.GET ,RequestMethod.POST})
	public String to_modify(HttpServletRequest req) {
		
		UserVO inVO = new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		inVO.setUser_password(req.getParameter("user_password"));
		inVO.setUser_name(req.getParameter("user_name"));
		int age = Integer.parseInt(req.getParameter("age").toString());
		inVO.setAge(age);
		inVO.setEmail(req.getParameter("email"));
		inVO.setAddress(req.getParameter("address"));
		inVO.setPhone(req.getParameter("phone"));
		
		int flag = 0;
		flag = userSvc.do_update(inVO);
		
		log.debug("flag: "+flag);
		
		return "blog/user/user_modify";
	}
	
	@RequestMapping(value="user/user_register.do", method={RequestMethod.GET ,RequestMethod.POST})
	public String user_register() {
		
		return "blog/user/user_register";
	}
	
	@RequestMapping(value="user/favorite.do", method={RequestMethod.GET ,RequestMethod.POST})
	public String favorite() {
		
		return "blog/recruit/favorite";
	}
	
	
	@RequestMapping(value="user/do_save.do", method={RequestMethod.GET ,RequestMethod.POST})
	public String do_save(HttpServletRequest req) throws IOException{
		
		UserVO inVO = new UserVO();
		
		
		int user_no = Integer.parseInt(req.getParameter("user_no").toString());
		inVO.setUser_no(user_no);
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
		
		return "redirect:user_login.do";
	}
	
	@RequestMapping(value="user/do_delete.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_delete(HttpServletRequest req) throws IOException {
		
		UserVO inVO=new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		int withdraw_flag = Integer.parseInt(req.getParameter("withdraw_flag").toString());
		inVO.setWithdraw_flag(withdraw_flag);
		log.debug("inVO : "+inVO.getUser_id()); 
		
		int flag = userSvc.do_delete(inVO);
		log.debug("flag : "+flag);
		
		return "redirect:user_login.do";
	}
	
//	@RequestMapping(value="user/do_idCheck.do", method= {RequestMethod.POST,RequestMethod.GET} , produces="application/json;charset=utf8")
//	@ResponseBody
//	public boolean do_idcheck(DTO dto, HttpServletResponse res) throws DataAccessException, IOException{
//		
//		int selectUserIdCheck = userSvc.do_idCheck(dto);
//		
//		log.debug("===========================================");
//		log.debug("updatePersonData : " + selectUserIdCheck);
//		log.debug("===========================================");
//		
//		PrintWriter out = res.getWriter();
//		if (selectUserIdCheck == 0) {
//			return false;
//			//out.println("true");
//		} else {
//			return true;
//			//out.println("false");
//		}
//		
//		//return "redirect:do_idCheck.do";
//	}
	
	
	
	
	
	
	
	
	
}
