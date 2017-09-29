package project.mc.blog.post.common;

import java.util.List;

import org.springframework.dao.DataAccessException;

import project.mc.blog.post.code.CodesDTO;



/**
 * WorkDiv.java
 * ê±°ë˜?‘œì¤? ë©”ì†Œ?“œ ? •?˜
 * do_save   : ???¥
 * do_search : ì¡°íšŒ
 * do_delete : ?‚­? œ
 * do_update : ?ˆ˜? •
 * 
 * do_excelDown
 * do_excelUp
 * do_report : rd,?¬ë¦¬ìŠ¤?ƒˆ ë¦¬í¬?Š¸
 * @author sist_
 *
 */
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
