package project.mc.blog.portfolio.domain;

import java.util.List;

import project.mc.blog.resume.domain.ResumeVO;
import project.mc.commons.DTO;

public class PortfolioVO extends DTO {
	private int pf_id   ;//포트폴리오 아이디
	private String user_id ;//유저 id
	private int tmp_no  ;//템플릿 종류
	private List<ResumeVO> imgList ;//포트폴리오에 딸려 있는 이미지 객체
	
	
	
	
	public List<ResumeVO> getImgList() {
		return imgList;
	}

	public void setImgList(List<ResumeVO> imgList) {
		this.imgList = imgList;
	}

	/**
	 * 
	 */
	public PortfolioVO() {
		super();
	}
	
	/**
	 * @param pf_id
	 * @param user_id
	 * @param tmp_no
	 */
	public PortfolioVO(int pf_id, String user_id, int tmp_no) {
		super();
		this.pf_id = pf_id;
		this.user_id = user_id;
		this.tmp_no = tmp_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPf_id() {
		return pf_id;
	}
	public void setPf_id(int pf_id) {
		this.pf_id = pf_id;
	}
	
	public int getTmp_no() {
		return tmp_no;
	}
	public void setTmp_no(int tmp_no) {
		this.tmp_no = tmp_no;
	}
	
	@Override
	public String toString() {
		return "PortfolioVO [pf_id=" + pf_id + ", user_id=" + user_id + ", tmp_no=" + tmp_no + "]";
	}
	
}
