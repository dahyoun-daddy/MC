package project.mc.blog.post.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil implements ConnIn {
	private Connection conn = null;
	
	
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
			System.out.println("DB?���?: "+conn.toString());
			
			
		}catch(ClassNotFoundException cnf){
			
		}catch(SQLException sql){
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return conn;
	}
	
	
	public void disconnect(){
		try{
			if(conn!=null)conn.close();
			
		}catch(SQLException se){
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	
	
	
}
