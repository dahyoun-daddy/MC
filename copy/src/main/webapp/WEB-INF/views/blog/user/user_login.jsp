<%@page import="project.mc.blog.user.domain.UserVO"%>
<%@page import="org.apache.ibatis.metadata.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080/"+contextPath; 
  
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<!-- plugin 참조-->
<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.min.js"></script>
<!-- 부트스트랩 -->
<link href="<%=contextPath%>/resources/css/bootstrap.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/bootstrap-theme.min.css" rel="stylesheet">

<title>로그인 화면</title>
<script>
	$(function(){
		$("#btnLogin").click(function(){
			
			var user_id = $("#user_id").val();
			var user_password = $("#user_password").val();
			var withdraw_flag = $("#withdraw_flag").val();
			if(user_id == ""){
				alert("아이디를 입력해주세요");
				$("#user_id").focus();
				return;
			}
			if(user_password == ""){
				alert("비밀번호를 입력해주세요");
				$("#user_password").focus();
				return;
			}
			
			document.frm.action="do_loginCheck.do"

			document.frm.submit();
			
		});
		
	});
</script>
</head>
<body>

		<h2>로그인 </h2>
		<form name="frm" method="post" id="frm">
			<table>
				<tr height="40px">
					<td>ID</td>
					<td>
					<input type="text" name="user_id" id="user_id"/>
					</td>
				</tr>
				<tr height="40px">
					<td>비밀번호</td>
					<td><input type="password" name="user_password" id="user_password"></td>
				</tr>
				<tr>
				<td align="center"><a href="do_look.do">회원가입</a></td>
					<td align="center"><button type="button" id="btnLogin" name="btnLogin">로그인</button>
					</td>
					<td align="center"><a href="<%=contextPath %>/main/home_main.do">취소</a></td>
				</tr>
			</table>
		</form>
</div>
</body>
</html>