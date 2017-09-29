package project.mc.blog.post.domain;

import java.util.List;

import org.springframework.dao.DataAccessException;

import project.mc.blog.post.code.CodesDTO;



/**
 * WorkDiv.java
 * 거래?���? 메소?�� ?��?��
 * do_save   : ???��
 * do_search : 조회
 * do_delete : ?��?��
 * do_update : ?��?��
 * 
 * do_excelDown
 * do_excelUp
 * do_report : rd,?��리스?�� 리포?��
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
