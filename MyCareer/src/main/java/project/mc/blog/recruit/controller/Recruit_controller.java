package project.mc.blog.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.mc.blog.recruit.domain.ParseVO;

import project.mc.commons.RecruitParse;

@Controller
public class Recruit_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="blog/recruit/recruit.do",method=RequestMethod.GET)
	public ModelAndView do_saram() throws Exception {
		log.debug("recruit Cont");
		RecruitParse doc = new RecruitParse();
		ParseVO vo = new ParseVO();
		List<ParseVO> list = new ArrayList<ParseVO>();
		List<ParseVO> outList = new ArrayList<ParseVO>();
		list = doc.SaramParse();
		log.debug("parse=" + list.size());
		for(int i=0;i<10;i++) {
			outList.add(list.get(i));
		}

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/recruit/recruit");
		mav.addObject("list", outList);
		
		return mav;
	}
	
	@RequestMapping(value="blog/recruit/parse.do",method=RequestMethod.GET)
	public ModelAndView parse(HttpServletRequest req) throws Exception {
		//(#{page_size} * (#{page_num}-1)+1) AND (#{page_size} * (#{page_num}-1)+#{page_size})
		RecruitParse doc = new RecruitParse();
		ParseVO vo = new ParseVO();
		List<ParseVO> list = new ArrayList<ParseVO>();
		List<ParseVO> outList = new ArrayList<ParseVO>();
		list = doc.SaramParse();
		int cnt = 0;
		int page_size = 10;
		int page_num = Integer.parseInt(req.getParameter("page_num"));
		int startIdx = (page_num-1)+1;
		int endIdx = ((page_num-1)+page_size);
		

		log.debug("startIdx=" + startIdx);
		log.debug("endIdx=" + endIdx);
		
		log.debug("parse=" + list.size());
		for(int i=0;i<list.size();i++) {
			if((startIdx<=i)&&(endIdx>=i)) {
				outList.add(list.get(i));
			}
		}
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog/recruit/recruit");
		mav.addObject("list", outList);
		
		return mav;
		
	}
	
}
