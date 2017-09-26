package project.mc.blog.portfolio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import project.mc.blog.portfolio.dao.PortfolioDao;
import project.mc.blog.user.dao.UserDao;
import project.mc.commons.DTO;

@Service
public class PortFolioSvcImpl implements PortfolioSvc {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private PortfolioDao pfDao;
	
//	@Autowired
//	private Validator validator;

	@Override
	public int do_save(DTO dto) throws DataAccessException {
		log.debug("======PortfolioDaoImpl: do_save=================");
		log.debug("PfVO: "+dto.toString());
		log.debug("======PortfolioDaoImpl: do_save=================");
		
		return pfDao.do_save(dto);
	}

	
	
}
