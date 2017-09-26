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
	
	
	
	/**
	 * 포트폴리오 전체 검색
	 */
	@Override
	public List<?> do_search(DTO dto) {
		String statement = namespace +".do_search";
		List<PortfolioVO> list = sqlSession.selectList(statement);
		log.debug("======PortfolioDaoImpl: do_search======");
		log.debug("list: "+list.toString());
		log.debug("======PortfolioDaoImpl: do_search======");
		
		return list;
	}
	
	@Override
	public DTO do_searchByPf_id(DTO dto) {
		String statement = namespace +".do_searchByPf_id";
		PortfolioVO inPfVo = (PortfolioVO)dto;
		PortfolioVO outPfVo = sqlSession.selectOne(statement, inPfVo);
		log.debug("======PortfolioDaoImpl: do_searchByPf_id======");
		log.debug("list: "+outPfVo.toString());
		log.debug("======PortfolioDaoImpl: do_searchByPf_id======");
		
		return outPfVo;
	}
	
	@Override
	public List<?> do_searchByUser_no(DTO dto) {
		String statement = namespace +".do_searchByUser_no";
		PortfolioVO inPfVo = (PortfolioVO)dto;
		List<PortfolioVO> list = sqlSession.selectList(statement, inPfVo);
		log.debug("======PortfolioDaoImpl: do_searchByUser_no======");
		log.debug("list: "+list.toString());
		log.debug("======PortfolioDaoImpl: do_searchByUser_no======");
		
		return list;
	}
	
	/**
	 * 포트폴리오 저장
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
	 * 포트폴리오 삭제
	 */
	@Override
	public int do_delete(DTO dto) {
		int flag = 0;
		String statement = namespace +".do_delete";
		PortfolioVO inPfVo = (PortfolioVO)dto;
		flag = sqlSession.delete(statement, inPfVo);
		log.debug("======PortfolioDaoImpl: do_delete======");
		log.debug("flag: "+flag);
		log.debug("======PortfolioDaoImpl: do_delete======");
		
		return flag;
	}
	
	@Override
	public int do_deleteAll(DTO dto) {
		int flag = 0;
		String statement = namespace +".do_deleteAll";
		flag = sqlSession.delete(statement);
		log.debug("======PortfolioDaoImpl: do_deleteAll======");
		log.debug("flag: "+flag);
		log.debug("======PortfolioDaoImpl: do_deleteAll======");
		
		return flag;
	}
	
	/**
	 * 포트폴리오 수정
	 */
	@Override
	public int do_update(DTO dto) {
		int flag = 0;
		String statement = namespace +".do_update";
		UserVO inUserVo = (UserVO)dto;
		flag = sqlSession.update(statement, inUserVo);
		log.debug("======PortfolioDaoImpl: do_update======");
		log.debug("flag: "+flag);
		log.debug("======PortfolioDaoImpl: do_update======");
		
		return flag;
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
