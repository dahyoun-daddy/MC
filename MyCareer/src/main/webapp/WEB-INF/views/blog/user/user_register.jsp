<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mem" scope="page" class="project.mc.blog.user.domain.UserVO" />
<jsp:setProperty property="*" name="mem"/>
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


<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="<%=contextPath%>/resources/js/bootstrap.min.js"></script>    
<title>Insert title here</title>
<script type="text/javascript">
	
		

	// JQuery
	$(document).ready(function(){
	
		//  validate: 유효성 검사
		
					$("#frm").validate({
						 rules: {
						  user_id : {required : true, minlength : 3, maxlength: 12},
						   remote : "do_idCheck.do"
						 	},
						     messages: {
						    	  user_id : { required: "사용자ID를 입력해주세요."
						    	  , minlength: "아이디는 최소 3자 이상이어야 합니다."
						    	  , maxlength: "아이디는 최대 12자 미만이어야 합니다."
						    	  , remote : "해당 아이디는 중복되었습니다."}
						    	  
						     },
						 	  onsubmit: false,
					    	  errorClass : "validation-error",
					    	  validClass : "validation-valid"
					});//--validate 끝	
						    	
						
			
		// do_save
		$("#do_save").on("click",function(){
			
			//  gender값 호출하기
			var gender = $('input[name="gender"]:checked').val();
			var user_no = $("#user_no").val();
			var withdraw_flag = $("#withdraw_flag").val();	
			
			$.ajax({
				type:"POST",
	            url:"do_save.do",
	            dataType:"html",// JSON
	            async: false,
	            data:{
	               "user_no"       : user_no,
	               "withdraw_flag" : withdraw_flag,
	               "user_id"       :$("#user_id").val(),
	               "user_password" :$("#user_password").val(),
	               "user_name" :$("#user_name").val(),
	               "gender" :gender,
	               "user_div" :$("#user_div").val(),
	               "age" :$("#age").val(),
	               "email" :$("#email").val(),
	               "address" :$("#address").val(),
	               "phone" :$("#phone").val()
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
	            	alert("회원가입완료");
	            	location.href="login_page.do";
	            },
	            complete: function(data){//무조건 수행
	            	
	            },
	            error: function(xhr,status,error){
	            	alert("회원가입실패");
	            }
				
			});
			
			
		});//--do_save
		
		
	});//--JQuery
		
	
	
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
	
	
	<form action="do_save.do" id="frm" name="frm" method="post" >
	<input type="hidden" name="user_no" id="user_no" value="1">
	<input type="hidden" name="withdraw_flag" id="withdraw_flag" value="1">
	<div id="container" align="center">
		<div>
			<input type="text" id="user_id" name="user_id" maxlength="20" autocomplete="off"  placeholder="아이디" required="required" >
		</div>
		<div>
			<input type="password" id="user_password" name="user_password" maxlength="20" placeholder="비밀번호" >
		</div>
		<div>
			<input type="text" id="user_name" name="user_name" maxlength="20" placeholder="이름" >
		</div>
		<div>
			<input type="radio" name="gender" value="1" id="radio1" checked="checked">남자
			<input type="radio" name="gender" value="2" id="radio2">여자
		</div>
		<div>
			<input type="text" id="user_div" name="user_div" maxlength="20" placeholder="회원구분"  >
		</div>
		<div>
			<input type="text" id="age" name="age" maxlength="20" placeholder="나이"  >
		</div>
		<div>
			<input type="text" id="email" name="email" maxlength="20" placeholder="이메일"  >
		</div>
		<div>
			<input type="text" id="address" name="address" maxlength="20" placeholder="주소"  >
		</div>
		<div>
			<input type="text" id="phone" name="phone" maxlength="20" placeholder="연락처" >
		</div>
	</div>
	<div id="footer" align="center">
		<input type="button" value="확인" id="do_save" name="do_save">
		<a href="login_page.do">취소</a>
	</div>
	</form>
	
</body>
</html>