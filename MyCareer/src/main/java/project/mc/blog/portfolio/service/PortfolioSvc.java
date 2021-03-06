package project.mc.blog.portfolio.service;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.mc.commons.DTO;

public interface PortfolioSvc {
	
	/**
	 * 0이면 실패 1이면 성공
	 * @param mreq
	 * @return flag
	 * @throws DataAccessException
	 * @throws IOException 
	 */
	DTO do_save(MultipartHttpServletRequest mreq) throws DataAccessException, IOException;

	List<?> do_searchByUser_id(DTO dto);

	DTO do_searchByPf_id(DTO dto);

	List<?> do_search(DTO dto);

	int do_deleteAll(DTO dto);

	int do_delete(DTO dto);

	int do_update(MultipartHttpServletRequest mReq) throws DataAccessException, IOException;

	List<DTO> do_upsertImages(MultipartHttpServletRequest mReq) throws IOException, DataAccessException;


}
