package project.mc.blog.recruit.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.mc.blog.recruit.domain.ParseVO;

import project.mc.commons.RecruitParse;
import project.mc.commons.StringUtil;

public class Recruit_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="recruit_page.do")
	public ModelAndView recruitPaging(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		ParseVO vo = new ParseVO();
		List<ParseVO> list = new ArrayList<ParseVO>();
		
		Hashtable<String,String> param = new Hashtable<String, String>();
		String pageSize = StringUtil.nvl(req.getParameter("page_size"), "10");
		String pageNo = StringUtil.nvl(req.getParameter("page_num"), "1");
		vo.setTotalNo(100);
		RecruitParse rp = new RecruitParse();
		list = rp.SaramParse(pageNo);
		
		
		
		log.debug("list=" + list.size());
		
		
		
		
		
		
		
		param.put("pageSize", pageSize);
		param.put("pageNo", pageNo);
		
		vo.setParam(param);
		
		
		
		mav.setViewName("recruit");
		
		
		
		return mav;
		
	}
	
}
