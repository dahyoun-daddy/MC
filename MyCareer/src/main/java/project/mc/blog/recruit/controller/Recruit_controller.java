package project.mc.blog.recruit.controller;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.mc.commons.StringUtil;

public class Recruit_controller {
	
	@RequestMapping(value="recruit_page.do")
	public ModelAndView recruitPaging(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		Hashtable<String,String> param = new Hashtable<String, String>();
		String pageSize = StringUtil.nvl(req.getParameter("page_size"), "10");
		String pageNo = StringUtil.nvl(req.getParameter("page_num"), "1");
		
		
		return mav;
		
	}
	
}
