package project.mc.blog.portfolio.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.mc.blog.portfolio.domain.PortfolioVO;
import project.mc.blog.user.domain.UserVO;
import project.mc.commons.DTO;

@Repository
public class PortfolioDaoImpl implements PortfolioDao {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace
	= "project.mc.user.repository.mappers.portfolio";
	
	
	
	@Override
	public List<?> do_search(DTO dto) {
		// TODO Auto-generated method stub
		return null;
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
			PortfolioVO inPfVo = (PortfolioVO)dto;
			flag = sqlSession.update(statement, inPfVo);
			log.debug("======PortfolioDaoImpl: do_save======");
			log.debug("flag: "+flag);
			log.debug("======PortfolioDaoImpl: do_save======");
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 회원가입 수정
	 * (0:수정안됨, 1:수정됨)
	 */
	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
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
