package project.mc.blog.post.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import project.mc.blog.post.dao.PostDao;
import project.mc.blog.post.domain.DTO;

@Service
public class PostSvcImpl implements PostSvc {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private PostDao postDao;
	
	@Override
	public DTO do_searchOne(DTO dto) {
		log.debug("=======================");
		log.debug(dto.toString());
		log.debug("=======================");	
		return postDao.do_searchOne(dto);
	}

	@Override
	public int do_save(DTO dto) throws DataAccessException {
		log.debug("2=======================");
		log.debug(dto.toString());
		log.debug("2=======================");
		return postDao.do_save(dto);
	}

	@Override
	public List<?> do_search(DTO dto) {
		log.debug("3=======================");
		log.debug(dto.toString());
		log.debug("3=======================");	
		return postDao.do_search(dto);
		
	}

	@Override
	public int do_delete(DTO dto) {
		log.debug("4=======================");
		log.debug(dto.toString());
		log.debug("4=======================");	
		return postDao.do_delete(dto);
	}



}
