package project.mc.blog.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.metadata.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.mc.blog.user.dao.UserDao;
import project.mc.blog.user.dao.UserDaoImpl;
import project.mc.blog.user.domain.UserVO;
import project.mc.blog.user.service.UserSvc;
import project.mc.blog.user.service.UserSvcImpl;
import project.mc.commons.DTO;
/**
 * UserController.java
 * @author sist
 *
 */
@Controller 
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String SESSION_USER_ID = "user_id";
	
	@Autowired 
	UserSvc userSvc;
	
//	@Autowired
//	private Validator validator;
	
	@RequestMapping(value="user/do_save.do", method={RequestMethod.POST,RequestMethod.GET})
	public String do_save(HttpServletRequest req) throws IOException{
		
		UserVO inVO = new UserVO();
		
		int user_no = 1;
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
		int withdraw_flag = 1;//Integer.parseInt(req.getParameter("withdraw_flag").toString());
		inVO.setWithdraw_flag(withdraw_flag);
		
		int flag = 0;
		flag = userSvc.do_save(inVO);
		
		log.debug("22===================");
		log.debug("//do_save==========");
		log.debug("22===================");
		
		log.debug("@@@@@@@@@@@do_save: "+flag);
		
		return "redirect:do_login.do";
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
	
	// 회원 수정
	@RequestMapping(value="user/do_update.do", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView do_updateForm(@ModelAttribute HttpSession session ,HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		UserVO inVO = new UserVO();
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("main/home_main");//List
		
		return modelAndView;
	}
	
	// 회원수정 페이지로 이동
	@RequestMapping(value="user/do_updateForm.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String do_update(@ModelAttribute HttpSession session, HttpServletRequest req) {
		UserVO inVO = new UserVO();
		UserVO inVO2 = new UserVO();
		String user_id = "난";
		//(String)session.getAttribute("user_id");
		inVO.setUser_id(user_id);
		
		inVO2=userSvc.viewMember(inVO);
		log.debug("inVO2::::::"+inVO2.toString());
		return "blog/user/user_modify";
		
	}
	
	@RequestMapping(value="user/do_delete.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_delete(HttpServletRequest req) throws IOException {
		
		UserVO inVO=new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		int withdraw_flag = 0;
		inVO.setWithdraw_flag(withdraw_flag);
		log.debug("inVO : "+inVO.getUser_id()); 
		
		
		int flag = userSvc.do_delete(inVO);
		log.debug("flag : "+flag);
		
		return "redirect:do_look.do";
	}
	
	// 로그인 화면으로 감
	@RequestMapping(value="user/login_page.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_login() throws IOException {
		
		return "blog/user/user_login";
	}
	
	// 회원가입 화면으로 감
	@RequestMapping(value="user/do_look.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_look(HttpServletRequest req) throws IOException {
		
		return "blog/user/user_register";
	}
	
	// 로그인 처리
	@RequestMapping(value="user/do_loginCheck.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	
	public ModelAndView do_loginCheck(@ModelAttribute UserVO inVO, HttpSession session, HttpServletRequest req) throws IOException {
		
		
		String user_id = req.getParameter(SESSION_USER_ID);
		String user_password = req.getParameter("user_password");
		session.setAttribute(SESSION_USER_ID, user_id);
		session.setAttribute("user_password", user_password);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("main/home_main");
		mav.addObject("msg", "success");
		inVO.setUser_id(user_id);
		boolean result = userSvc.do_loginCheck(inVO);
		session.getAttribute("user_id");
		session.getAttribute("user_password");
		if(result == true) {
			mav.setViewName("main/home_main");
			mav.addObject("msg", "success");
		}else {
			mav.setViewName("blog/user/user_login");
			mav.addObject("msg", "failure");
		}
		
		return mav;
	}
	
	// 로그 아웃
	
	@RequestMapping(value="user/do_logout.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	
	public ModelAndView do_logout(HttpSession session) throws IOException {
		
		userSvc.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/user/user_login");
		mav.addObject("msg", "logout");
		
		return mav;
		
	}
	
//	// 회원 상세 정보 조회
//	@RequestMapping(value="user/do_memberView.do" ,method= {RequestMethod.POST,RequestMethod.GET})
//	
//	public ModelAndView do_memberView(HttpSession session) throws IOException {
//		
//		ModelAndView mav = null;
//	}	
		
	
		
	
	
	
	
	
	
}
