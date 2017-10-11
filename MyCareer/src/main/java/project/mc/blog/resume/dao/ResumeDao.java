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
	

	/**
	 * 포트폴리오의 이미지 조회
	 * @param dto
	 * @return
	 */
	public List<?> do_search_img(DTO dto);
	
	/**
	 * 포트폴리오의 upsert
	 * @param dto
	 * @return
	 */
	int do_upsert(DTO dto);
	
	/**
	 * 포트폴리오의 delete
	 * @param dto
	 * @return
	 */
	int do_delete_img(DTO dto);
}
