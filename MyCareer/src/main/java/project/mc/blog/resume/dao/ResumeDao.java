package project.mc.blog.resume.dao;

import java.util.List;

import project.mc.commons.DTO;
import project.mc.commons.WorkDiv;

/**
 * 
 * @author 홍준석
 * 작성일 : 2017년 9월 27일
 *
 */
public interface ResumeDao extends WorkDiv{

	/**
	 * 이력서 전체 삭제
	 * @param dto
	 * @return
	 */
	public int do_deleteAll(DTO dto);
	
	/**
	 * 단건 조회
	 */
	public DTO do_searchOne(DTO dto);
	
	public List<?> do_search(DTO dto);
}
