package project.mc.blog.portfolio.dao;

import java.util.List;

import project.mc.commons.DTO;
import project.mc.commons.WorkDiv;

public interface PortfolioDao extends WorkDiv {
	
	/**
	 * 지정된 하나의 포트폴리오를 검색 
	 * @param dto
	 * @return
	 */
	DTO do_searchByPf_id(DTO dto);
	
	/**
	 * 로그인한 회원이 가지고 있는 포트폴리오를 모두 검색
	 * @param dto
	 * @return
	 */
	List<?> do_searchByUser_no(DTO dto);
	
	/**
	 * 포트폴리오 전체 삭제(디버그용)
	 * @param dto
	 * @return
	 */
	int do_deleteAll(DTO dto);

	
	
}
