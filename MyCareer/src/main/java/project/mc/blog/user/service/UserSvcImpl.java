package project.mc.blog.user.service;

import java.io.PrintWriter;

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
	
//	@Autowired
//	private Validator validator;

	
	public int do_save(DTO dto){
		log.debug("2=======================");
		log.debug(dto.toString());
		log.debug("2=======================");
		
		return userDao.do_save(dto);
	}

	
	public int do_idCheck(DTO dto) {
		log.debug("UserSvcImpl - id_check");
		int flag = userDao.do_idCheck(dto);
		log.debug("UserSvcImpl - id_check: flag: "+flag);
		
		return flag;
		
	}

	
	public int do_update(UserVO inVO, HttpSession session){
		int result = userDao.do_update(inVO);
		if(result == 1) {
			UserVO inVO2 = viewMember(inVO, session);
			// 세션변수 등록
			session.setAttribute("user_id", inVO2.getUser_id());
		}
		return result;
	}

	
	public int do_delete(DTO dto){
		log.debug("do_delete=======================");
		log.debug(dto.toString());
		int flag = userDao.do_delete(dto);
		log.debug("22222222222222222flag======================="+flag);	
		log.debug("do_delete=======================");	
		return userDao.do_delete(dto);		
	}



	@Override
	public void logout(HttpSession session) {
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}


	@Override
	public boolean do_loginCheck(UserVO inVO, HttpSession session) {
		boolean result = userDao.do_loginCheck(inVO);
		if(result) {
			UserVO inVO2 = viewMember(inVO, session);
			// 세션변수 등록
			session.setAttribute("user_id", inVO2.getUser_id());
			session.setAttribute("user_name", inVO2.getUser_name());
		}
		return result;
	}


	@Override
	public UserVO viewMember(UserVO inVO, HttpSession session) {
		
		return userDao.viewMember(inVO);
	}


	@Override
	public UserVO Member(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
