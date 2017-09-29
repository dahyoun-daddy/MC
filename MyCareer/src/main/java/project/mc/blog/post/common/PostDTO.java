package project.mc.blog.post.common;


public class PostDTO extends DTO {
	int post_id        ; //?è¨?ä§?ä∏ id
	int blog_id        ; //?Üå?Üç Î∏îÎ°úÍ∑? id
	int sup_post_id    ; //?ÉÅ?úÑ Í≤åÏãúÍ∏? id
	String post_title  ; //?†úÎ™?
	String post_content; //?Ç¥?ö©
	String reg_id      ; //?ûë?Ñ±?ûê id
	String reg_dt      ; //?ûë?Ñ±?ùº?ûê
	String mod_id      ; //?àò?†ï?ûê id
	String mod_dt      ; //?àò?†ï?ùº?ûê
	int del_flag       ; //?Ç≠?†ú ?îå?ûòÍ∑?
	
	
	
	
	
	
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PostDTO [post_id=" + post_id + ", blog_id=" + blog_id + ", sup_post_id=" + sup_post_id + ", post_title="
				+ post_title + ", post_content=" + post_content + ", reg_id=" + reg_id + ", reg_dt=" + reg_dt
				+ ", mod_id=" + mod_id + ", mod_dt=" + mod_dt + ", del_flag=" + del_flag + "]";
	}
	public PostDTO(int post_id, int blog_id, int sup_post_id, String post_title, String post_content,
			String reg_id, String reg_dt, String mod_id, String mod_dt, int del_flag) {
		super();
		this.post_id = post_id;
		this.blog_id = blog_id;
		this.sup_post_id = sup_post_id;
		this.post_title = post_title;
		this.post_content = post_content;
		this.reg_id = reg_id;
		this.reg_dt = reg_dt;
		this.mod_id = mod_id;
		this.mod_dt = mod_dt;
		this.del_flag = del_flag;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public int getSup_post_id() {
		return sup_post_id;
	}
	public void setSup_post_id(int sup_post_id) {
		this.sup_post_id = sup_post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
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
	public String getMod_id() {
		return mod_id;
	}
	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}
	public String getMod_dt() {
		return mod_dt;
	}
	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}
	public int getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blog_id;
		result = prime * result + del_flag;
		result = prime * result + ((mod_dt == null) ? 0 : mod_dt.hashCode());
		result = prime * result + ((mod_id == null) ? 0 : mod_id.hashCode());
		result = prime * result + ((post_content == null) ? 0 : post_content.hashCode());
		result = prime * result + post_id;
		result = prime * result + ((post_title == null) ? 0 : post_title.hashCode());
		result = prime * result + ((reg_dt == null) ? 0 : reg_dt.hashCode());
		result = prime * result + ((reg_id == null) ? 0 : reg_id.hashCode());
		result = prime * result + sup_post_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		if (blog_id != other.blog_id)
			return false;
		if (del_flag != other.del_flag)
			return false;
		if (mod_dt == null) {
			if (other.mod_dt != null)
				return false;
		} else if (!mod_dt.equals(other.mod_dt))
			return false;
		if (mod_id == null) {
			if (other.mod_id != null)
				return false;
		} else if (!mod_id.equals(other.mod_id))
			return false;
		if (post_content == null) {
			if (other.post_content != null)
				return false;
		} else if (!post_content.equals(other.post_content))
			return false;
		if (post_id != other.post_id)
			return false;
		if (post_title == null) {
			if (other.post_title != null)
				return false;
		} else if (!post_title.equals(other.post_title))
			return false;
		if (reg_dt == null) {
			if (other.reg_dt != null)
				return false;
		} else if (!reg_dt.equals(other.reg_dt))
			return false;
		if (reg_id == null) {
			if (other.reg_id != null)
				return false;
		} else if (!reg_id.equals(other.reg_id))
			return false;
		if (sup_post_id != other.sup_post_id)
			return false;
		return true;
	}
	
	
	
}
