package project.mc.blog.post.code;

import java.util.List;

 
public class CodesMain {

	public static void main(String[] args) {
		
		CodesDTO inDTO = new CodesDTO();
		inDTO.setMst_cd_id("C001");
		List<CodesDTO> list = doSearch(inDTO);
		for(CodesDTO dto:list){
			
		}
		
		
	}
	
	/**
	 * 코드 조회
	 * @param inDTO
	 * @return List<CodesDTO>
	 */
	public static List<CodesDTO> doSearch(CodesDTO inDTO){
		CodesDAO dao = new CodesDAO(new ConnectionUtil());
		
		return dao.doSearch(inDTO);
	}
	
}
