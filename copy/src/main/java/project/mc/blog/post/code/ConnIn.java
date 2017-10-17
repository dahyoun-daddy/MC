package project.mc.blog.post.code;

import java.sql.Connection;

public interface ConnIn {
	
	public Connection connect();
	
	public void disconnect();
	
}
