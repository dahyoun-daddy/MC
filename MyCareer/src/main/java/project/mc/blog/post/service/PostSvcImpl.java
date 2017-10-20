package project.mc.blog.post.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.mc.blog.post.dao.PostDao;
import project.mc.blog.post.domain.DTO;
import project.mc.blog.post.domain.PostDTO;
 
@Service
public class PostSvcImpl implements PostSvc {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private PostDao postDao;
	
	@Override
	public DTO do_searchOne(DTO dto) {
		
		return postDao.do_searchOne(dto);
	}

	@Override
	public int do_save(DTO dto) throws DataAccessException {
	
		return postDao.do_save(dto);
	}

	@Override
	public List<?> do_search(DTO dto) {
		
		return postDao.do_search(dto);
		
	}

	@Override
	public int do_delete(DTO dto) {
		
		return postDao.do_delete(dto);
	}

	@Override
	public int do_update(DTO dto) {
		
		return postDao.do_update(dto);
	}
	
	
	@Transactional
	public int do_checkedDelete(List<String> list)throws DataAccessException {
	
		int flag = 0;
		for(String id:list) {
			PostDTO vo=new PostDTO();
			vo.setPost_id(Integer.parseInt(id));
			int one = postDao.do_delete(vo);
			flag+=one;
		}
		return flag;		
	}

}
