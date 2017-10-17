package project.mc.blog.post.dao;


import java.util.Hashtable;
import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.mc.blog.post.code.CodesDTO;
import project.mc.blog.post.domain.DTO;
import project.mc.blog.post.domain.PostDTO;



@Repository
public class PostDaoImpl implements PostDao {
	
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace
	  ="project.mc.user.repository.mappers.post";
	
	
	
	@Override
	public DTO do_searchOne(DTO dto) {
		String statement = namespace +".do_searchOne";
		log.debug("========================");
		log.debug("statement : "+statement);
		log.debug("dto.toString() = "+dto.toString());
		log.debug("========================");
		
		PostDTO vo= (PostDTO)dto;
		PostDTO outVo= sqlSession.selectOne(statement, vo);
		log.debug("========================");
		log.debug("outVo : "+outVo);
		log.debug("========================");
		
		return outVo;
	}
	
	
	
	@Override
	public int do_save(DTO dto) {
		int flag = 0;
		try {
			String statement = namespace +".do_save";
			PostDTO inVo = (PostDTO)dto;
			flag = sqlSession.update(statement, inVo);
		}catch(DataAccessException e) {
			throw e;
		}	
		
		return flag;
	}

	
	
	@Override
	public List<?> do_search(DTO dto) {
		String statement = namespace +".do_search";
		//Param
		PostDTO param=(PostDTO)dto;
		
		Hashtable<String, String> searchParam = null;//寃��깋議곌굔
		searchParam = param.getParam();
		
		int page_size  = 10;
		int page_num   = 1;
		
		if(searchParam.get("pageSize")!=null)//page_size: 10,50,100 
			page_size = Integer.parseInt(searchParam.get("pageSize").toString());
		
		if(searchParam.get("pageNo") !=null)//page_num:1,2,3,....
			page_num = Integer.parseInt(searchParam.get("pageNo").toString());
		
		searchParam.put("PAGE_SIZE", page_size+"");
		searchParam.put("PAGE_NUM", page_num+"");
		
		String searchWord="";
		String searchDiv="";
		
		if(searchParam.get("searchWord") != null)
			searchWord  = searchParam.get("searchWord").toString();
		if(searchParam.get("searchDiv") != null)
			searchDiv   = searchParam.get("searchDiv").toString();
		
		searchParam.put("SEARCH_DIV", searchDiv);
		searchParam.put("SEARCH_WORD", searchWord);
		
		String reg_id = param.getReg_id();
		
		if(reg_id == null || reg_id.equals("")) {
			searchParam.put("reg_id", "");
		}else {
			searchParam.put("reg_id", reg_id);
		}
			
			
		
		log.debug("===================pageSize : "+page_size);
		
		log.debug("searchDiv:"+searchDiv);
		log.debug("searchWord:"+searchWord);
		log.debug("page_size:"+page_size);
		log.debug("page_num:"+page_num);
		
		return sqlSession.selectList(statement, searchParam);

	}

	@Override
	public int do_delete(DTO dto) {
		int flag = 0;
		try {
			String statement = namespace +".do_delete";
			PostDTO inVo = (PostDTO)dto;
			flag = sqlSession.delete(statement, inVo);
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
			PostDTO inVo = (PostDTO)dto;
			flag = sqlSession.update(statement, inVo);
		}catch(DataAccessException e) {
			throw e;
		}	
		
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



	@Override
	public List<CodesDTO> doSearch(DTO inDTO) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int doSave(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int doDelete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}



}
