package project.mc.blog.portfolio.domain;

import project.mc.commons.DTO;

public class PortfolioVO extends DTO {
	private int pf_id   ;//포트폴리오 아이디
	private int user_no ;//유저 no
	private int tmp_no  ;//템플릿 종류
	
	
	
	
	public int getPf_id() {
		return pf_id;
	}
	public void setPf_id(int pf_id) {
		this.pf_id = pf_id;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getTmp_no() {
		return tmp_no;
	}
	public void setTmp_no(int tmp_no) {
		this.tmp_no = tmp_no;
	}
	/**
	 * @param pf_id
	 * @param user_no
	 * @param tmp_no
	 */
	public PortfolioVO(int pf_id, int user_no, int tmp_no) {
		super();
		this.pf_id = pf_id;
		this.user_no = user_no;
		this.tmp_no = tmp_no;
	}
	/**
	 * 
	 */
	public PortfolioVO() {
		super();
	}
	@Override
	public String toString() {
		return "PortfolioVO [pf_id=" + pf_id + ", user_no=" + user_no + ", tmp_no=" + tmp_no + "]";
	}
	
	
	
	
	
	
	
	
}
