package project.mc.blog.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


import project.mc.blog.user.domain.UserVO;
import project.mc.commons.DTO;

@Repository
public class UserDaoImpl implements UserDao {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	private final String namespace
	= "project.mc.blog.user.repository.mappers.user";
	
	
	
	@Override
	public List<?> do_search(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public int do_save(DTO dto) throws DataAccessException{

		int flag = 0;
		try {
			String statement = namespace +".do_save";
			UserVO inUserVo = (UserVO)dto;
			flag = sqlSession.insert(statement, inUserVo);
		}catch(DataAccessException e) {
			throw e;
		}	
		
		return flag;
	}

	
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
	
	@Override
	public int do_update(DTO dto) {
		
		int flag = 0;
		try {
			String statement = namespace +".do_update";
			UserVO inUserVo = (UserVO)dto;
			log.debug("들어간다@@@@@@@@@@@@@");
			flag = sqlSession.update(statement, inUserVo);
		}catch(DataAccessException e) {
			throw e;
		}	
		
		return flag;
		
	}

	
	public int do_idCheck(UserVO vo) {
		int flag = 0;
			String statement = namespace +".do_idCheck";
			String inUserVo = vo.getUser_id();
			flag = sqlSession.selectOne(statement, inUserVo);
		
		return flag;
	}
	
	@Override
	public boolean do_loginCheck(UserVO vo) {
		
	    String statement = namespace +".do_loginCheck";
		String flag = sqlSession.selectOne(statement, vo);
		return (flag == null) ? false : true;
	}
	
	@Override
	public void logout(HttpSession session) {
		
		
	}
	
	
	@Override
	public UserVO viewMember(UserVO vo) {
		
		UserVO inVO = new UserVO();
		
		String statement = namespace +".do_viewMember";
		inVO = sqlSession.selectOne(statement, vo);
		
		return inVO;
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
