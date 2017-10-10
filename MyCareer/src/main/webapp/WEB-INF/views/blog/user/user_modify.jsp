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
<!-- plugin 참조-->
<script type="text/javascript" src="js/plugins/validation/jquery.validate.min.js"></script>
<!-- 부트스트랩 -->
<link href="<%=contextPath%>/resources/css/bootstrap.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="<%=contextPath%>/resources/js/bootstrap.min.js"></script>    
<title>Insert title here</title>
<script type="text/javascript">

	// JQuery
	$(document).ready(function(){
	
		
		// do_update
		$("#do_update").on("click",function(){
			
			$.ajax({
				type:"POST",
	            url:"do_update.do",
	            dataType:"html",
	            async: false,
	            data:{
					   "user_password" :$("#user_password").val(),
		               "user_name" :$("#user_name").val(),
		               "age" :$("#age").val(),
		               "email" :$("#email").val(),
		               "address" :$("#address").val(),
		               "phone" :$("#phone").val()				
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
	            	alert("수정하시겠습니까?");
	            	console.log("success data: "+data);
	            	$("#do_update").submit();
	            },
	            complete: function(data){//무조건 수행
	            	
	            },
	            error: function(xhr,status,error){
	            	alert("수정에러");
	            	
	            }
				
			});
			
			
		});//--do_update
		
		//  do_delete
		$("#do_delete").on("click",function(){
			
			var withdraw_flag = $("#withdraw_flag").val();
			
			$.ajax({
				type:"POST",
	            url:"do_delete.do",
	            dataType:"html",
	            async: false,
	            data:{
	            	   	
		               "withdraw_flag" :withdraw_flag			
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
	            	alert("탈퇴하시겠습니까?");
	                $("#do_delete").submit();
	                
	            },
	            complete: function(data){//무조건 수행
	            	
	            },
	            error: function(xhr,status,error){
	            	alert("탈퇴에러"+error);
	            	
	            }
			});
		});//--do_delete
		
	});//--JQuery
		
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
	
	<form action="do_update.do" name="frm" method="post" id="frm">
	<input type="hidden" id="withdraw_flag" name="withdraw_flag">
	<div id="container" align="center">
		<div>
			<input type="text" id="user_id" name="user_id" maxlength="20" autocomplete="off"  placeholder="아이디" value="123" disabled="disabled"></br>
		</div>
		<div>
			<input type="password" id="user_password" name="user_password" maxlength="20" placeholder="비밀번호" value="1" required="required">
		</div>
		<div>
			<input type="text" id="user_name" name="user_name" maxlength="20" placeholder="이름" value="1" required="required">
		</div>
		<div>
			<input type="radio" name="gender" value="1" id="radio1" checked="checked" disabled="disabled">남자
			<input type="radio" name="gender" value="2" id="radio2" disabled="disabled">여자
		</div>
		<div>
			<input type="text" id="user_div" name="user_div" maxlength="20" placeholder="회원구분" value="1" disabled="disabled" >
		</div>
		<div>
			<input type="text" id="age" name="age" maxlength="20" placeholder="나이" value="1" required="required">
		</div>
		<div>
			<input type="text" id="email" name="email" maxlength="20" placeholder="이메일" value="1" required="required">
		</div>
		<div>
			<input type="text" id="address" name="address" maxlength="20" placeholder="주소" value="1" required="required">
		</div>
		<div>
			<input type="text" id="phone" name="phone" maxlength="20" placeholder="연락처" value="010" required="required">
		</div>
	</div>
	
	<div id="footer" align="center">
		<input type="submit" id=do_delete name="do_delete" value="회원탈퇴" >
		<input type="submit" id=do_update name="do_update" value="수정" >
		<a href="#"><input type="submit" value="취소"></a>
	</div>
	</form>
	
</body>
</html>