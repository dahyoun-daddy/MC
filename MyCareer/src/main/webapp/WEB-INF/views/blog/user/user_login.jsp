<%@page import="project.mc.blog.user.service.UserSvc"%>
<%@page import="project.mc.blog.user.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_password");
	
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	
	function login(){
		
	}
	/* function login(event){
		var id = document.querySelector('#id');
		var pw = document.querySelector('#password');
		var check = id.value && pw.value && 
					id.value.length > 3 && pw.value.length > 3;
		
		if(!check){
			event.preventDefault();
			alert('올바른 ID, PASSWORD 정보를 입력하세요.');
            id.value = '';
            passwd.value = '';
            id.focus();
		}
	}
	
	function init(){
		document.querySelector('#login_frm').
		addEventListener('submit', submitHandler);
		location.href="home_main.do";
		
	} */
	window.addEventListener('load', init);
	
	/* function loginCheck(){
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
	
	} */
	
</script>
</head>
<body>
<div>
	<form name="login_frm" method="post" action="user_login.do">
	id: <input type="text" name="id" id="id"  value=""/>
	password: <input type="text" name="password" id="password"  value=""/>
	<input type="submit" value="로그인" id="login" name="login" onclick="javascript:login();"></br>
	</form>
	<a href="user_register.do">회원가입</a> 
	<a href="/mc/main/home_main.do">취소</a>
	
</div>
</body>
</html>