package project.mc.blog.user.service;

import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import project.mc.blog.user.dao.UserDao;
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

	
	public int do_update(DTO dto){
		log.debug("do_update=======================");
		log.debug(dto.toString());
		int flag = userDao.do_update(dto);
		log.debug("flag do_update:::::::::::"+flag);
		log.debug("do_update=======================");
		
		return userDao.do_update(dto);
	}

	
	public int do_delete(DTO dto){
		log.debug("do_delete=======================");
		log.debug(dto.toString());
		int flag = userDao.do_delete(dto);
		log.debug("22222222222222222flag======================="+flag);	
		log.debug("do_delete=======================");	
		return userDao.do_delete(dto);		
	}


	
	public List<?> do_login(DTO dto) throws DataAccessException {
		log.debug("2=======================");
		log.debug(dto.toString());
		log.debug("2=======================");
		
		return userDao.do_login(dto);
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
