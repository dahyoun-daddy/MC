package project.mc.blog.user.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import project.mc.blog.user.dao.UserDao;
import project.mc.blog.user.domain.UserVO;
import project.mc.commons.DTO;
/**
 * UserSvcImpl.java
 * @author sist
 *
 */ 
@Service
public class UserSvcImpl implements UserSvc {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private UserDao userDao;
	
	
	public int do_save(DTO dto){
		
		
		return userDao.do_save(dto);
	}

	
	public int do_idCheck(UserVO vo) {
		
		int flag = userDao.do_idCheck(vo);
		return flag;
		
	}

	@Override
	public int do_update(DTO dto){
		
		return userDao.do_update(dto);
	}

	
	public int do_delete(DTO dto){
		
		int flag = userDao.do_delete(dto);
	
		return userDao.do_delete(dto);		
	}



	@Override
	public void logout(HttpSession session) {
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}


	@Override
	public boolean do_loginCheck(UserVO vo) {
		
		boolean result = userDao.do_loginCheck(vo);
		
		return result;
	}


	@Override
	public UserVO viewMember(UserVO vo) {
		
		return userDao.viewMember(vo);
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
