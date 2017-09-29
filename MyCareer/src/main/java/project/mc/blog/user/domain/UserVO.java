package project.mc.blog.user.domain;

import project.mc.commons.DTO;

public class UserVO extends DTO{
	
	private int    user_no      ;   //회원 번호
	private String user_id      ;   //회원 id
	private String user_password;   //회원 pw
	private int    user_div     ;   //회원 구분(0:관리자, 1:일반, 2:기업회원)
	private String user_name    ;   //회원 이름
	private int    gender       ;   //성별(1:남자, 2:여자)
	private int    age			;	//나이	
	private String email        ;   //이메일
	private String address      ;   //주소
	private String phone        ;   //연락처
	private int    withdraw_flag;   //탈퇴 여부(0:탈퇴, 1:존재)
	
	public UserVO() {
		
	}
	
	public UserVO(int user_no, String user_id, String user_password, int user_div, String user_name, int gender,
			int age, String email, String address, String phone, int withdraw_flag) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_div = user_div;
		this.user_name = user_name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.withdraw_flag = withdraw_flag;
	}
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_div() {
		return user_div;
	}
	public void setUser_div(int user_div) {
		this.user_div = user_div;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getWithdraw_flag() {
		return withdraw_flag;
	}
	public void setWithdraw_flag(int withdraw_flag) {
		this.withdraw_flag = withdraw_flag;
	}
	
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_password=" + user_password
				+ ", user_name=" + user_name + ", gender=" + gender + ", age=" + age + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", withdraw_flag=" + withdraw_flag +"]";
	}
}
