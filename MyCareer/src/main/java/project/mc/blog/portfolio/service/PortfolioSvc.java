package project.mc.blog.portfolio.service;

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

}
