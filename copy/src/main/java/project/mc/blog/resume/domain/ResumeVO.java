package project.mc.blog.resume.domain;

import project.mc.commons.DTO;

/**
 * 
 * @author 홍준석
 * 작성일: 2017년 09월 27일
 */
public class ResumeVO extends DTO {

		private int file_id; //파일id
		private int table_div; //소속 테이블
		private int table_id; //소속 id
		private int seq; //파일 순서
		private String file_path; //파일 저장 경로
		private	String file_size; //파일 사이즈
		private String org_file_name; //원본파일명
		private String save_file_name; //저장 파일명
		private String file_ext; //파일 확장자
		private String reg_id; //작성자 id
		private String reg_dt; //작성일자 (기본값은 SYSDATE)
		private int flag;//파일 저장 성공 여부
	
	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}


	//기본 생성자
	public ResumeVO() {
		
	}
	
	
	@Override
	public String toString() {
		return "ResumeVO [file_id=" + file_id + ", table_div=" + table_div + ", table_id=" + table_id + ", seq=" + seq
				+ ", file_path=" + file_path + ", file_size=" + file_size + ", org_file_name=" + org_file_name
				+ ", save_file_name=" + save_file_name + ", file_ext=" + file_ext + ", reg_id=" + reg_id + ", reg_dt="
				+ reg_dt + ", flag=" + flag + "]";
	}


	public ResumeVO(int file_id, int table_div, int table_id, int seq, String file_path, String file_size,
			String org_file_name, String save_file_name, String file_ext, String reg_id, String reg_dt) {
		super();
		this.file_id = file_id;
		this.table_div = table_div;
		this.table_id = table_id;
		this.seq = seq;
		this.file_path = file_path;
		this.file_size = file_size;
		this.org_file_name = org_file_name;
		this.save_file_name = save_file_name;
		this.file_ext = file_ext;
		this.reg_id = reg_id;
		this.reg_dt = reg_dt;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getTable_div() {
		return table_div;
	}
	public void setTable_div(int table_div) {
		this.table_div = table_div;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	public String getOrg_file_name() {
		return org_file_name;
	}
	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	
}
