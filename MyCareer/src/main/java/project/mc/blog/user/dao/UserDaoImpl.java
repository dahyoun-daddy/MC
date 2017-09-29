package project.mc.blog.user.dao;

import java.util.Hashtable;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.mc.blog.user.domain.UserVO;
import project.mc.commons.DTO;
/**
 * UserDaoImpl.java
 * 회원가입 메소드 정의
 * @author sist
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace
	= "project.mc.user.repository.mappers.user";
	
	
	@Override
	public int do_login(DTO dto) throws DataAccessException {
		log.debug("========debug!!!!!!!!======");
		String statement = namespace +".do_login";
		UserVO inUserVo = (UserVO)dto;
		int flag = 0;
		UserVO outUserVo = sqlSession.selectOne(statement, inUserVo);
		log.debug("***********************");
		log.debug("*do_login******************"+dto.toString());
		log.debug("***********************");
		flag = outUserVo.getDo_login();
		return flag;
	}
	
	
	/**
	 * 회원가입 저장
	 * (0:실패, 1:성공)
	 */
	@Override
	public int do_save(DTO dto) throws DataAccessException{

		int flag = 0;
		try {
			String statement = namespace +".do_save";
			UserVO inUserVo = (UserVO)dto;
			flag = sqlSession.update(statement, inUserVo);
		}catch(DataAccessException e) {
			throw e;
		}	
		
		return flag;
	}

	/**
	 * 회원탈퇴
	 * (0:탈퇴, 1:존재)
	 */
	@Override
	public int do_delete(DTO dto) {
		int flag = 0;
		try {
			String statement = namespace +".do_delete";
			UserVO inUserVo = (UserVO)dto;
			flag = sqlSession.delete(statement, inUserVo);
		}catch(DataAccessException e) {
			throw e;
		}	
		
		return flag;
	}

	/**
	 * 회원가입 수정
	 * (0:수정안됨, 1:수정됨)
	 */
	@Override
	public int do_update(DTO dto) {
		int flag = 0;
		try {
			String statement = namespace +".do_update";
			UserVO inUserVo = (UserVO)dto;
			flag = sqlSession.update(statement, inUserVo);
			log.debug("11111111111flag::::::::::::::::::::"+flag);
		}catch(DataAccessException e) {
			throw e;
		}	
		
		return flag;
	}

	/**
	 * 아이디 중복 체크
	 */
	public int do_idCheck(DTO dto) {
			int flag = 0;
			log.debug("UserDaoImpl - id_check");
			String statement = namespace +".do_idCheck";
			UserVO inUserVo = (UserVO)dto;
			UserVO outUserVO = sqlSession.selectOne(statement, inUserVo);
			flag = outUserVO.getDo_idCheck();
			
			log.debug("flag: "+ flag);
		
		return flag;
	}
	
	
	
	
	
	
	
	
	@Override
	public List<?> do_search(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<?> do_excelDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int do_excelUp(List<?> list) {
		// TODO Auto-generated method stub
		return 0;
	}


	


	

	
	
}
