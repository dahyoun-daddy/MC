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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
	
	@Autowired 
	UserSvc userSvc;
	
//	@Autowired
//	private Validator validator;
	
	// ====================================================================================================	
	// ��α� 
	// ====================================================================================================
	// ȸ�� ���� (��α�)
	@RequestMapping(value="blog/do_blog_save.do", method={RequestMethod.POST,RequestMethod.GET})
	public String do_blog_save(HttpServletRequest req) throws IOException{
		
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
		
		return "redirect:blog_login_page.do";
	}
	
	
	// �ߺ� id ��ȸ
	@RequestMapping(value="user/do_blog_idCheck.do", method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String do_blog_idcheck(HttpServletRequest req) throws DataAccessException, IOException{
	
		UserVO inVO = new UserVO();
		inVO.setUser_id(req.getParameter("login_id"));
		
		int selectUseridCheck = userSvc.do_idCheck(inVO);
		
		if(selectUseridCheck == 0) {
			return "true";
		}
		else {
			return "false";
		}
		
	}
	
	// ȸ�� ����(��α�)
	@RequestMapping(value="blog/do_blog_update.do", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView do_blog_updateForm(HttpServletRequest req) throws IOException {
		
		UserVO inVO=new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		inVO.setUser_password(req.getParameter("user_password"));
		inVO.setUser_name(req.getParameter("user_name"));
		int age = Integer.parseInt(req.getParameter("age").toString());
		inVO.setAge(age);
		inVO.setEmail(req.getParameter("email"));
		inVO.setAddress(req.getParameter("address"));
		inVO.setPhone(req.getParameter("phone"));
		
		int flag = userSvc.do_update(inVO);
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("blog/post/post_list");//List
		modelAndView.addObject("inVO", inVO);
		
		return modelAndView;
	}
	
	// ȸ������ �������� �̵�(��α�)
	@RequestMapping(value="blog/do_blog_updateForm.do", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView do_blog_update(HttpSession session, HttpServletRequest req) {
		
		UserVO inVO = new UserVO();
		UserVO inVO2 = new UserVO();
		
		String user_id = (String)session.getAttribute("user_id");
		
		inVO.setUser_id(user_id);
		
		inVO2=userSvc.viewMember(inVO);
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("blog/user/user_modify");//List
		modelAndView.addObject("inVO", inVO2);
		
		return modelAndView;
		
	}
	
	// ȸ������(��α�)
	@RequestMapping(value="blog/do_blog_delete.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_blog_delete(HttpServletRequest req) throws IOException {
		
		UserVO inVO=new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		String user_password = "$#%&(*&$uy@#5s";
		inVO.setUser_password(user_password);
		int withdraw_flag = 0;
		inVO.setWithdraw_flag(withdraw_flag);
		
		int flag = userSvc.do_delete(inVO);
		
		return "redirect:do_blog_logout.do";
	}
	
	// �α��� ȭ������ ��(��α�)
	@RequestMapping(value="blog/blog_login_page.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_blog_login(HttpServletRequest req) throws IOException {
		
		
		
		return "blog/user/user_login";
	}
	
	// ȸ������ ȭ������ ��(��α�)
	@RequestMapping(value="blog/blog_do_look.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_blog_look(HttpServletRequest req) throws IOException {
		
		return "blog/user/user_register";
	}
	
	// �α��� ó��(����Ȩ)
	@RequestMapping(value="blog/blog_do_loginCheck.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	
	public String do_blog_loginCheck(HttpSession session, HttpServletRequest req, @RequestParam(value="user_id", required=true) String user_id
            , @RequestParam(value="user_password",required=true) String user_password, @RequestParam(value="login_id",required=true) String login_id, HttpServletResponse response) throws IOException {
		
		UserVO inVO = new UserVO();
		
		String url = "";
		
		inVO.setUser_id(login_id);
		inVO.setUser_password(user_password);
		
		boolean result = userSvc.do_loginCheck(inVO);

		if(result == true) {
			url = "redirect:/blog/post/post_doSearch.do?user_id="+user_id;
			session.setAttribute("user_id", login_id);
		}else {
			 response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('로그인 정보가 일치하지 않습니다.'); history.go(-1);</script>");
	            out.flush();
			
		}
		
		return url;
	}
	
	// �α� �ƿ�(��α�)
	@RequestMapping(value="blog/do_blog_logout.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	
	public ModelAndView do_blog_logout(HttpSession session) throws IOException {
		
		userSvc.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/user/user_login");
		mav.addObject("msg", "logout");
		
		return mav;
		
	}

	// ====================================================================================================	
	// ���� 
	// ====================================================================================================
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
		int withdraw_flag = 1;
		inVO.setWithdraw_flag(withdraw_flag);
		
		int flag = 0;
		flag = userSvc.do_save(inVO);
		
		return "redirect:login_page.do";
	}
	
	// ȸ�� ����(��α�)
	@RequestMapping(value="user/do_update.do", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView do_updateForm(HttpServletRequest req) throws IOException {
		
		UserVO inVO=new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		inVO.setUser_password(req.getParameter("user_password"));
		inVO.setUser_name(req.getParameter("user_name"));
		int age = Integer.parseInt(req.getParameter("age").toString());
		inVO.setAge(age);
		inVO.setEmail(req.getParameter("email"));
		inVO.setAddress(req.getParameter("address"));
		inVO.setPhone(req.getParameter("phone"));
		
		int flag = userSvc.do_update(inVO);
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("main/home_main");//List
		modelAndView.addObject("inVO", inVO);
		
		return modelAndView;
	}
	
	// ȸ������ �������� �̵�(��α�)
	@RequestMapping(value="user/do_updateForm.do", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView do_update(HttpSession session, HttpServletRequest req) {
		 
		UserVO inVO = new UserVO();
		UserVO inVO2 = new UserVO();
		
		String user_id = (String)session.getAttribute("user_id");
		
		inVO.setUser_id(user_id);
		
		inVO2=userSvc.viewMember(inVO);
		
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("main/user/user_modify");//List
		modelAndView.addObject("inVO", inVO2);
		
		return modelAndView;
		
	}
	
	// ȸ������(��α�)
	@RequestMapping(value="user/do_delete.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_delete(HttpServletRequest req) throws IOException {
		
		UserVO inVO=new UserVO();
		
		inVO.setUser_id(req.getParameter("user_id"));
		String user_password = "$#%&(*&$uy@#5s";
		inVO.setUser_password(user_password);
		int withdraw_flag = 0;
		inVO.setWithdraw_flag(withdraw_flag);
		
		
		int flag = userSvc.do_delete(inVO);
		
		return "redirect:do_logout.do";
	}
	
	// �α��� ȭ������ ��(��α�)
	@RequestMapping(value="user/login_page.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_login() throws IOException {
		
		return "main/user/user_login";
	}
	
	// ȸ������ ȭ������ ��(��α�)
	@RequestMapping(value="user/do_look.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String do_look(HttpServletRequest req) throws IOException {
		
		return "main/user/user_register";
	}
	
	// �α��� ó��(����Ȩ)
	@RequestMapping(value="user/do_loginCheck.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	
	public String do_loginCheck(HttpSession session, HttpServletRequest req, @RequestParam(value="user_id", required=true) String user_id
            , @RequestParam(value="user_password",required=true) String user_password, HttpServletResponse response) throws IOException {
		
		UserVO inVO = new UserVO();
		
		String url = "";

		inVO.setUser_id(user_id);
		inVO.setUser_password(user_password);
		
		boolean result = userSvc.do_loginCheck(inVO);

		if(result == true) {
			url = "redirect:/main/home_main.do";
			//mav.setViewName("main/home_main");
			session.setAttribute("user_id", user_id);
		}else {
			 response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('로그인 정보가 일치하지 않습니다.'); history.go(-1);</script>");
	            out.flush();
			
		}
		
		return url;
	}
	
	// �α� �ƿ�(��α�)
	@RequestMapping(value="user/do_logout.do" ,method= {RequestMethod.POST,RequestMethod.GET})
	
	public ModelAndView do_logout(HttpSession session) throws IOException {
		
		userSvc.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/user/user_login");
		mav.addObject("msg", "logout");
		
		return mav;
		
	}
	
	@RequestMapping(value="user/do_idCheck.do", method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String do_idcheck(HttpServletRequest req) throws DataAccessException, IOException{
	
		UserVO inVO = new UserVO();
		inVO.setUser_id(req.getParameter("user_id"));
		
		int selectUseridCheck = userSvc.do_idCheck(inVO);
		
		if(selectUseridCheck == 0) {
			return "true";
		}
		else {
			return "false";
		}
		
	}
	
	
	
	
	
}
