package project.mc.blog.post.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil implements ConnIn {
	private Connection conn = null;
	
	/**
	 * DB?ó∞Í≤?
	 */
	public Connection connect(){
		final String connectAPI = "jdbc";
		final String db 	= "oracle"	;
		final String thin 	= "thin"	;
		final String host 	= "211.238.142.162";
		final String port 	= "1521"	; 
		final String sid 	= "orcl"	;
		final String dbURL 	= connectAPI+":"+db+":"+thin+":@"+host+":"+port+":"+sid;
		final String dbUSER = "ora_user";
		final String dbPASS	= "sist"	;
		try{
			//Driver Load
			Class.forName(db+"."+connectAPI+".driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
			System.out.println("DB?ó∞Í≤?: "+conn.toString());
			
			
		}catch(ClassNotFoundException cnf){
			System.out.println("=ClassNotFoundException="+cnf.getMessage());
		}catch(SQLException sql){
			System.out.println("=SQLException="+sql.getMessage());
		}catch(Exception e){
			System.out.println("===========================");
			e.printStackTrace();
			System.out.println("===========================");
		}
		return conn;
	}
	
	/**
	 * DB?†ë?Üç ?ï¥?†ú
	 */
	public void disconnect(){
		try{
			if(conn!=null)conn.close();
			System.out.println("DB?†ë?Üç ?ï¥?†ú");
		}catch(SQLException se){
			System.out.println("=SQLException="+se.getMessage());
		}catch(Exception e){
			System.out.println("===========================");
			e.printStackTrace();
			System.out.println("===========================");
		}
	}
	
	
	
	
}
