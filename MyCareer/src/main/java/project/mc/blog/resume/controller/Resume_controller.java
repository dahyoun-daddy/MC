package project.mc.blog.resume.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import project.mc.blog.resume.domain.ResumeVO;
import project.mc.blog.resume.service.ResumeSvc;
import project.mc.commons.DTO;

public class Resume_controller {
	private Logger log = LoggerFactory.getLogger(Resume_controller.class);
	
	@Autowired
	ResumeSvc resumeSvc;
	
	@Resource(name="downloadView")
	private View downloadView;
	
	@RequestMapping(value="blog/resume/resume.do", method = RequestMethod.GET)
	public String resume() {
		return "blog/resume/resume";
	}
	
	/*@RequestMapping(value="blog/resume_save.do", method = RequestMethod.POST)
	public String resume_save(HttpServletRequest req){
		ResumeVO inVO = new ResumeVO();
		int flag = -1;
		
		String reg_id = req.getParameter("user_id").toString();
		inVO.setReg_id(reg_id);
		inVO.setFile_path(req.getParameter("file_path"));
		inVO.setFile_size(req.getParameter("file_size"));
		inVO.setOrg_file_name(req.getParameter("org_file_name"));
		inVO.setSave_file_name(req.getParameter("save_file_name"));
		inVO.setFile_ext(req.getParameter("file_ext"));
		
		flag = resumeSvc.do_save(inVO);
		
		return "";
	}*/
	@RequestMapping(value="blog/resume_upload.do", method = RequestMethod.POST)
	public ModelAndView do_saveSubmit(MultipartHttpServletRequest mReq)
			throws IOException, DataAccessException{
		ModelAndView modelAndView = new ModelAndView();
		List<DTO> list = resumeSvc.do_saveMulti(mReq);
		for(DTO vo : list) {
			ResumeVO resumeVO = (ResumeVO)vo;
			log.debug("Resume_controller 입니다");
			log.debug("resumeVO의 값은 : " + resumeVO.toString());
			log.debug("Resume_controller 입니다");
		}
		modelAndView.setViewName("blog/resume/upload");
		modelAndView.addObject("resume_list", list);
		return modelAndView;
	}
}
