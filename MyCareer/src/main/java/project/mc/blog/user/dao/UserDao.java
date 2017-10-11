package project.mc.blog.user.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;

import project.mc.blog.user.domain.UserVO;
import project.mc.commons.DTO;
import project.mc.commons.WorkDiv;

public interface UserDao extends WorkDiv {
	
	public int do_idCheck(DTO dto) throws DataAccessException;

	// 로그 아웃
	public void logout(HttpSession session);
	
	// 회원 정보 업데이트
	public int update(UserVO vo);

	// 로그인 체크하기
	public boolean do_loginCheck(UserVO vo);
	// 로그인 정보
	public UserVO viewMember(UserVO vo);
	
	
	
}
