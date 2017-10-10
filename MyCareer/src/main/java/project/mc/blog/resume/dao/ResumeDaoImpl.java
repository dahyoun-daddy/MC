package project.mc.blog.resume.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.mc.blog.resume.domain.ResumeVO;
import project.mc.blog.user.domain.UserVO;
import project.mc.commons.DTO;


/**
 * 
 * @author 홍준석
 * 작성일 : 2017년 9월 27일
 *
 */
@Repository
public class ResumeDaoImpl implements ResumeDao {
	private Logger log = LoggerFactory.getLogger(ResumeDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = "project.mc.user.repository.mappers.resume";
	
	/**
	 * 이력서 저장
	 */
	@Override
	public int do_save(DTO dto) throws DataAccessException{
		int flag = 0;
		try {
			String statement = namespace + ".do_save";
			log.debug("ResumeDaoImpl의 do_save 입니다");
			log.debug("statement 값은 : " + statement);
			log.debug("dto.toString()의 값은 : " + dto.toString());
			log.debug("ResumeDaoImpl의 do_save 입니다");
			ResumeVO vo = (ResumeVO)dto;
			flag = sqlSession.insert(statement, vo);
		}catch(DataAccessException e) {
			throw e;
		}
		return flag;
	}
	
	/**
	 * 이력서 전체 검색
	 */
	@Override
	public List<?> do_search(DTO dto) {
		String statement = namespace + ".do_search";
		log.debug("ResumeDaoImpl의 do_search 입니다");
		return sqlSession.selectList(statement);
	}

	@Override
	public int do_delete(DTO dto) {
		int flag = 0;
		String statement = namespace + ".do_delete";
		log.debug("ResumeDaoImpl의 do_delete 입니다");
		log.debug("statement의 값은 : " + statement );
		log.debug("dto.toString()의 값은 : " + dto.toString());
		log.debug("ResumeDaoImpl의 do_delete 입니다");
		ResumeVO inResumeVo = (ResumeVO) dto;
		flag = sqlSession.delete(statement, inResumeVo);
		return flag;
	}

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

	@Override
	public int do_deleteAll(DTO dto) {
		int flag = 0;
		String statement = this.namespace + ".do_deleteAll";
		ResumeVO inVO = (ResumeVO)dto;
		flag = sqlSession.delete(statement);
		log.debug("ResumeDaoImpl의 do_deleteAll입니다");
		log.debug("statement의 값은 : " + statement );
		log.debug("deleteAll의 flag값은 :" + flag ); 
		log.debug("ResumeDaoImpl의 do_deleteAll입니다");
		return flag;
	}

	@Override
	public DTO do_searchOne(DTO dto) {
		String statement = this.namespace + ".do_deleteAll";
		log.debug("ResumeDaoImpl의 do_searchOne입니다");
		log.debug("statement의 값은 : " + statement );
		log.debug("dto.toString()의 값은 : " + dto.toString());
		log.debug("ResumeDaoImpl의 do_searchOne입니다");
		ResumeVO inResumeVO = (ResumeVO) dto;
		
		return sqlSession.selectOne(statement, inResumeVO);
	}




}
