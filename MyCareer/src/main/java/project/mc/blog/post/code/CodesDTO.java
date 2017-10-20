package project.mc.blog.post.code;

import project.mc.blog.post.domain.DTO;
 
public class CodesDTO extends DTO {
	private String mst_cd_id	;
	private String dtl_cd_id	;
	private String mst_cd_nm	;
	private String dtl_cd_nm	;
	private int	   seq			;
	private String sup_mst_cd_id;
	private int	   use_yn		;
	
	
	@Override
	public String toString() {
		return "CodesDTO [mst_cd_id=" + mst_cd_id + ", dtl_cd_id=" + dtl_cd_id + ", mst_cd_nm=" + mst_cd_nm
				+ ", dtl_cd_nm=" + dtl_cd_nm + ", seq=" + seq + ", sup_mst_cd_id=" + sup_mst_cd_id + ", use_yn="
				+ use_yn + ", getTotal_cnt()=" + getTotal_cnt() + ", getNo()=" + getNo() + "]";
	}
	
	
	public String getMst_cd_id() {
		return mst_cd_id;
	}
	public void setMst_cd_id(String mst_cd_id) {
		this.mst_cd_id = mst_cd_id;
	}
	public String getDtl_cd_id() {
		return dtl_cd_id;
	}
	public void setDtl_cd_id(String dtl_cd_id) {
		this.dtl_cd_id = dtl_cd_id;
	}
	public String getMst_cd_nm() {
		return mst_cd_nm;
	}
	public void setMst_cd_nm(String mst_cd_nm) {
		this.mst_cd_nm = mst_cd_nm;
	}
	public String getDtl_cd_nm() {
		return dtl_cd_nm;
	}
	public void setDtl_cd_nm(String dtl_cd_nm) {
		this.dtl_cd_nm = dtl_cd_nm;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSup_mst_cd_id() {
		return sup_mst_cd_id;
	}
	public void setSup_mst_cd_id(String sup_mst_cd_id) {
		this.sup_mst_cd_id = sup_mst_cd_id;
	}
	public int getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(int use_yn) {
		this.use_yn = use_yn;
	}

}
