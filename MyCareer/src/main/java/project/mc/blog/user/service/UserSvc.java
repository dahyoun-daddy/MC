package project.mc.blog.user.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import project.mc.commons.DTO;
/**
 * UserSvc.java
 * @author sist
 *
 */
@Transactional
public interface UserSvc {
	
	public List<?> do_login(DTO dto) throws DataAccessException;
	
	public int do_delete(DTO dto) throws DataAccessException;
	
	public int do_update(DTO dto) throws DataAccessException;
	
	/**
	 * 1이면 성공 그렇치 않으면 실패
	 * @param dto
	 * @return 1 
	 * @throws DataAccessException
	 */
	public int do_save(DTO dto) throws DataAccessException;
	
	/**
	 * 1성공 그외 실패
	 * @param dto
	 * @return
	 * @throws DataAccessException
	 */
	public int do_idCheck(DTO dto) throws DataAccessException;
}
