package project.mc.blog.recruit.domain;

public class ParseVO {
	private	String	reSubject	;	//공고 제목
	private	String	reCompany	;	//회사명
	private	String	reExDate	;	//공고 마감일
	private	String	reUrl	;	//공고 주소
	private	String	reSalary	;	//연봉
	public String getReSubject() {
		return reSubject;
	}
	public void setReSubject(String reSubject) {
		this.reSubject = reSubject;
	}
	public String getReCompany() {
		return reCompany;
	}
	public void setReCompany(String reCompany) {
		this.reCompany = reCompany;
	}
	public String getReExDate() {
		return reExDate;
	}
	public void setReExDate(String reExDate) {
		this.reExDate = reExDate;
	}
	public String getReUrl() {
		return reUrl;
	}
	public void setReUrl(String reUrl) {
		this.reUrl = reUrl;
	}
	public String getReSalary() {
		return reSalary;
	}
	public void setReSalary(String reSalary) {
		this.reSalary = reSalary;
	}
	@Override
	public String toString() {
		return "ParseVO [reSubject=" + reSubject + ", reCompany=" + reCompany + ", reExDate=" + reExDate + ", reUrl="
				+ reUrl + ", reSalary=" + reSalary + "]";
	}

	
}
