package project.mc.blog.resume.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;

import project.mc.blog.resume.domain.ResumeVO;
import project.mc.blog.resume.service.ResumeSvc;
import project.mc.blog.user.service.UserSvc;
import project.mc.commons.DTO;

@Controller
public class Resume_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ResumeSvc resumeSvc;
	
	@Autowired
	UserSvc userSvc;
	
	@Resource(name="downloadView")
	private View downloadView;
	
	/*@RequestMapping(value="blog/resume/resume.do", method = RequestMethod.GET)
	public String resume() {
		return "blog/resume/resume";
	}*/
	
	@RequestMapping(value="blog/resume/resume.do", method=RequestMethod.GET)	
	public ModelAndView resume_search(HttpServletRequest req) {
		ResumeVO inVO = new ResumeVO();
		//블로그 주인의 user_id
		String user_id = "";
		
		if(req.getParameter("user_id") != null) {
			user_id = req.getParameter("user_id").toString();
		}else {
			//TODO null 처리
			log.debug("블로그 주인의 user_id를 찾지 못했습니다");
		}
		String reg_id = user_id;
		//String reg_id = "joon";
		inVO.setReg_id(reg_id);
		
		log.debug("Resume_controller의 resume.do 부분입니다.");
		
		log.debug("Resume_controller의 resume.do 부분입니다.");		
		List<ResumeVO> list = (List<ResumeVO>) resumeSvc.do_search(inVO);		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("user_id", user_id);
		
		
		modelAndView.setViewName("blog/resume/resume");
		
		return modelAndView;
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
	
//	@RequestMapping(value="blog/resume/upload.do", method = RequestMethod.GET)
//	public String upload() {
//		return "blog/resume/resume";
//	}
	
	
//	@RequestMapping(value="blog/resume/upload.do", method = RequestMethod.POST)
//	public ModelAndView do_saveSubmit(MultipartHttpServletRequest mReq)
//			throws IOException, DataAccessException{
//		ModelAndView modelAndView = new ModelAndView();
//		List<DTO> list = resumeSvc.do_saveMulti(mReq);
//		for(DTO vo : list) {
//			ResumeVO resumeVO = (ResumeVO)vo;
//			log.debug("Resume_controller 입니다");
//			log.debug("resumeVO의 값은 : " + resumeVO.toString());
//			log.debug("Resume_controller 입니다");
//		}
//		modelAndView.setViewName("blog/resume/resume");
//		modelAndView.addObject("resume_list", list);
//		return modelAndView;
//	}
	
	@RequestMapping(value="blog/resume/upload.do", method = RequestMethod.POST)
	public String do_saveSub(MultipartHttpServletRequest mReq)
			throws IOException, DataAccessException{
		ModelAndView modelAndView = new ModelAndView();
		List<DTO> list = resumeSvc.do_saveMulti(mReq);
		for(DTO vo : list) {
			ResumeVO resumeVO = (ResumeVO)vo;
			log.debug("Resume_controller 입니다");
			log.debug("resumeVO의 값은 : " + resumeVO.toString());			
			log.debug("Resume_controller 입니다");
		}
		return "redirect:resume.do";
	}
	
	@RequestMapping(value="blog/resume/do_checkedDelete.do", method=RequestMethod.POST)
	@ResponseBody
	public String do_checkedDelete(HttpServletRequest req) throws IOException{
		String ret = req.getParameter("file_idList");
		log.debug("Resume_controller의 do_checkedDelete입니다");
		log.debug("ret :" + ret);
		
		Gson gson = new Gson();
		
		List<String> list = gson.fromJson(ret, List.class);
		log.debug("file_idList: " + list);
		
		int flag = resumeSvc.do_checkDelete(list);
		log.debug("삭제건수 :" + flag);
		
		Gson gsonOut = new Gson();
		ResumeVO resumeVO = new ResumeVO();
		resumeVO.setNo(flag);
		return gsonOut.toJson(resumeVO);		
	}
	
	@RequestMapping(value="blog/resume/download.do", method=RequestMethod.GET)	
	public ModelAndView downloadSubmit (HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();
		String path = req.getParameter("file_path");
		String fileName = req.getParameter("save_file_name");
		//String downOrgFile = req.getParameter("org_file_name");
		log.debug("ResumeController의 downloadSubmit 부분입니다.");
		log.debug("path: " + path);
		log.debug("fileName :" + fileName);
		//log.debug("downOrgFile: " + downOrgFile);
		log.debug("ResumeController의 downloadSubmit 부분입니다.");		
		//xml -> FileDownload bean 호출
		String fullPath = path + fileName;
		log.debug(fullPath);
		modelAndView.setView(downloadView);
		
		File downloadFile = new File(fullPath);
		//File orgFileName = new File(downOrgFile);
		log.debug("downloadFile: " + downloadFile.getName());
		log.debug("downloadFile: " + downloadFile.getPath());
		log.debug("downloadFile: " + downloadFile.toString());
		modelAndView.addObject("downloadFile", downloadFile);
		//modelAndView.addObject("orgFileName", orgFileName);
		return modelAndView;
	}
	
//	@RequestMapping(value="blog/resume/download.do", method=RequestMethod.GET)
//	public void fileDownload(HttpServletRequest req, HttpServletResponse res) throws Exception{
//		log.debug("새로운 다운로드입니다");
//		String save_file_name = req.getParameter("save_file_name");
//		String org_file_name = req.getParameter("org_file_name");		
//		org_file_name = new String(org_file_name.getBytes("ISO8859_1"),"UTF-8");
//		log.debug("Resume_controller의 fileDownload 부분입니다");
//		log.debug("save_file_name: " + save_file_name);
//		log.debug("org_file_name: " + org_file_name);
//		
//		
//		String path = req.getParameter("file_path");
//		//String path = "C:\\file\\download\\";
//		String fullPath = path + save_file_name;
//		File downloadFile = new File(fullPath);
//		
//		log.debug("Resume_controller의 fileDownload 부분입니다");
//		log.debug("path: " + path);
//		log.debug("fullPath: " + fullPath);
//		
//		//req.getSer
//		
//		res.setContentLength((int)downloadFile.length());
//		
//		//파일 다운로드를 위해 컨텐트타입을 application/download 설정
//		res.setContentType("application/octet-stream; charset=utf-8");
//		res.setHeader("Content-Disposition", "attachment;filename=" + new String(org_file_name.getBytes(), "ISO8859_1"));
//		
//		res.setHeader("Content-Transfer-Encoding", "binary");
//		
//		FileInputStream fis = new FileInputStream(downloadFile);
//		OutputStream sout = res.getOutputStream();
//		
////		byte[] buf = new byte[1024];
////		int size = -1;
////		
////		while((size = fis.read(buf, 0, buf.length))!=-1) {
////			sout.write(buf, 0, size);
////		}
//		FileCopyUtils.copy(fis, sout);
//		fis.close();
//		sout.close();
//
//	}
}
