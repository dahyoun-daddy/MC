package project.mc.blog.post.domain;

import java.util.HashMap;
import java.util.Hashtable;

 
public abstract class DTO {
	/**
	 * param
	 */
	private Hashtable<String, String>  param =new Hashtable<String, String>();
	
	
	private int total_cnt;
	
	
	private int no;

	/**
	 * Version
	 * @return
	 */
	private String version;
	
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Hashtable<String, String> getParam() {
		return param;
	}

	public void setParam(Hashtable<String, String> param) {
		this.param = param;
	}
	

	public int getTotal_cnt() {
		return total_cnt;
	}

	public void setTotal_cnt(int total_cnt) {
		this.total_cnt = total_cnt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
}
