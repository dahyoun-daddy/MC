package project.mc.blog.user.service;

import java.io.PrintWriter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
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

	@Override
	public int do_save(DTO dto) throws DataAccessException {
		log.debug("2=======================");
		log.debug(dto.toString());
		log.debug("2=======================");
		
		return userDao.do_save(dto);
	}

	@Override
	public int id_check(DTO dto) throws DataAccessException {
		log.debug("UserSvcImpl - id_check");
		int flag = userDao.id_check(dto);
		log.debug("UserSvcImpl - id_check: flag: "+flag);
		
		return flag;
		
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
