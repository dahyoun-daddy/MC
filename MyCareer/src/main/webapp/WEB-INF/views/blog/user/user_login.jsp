<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function loginCheck(){
		var id = document.login_frm.id;
		var pwd = document.login_frm.password;
	
	
	if(id.value ==""){
		alert("아이디를 입력해 주세요");
		id.focus();
		return false;
	}
	if(pwd.value==""){
		alert("비밀번호를 입력해 주세요");
		password.focus();
		return false;
	}
		
	
</script>
</head>
<body>
<div>
	<form name="login_frm" method="post" action="user_login.do" onsubmit="loginCheck()">
	<input type="hidden" name="command" value="login">
	id: <input type="text" name="id"  value=""/>
	password: <input type="text" name="password"  value=""/>
	<input type="submit" value="로그인"></br>
	</form>
	<a href="user_register.do">회원가입</a> 
	<a href="/mc/main/home_main.do">취소</a>
	
</div>
</body>
</html>