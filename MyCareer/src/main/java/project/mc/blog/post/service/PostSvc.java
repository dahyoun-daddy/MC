package project.mc.blog.post.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import project.mc.blog.post.domain.DTO;

@Transactional
public interface PostSvc {
	public DTO do_searchOne(DTO dto);
	
	public int do_save(DTO dto)throws DataAccessException;
	
	public List<?> do_search(DTO dto) ;
	
	/**
	 * ?��?��
	 * @param dto
	 * @return int
	 */
	public int do_delete(DTO dto);

	int do_update(DTO dto);
	
	
	/**
	 * ?��건삭?��
	 * @param dto
	 * @return int
	 */
	//public int do_delete(List<UserVO> list);
	
	public int do_checkedDelete(List<String> list);
	
}
