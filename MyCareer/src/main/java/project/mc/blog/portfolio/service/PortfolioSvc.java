package project.mc.blog.portfolio.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import project.mc.commons.DTO;

public interface PortfolioSvc {
	
	/**
	 * 0이면 실패 1이면 성공
	 * @param portfolioVO
	 * @return flag
	 * @throws DataAccessException
	 */
	int do_save(DTO dto) throws DataAccessException;

	List<?> do_searchByUser_no(DTO dto);

	DTO do_searchByPf_id(DTO dto);

	List<?> do_search(DTO dto);

	int do_update(DTO dto);

	int do_deleteAll(DTO dto);

	int do_delete(DTO dto);

}
