package project.mc.blog.post.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.mc.blog.post.common.DTO;
import project.mc.blog.post.common.WorkDiv;



public class CodesDAO implements WorkDiv {
	private Connection conn = null;
	ConnIn connIn = null;
	
//	/**
//	 * DB?���?
//	 */
//	public void connect(){
//		String dbURL 	="jdbc:oracle:thin:@localhost:1521:orcl";
//		String dbUSER 	="ora_user";
//		String dbPASS	="sist";
//		try{
//			//Driver Load
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
//			System.out.println("DB?���?: "+conn.toString());
//			
//			
//		}catch(ClassNotFoundException cnf){
//			System.out.println("=ClassNotFoundException="+cnf.getMessage());
//		}catch(SQLException sql){
//			System.out.println("=SQLException="+sql.getMessage());
//		}catch(Exception e){
//			System.out.println("===========================");
//			e.printStackTrace();
//			System.out.println("===========================");
//		}
//	}
//	
//	/**
//	 * DB?��?�� ?��?��
//	 */
//	public void disconnect(){
//		try{
//			if(conn!=null)conn.close();
//			System.out.println("DB?��?�� ?��?��");
//		}catch(SQLException se){
//			System.out.println("=SQLException="+se.getMessage());
//		}catch(Exception e){
//			System.out.println("===========================");
//			e.printStackTrace();
//			System.out.println("===========================");
//		}
//	}
//	
	
	public CodesDAO(){
		
	}
	
	public CodesDAO(ConnIn connIn){
		this.connIn=connIn;
	}
	
	/**
	 * @param:DTO
	 */
	@Override
	public List<CodesDTO> doSearch(DTO inDTO) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		List<CodesDTO> list = new ArrayList<CodesDTO>();
		CodesDTO cdto = null;

		CodesDTO param = (CodesDTO)inDTO;
		
		try{
			//DB?���?
			conn = connIn.connect();
			// searchDiv
			
			sb.append("SELECT MST_CD_ID,   \n");
			sb.append("      DTL_CD_ID,    \n");
			sb.append("      MST_CD_NM,    \n");
			sb.append("      DTL_CD_NM,    \n");
			sb.append("      SEQ,          \n");
			sb.append("      SUP_MST_CD_ID,\n");
			sb.append("      USE_YN        \n");
			sb.append("  FROM CODES        \n");
			sb.append(" WHERE MST_CD_ID = ?\n");
			sb.append("   AND USE_YN    = 1\n");
			sb.append("ORDER BY SEQ        \n");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, param.getMst_cd_id());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				cdto = new CodesDTO();
				cdto.setMst_cd_id(rs.getString("MST_CD_ID"));
				cdto.setDtl_cd_id(rs.getString("DTL_CD_ID"));
				cdto.setMst_cd_nm(rs.getString("MST_CD_NM"));
				cdto.setDtl_cd_nm(rs.getString("DTL_CD_NM"));
				cdto.setSeq(rs.getInt("SEQ"));
				cdto.setSup_mst_cd_id(rs.getString("SUP_MST_CD_ID"));
				
				list.add(cdto);
			}
			rs.close();
			pstmt.close();
			
		}catch(SQLException sql){
			sql.getMessage();
		}catch(Exception e){
			System.out.println("===========================");
			e.printStackTrace();
			System.out.println("===========================");
		}finally{
			try{
				if(rs !=null) rs.close();
			}catch(Exception e){
				System.out.println("===========================");
				e.printStackTrace();
				System.out.println("===========================");
			}
			
			try{
				if(pstmt !=null) pstmt.close();
			}catch(Exception e){
				System.out.println("===========================");
				e.printStackTrace();
				System.out.println("===========================");
			}
			connIn.disconnect();
		}
		return list;
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

	@Override
	public int do_save(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> do_search(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
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

}
