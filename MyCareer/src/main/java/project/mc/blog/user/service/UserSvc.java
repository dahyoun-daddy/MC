package project.mc.blog.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import project.mc.blog.user.domain.UserVO;
import project.mc.commons.DTO;
/**
 * UserSvc.java
 * @author sist
 *
 */
@Transactional
public interface UserSvc {
	
	public int do_delete(DTO dto) throws DataAccessException;
	
	public int do_update(DTO dto) throws DataAccessException;
	
	
	public int do_save(DTO dto) throws DataAccessException;
	
	
	public int do_idCheck(DTO dto) throws DataAccessException;
	
	
	public void logout(HttpSession session);

	public boolean do_loginCheck(UserVO inVO);
	
	// 로그인 정보
	public UserVO viewMember(UserVO vo);
	
	

	

	

	

	

	
}
