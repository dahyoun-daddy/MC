<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	//  확인버튼
	function do_sucess(){
		
	}//-- 확인버튼
	
	
	//  취소버튼
	function do_cancel(){
		
	}//-- 취소버튼
	
</script>
</head>
<body>
<!--
int    user_no      ;   //회원 번호                        
String user_id      ;   //회원 id                        
String user_password;   //회원 pw                        
int    user_div     ;   //회원 구분(0:관리자, 1:일반, 2:기업회원)   
String user_name    ;   //회원 이름                        
int    gender       ;   //성별(1:남자, 2:여자)               
int    age			;	//나이	                       
String email        ;   //이메일                          
String address      ;   //주소                           
String phone        ;   //연락처                          
int    withdraw_flag;   //탈퇴 여부(0:탈퇴, 1:존재)            
  -->
	<div id="header" align="center">
		<h1>MC</h1>
	</div>
	
	<form action="do_save.do" name="frm" method="get">
	<div id="container" align="center">
		<div>
			<input type="text" id="user_id" name="user_id" maxlength="20" autocomplete="off"  placeholder="아이디" >
		</div>
		<div>
			<input type="password" id="user_password" name="user_password" maxlength="20" placeholder="비밀번호">
		</div>
		<div>
			<input type="text" id="user_name" name="user_name" maxlength="20" placeholder="이름">
		</div>
		<div >
			<input type="radio" name="radio" id="1" >남자
			<input type="radio" name="radio" id="2" >여자
		</div>
		<div>
			<input type="text" id="age" name="age" maxlength="20" placeholder="나이">
		</div>
		<div>
			<input type="text" id="email" name="email" maxlength="20" placeholder="이메일">
		</div>
		<div>
			<input type="text" id="address" name="address" maxlength="20" placeholder="주소">
		</div>
		<div>
			<input type="text" id="phone" name="phone" maxlength="20" placeholder="연락처" value="010">
		</div>
	</div>
	
	<div id="footer" align="center">
		<input type="submit" id="user_join" name="user_join" value="확인" onclick="javascript:do_sucess();">
		<input type="button" id="cancel" name="cancel" value="취소" onclick="javascript:do_cancel();">
	</div>
	</form>
	
</body>
</html>