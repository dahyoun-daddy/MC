package project.mc.blog.post.domain;

import java.util.List;

import org.springframework.dao.DataAccessException;

import project.mc.blog.post.code.CodesDTO;




public interface WorkDiv {

	public int do_save(DTO dto);//Upsert
	public List<?> do_search(DTO dto);
	public int do_delete(DTO dto);
	public int do_update(DTO dto);
	public List<?> do_excelDown();
	public int do_excelUp(List<?> list);
	List<CodesDTO> doSearch(DTO inDTO);
	int doSave(DTO dto);
	int doUpdate(DTO dto);
	int doDelete(DTO dto);
	
}
