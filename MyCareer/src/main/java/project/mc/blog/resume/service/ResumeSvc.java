package project.mc.blog.resume.service;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.mc.commons.DTO;

/**
 * 
 * @author 홍준석
 * 작성일 : 2017년 9월 27일
 */
public interface ResumeSvc {
	
	public int do_save(DTO dto) throws DataAccessException;
	
	public List<DTO> do_saveMulti(MultipartHttpServletRequest mReq) throws IOException, DataAccessException;
}