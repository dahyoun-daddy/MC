package project.mc.blog.portfolio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import project.mc.blog.portfolio.dao.PortfolioDao;
import project.mc.blog.portfolio.domain.PortfolioVO;
import project.mc.blog.user.dao.UserDao;
import project.mc.commons.DTO;

@Service
public class PortFolioSvcImpl implements PortfolioSvc {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private PortfolioDao pfDao;
	
//	@Autowired
//	private Validator validator;

	/**
	 * 저장
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_save(DTO dto) throws DataAccessException {
		log.debug("======PortfolioDaoImpl: do_save=================");
		log.debug("PfVO: "+dto.toString());
		log.debug("======PortfolioDaoImpl: do_save=================");
		
		return pfDao.do_save(dto);
	}

	/**
	 * 삭제
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_delete(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_delete=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_delete=================");
		return pfDao.do_delete(dto);		
	}
	
	/**
	 * 전체 삭제
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_deleteAll(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_deleteAll=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_deleteAll=================");
		return pfDao.do_deleteAll(dto);		
	}
	
	/**
	 * 수정
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_update(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_update=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_update=================");	
		return pfDao.do_update(dto);		
	}
	
	/**
	 * 전체조회
	 * @param dto
	 * @return  List<PortfolioVO>
	 */
	@Override
	public List<?> do_search(DTO dto){
		log.debug("======PortfolioDaoImpl: do_search=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_search=================");	
		return pfDao.do_search(dto);
	}
	
	/**
	 * pf_id에 의한 단건조회
	 * @param dto(pf_id=?)
	 * @return PortfolioVO
	 */
	@Override
	public DTO do_searchByPf_id(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_searchByPf_id=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_searchByPf_id=================");	
		return pfDao.do_searchByPf_id(dto);
	}
	
	/**
	 * user_no에 의한 list 조회
	 * @param dto(pf_id=?)
	 * @return PortfolioVO
	 */
	@Override
	public List<?> do_searchByUser_no(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_searchByUser_no=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_searchByUser_no=================");	
		return pfDao.do_searchByUser_no(dto);
	}
	
	
	
	
	
	
}
