<%@page import="project.mc.blog.user.domain.UserVO"%>
<%@page import="project.mc.blog.user.dao.UserDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080/"+contextPath;  

%> 
<%
	String user_id = (String)session.getAttribute("user_id");
    String blogOwner_id = request.getParameter("user_id");
    
	
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<!-- plugin 참조-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<!-- 부트스트랩 -->
<link href="<%=contextPath%>/resources/css/bootstrap.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- AdminLTE -->   
<link href="<%=contextPath%>/resources/plugins/AdminLTE-2.3.11/dist/css/AdminLTE.min.css" rel="stylesheet" />
<link href="<%=contextPath%>/resources/plugins/AdminLTE-2.3.11/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="<%=contextPath%>/resources/plugins/AdminLTE-2.3.11/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="<%=contextPath%>/resources/plugins/AdminLTE-2.3.11/dist/css/skins/_all-skins.min.css" rel="stylesheet" />
<script src="<%=contextPath%>/resources/plugins/AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=contextPath%>/resources/plugins/AdminLTE-2.3.11/dist/js/app.min.js"></script>

<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="<%=contextPath%>/resources/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
<script type="text/javascript">

	// JQuery
	$(document).ready(function(){
		
	//  do_delete
			$("#do_delete").on("click",function(){
				
				var withdraw_flag = $("#withdraw_flag").val();
				
				$.ajax({
					type:"POST",
		            url:"do_blog_delete.do",
		            dataType:"html",
		            async: false,
		            data:{
		            	"user_id" :$("#user_id").val(),
		            	"user_password" :$("#user_password").val(),
			            "withdraw_flag" :withdraw_flag			
		            },
		            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
		            	alert("탈퇴하시겠습니까?");
		                $("#do_delete").submit();
		                alert("회원탈퇴 되었습니다");
		                location.href="/mc/blog/blog_login_page.do";
		            },
		            complete: function(data){//무조건 수행
		            	
		            },
		            error: function(xhr,status,error){
		            	alert("탈퇴에러");
		            	
		            }
				});
			});//--do_delete
		
	//  validate: 유효성 검사
		$("#do_update").on("click",function(){
		$("#frm").validate({
			 rules: {
			  	
			    user_password : {
					  required : true
					  ,alphanumeric: true
					  , minlength : 6
					  , maxlength: 12
				},
			    
				user_name : {
					  required : true
					  ,kor: true
					  , minlength : 2
					  , maxlength: 17
				},
				
				age : {
					  required : true
					  ,number: true
					  , minlength : 1
					  , maxlength: 2
				},
				
				email : {
					  required : true
					  ,email: true
					  , minlength : 4
					  , maxlength: 30
				},
				
				address : {
					  required : true
					  , kor: true
					  , minlength : 4
					  , maxlength: 10
				},
				
				phone : {
					  required : true
					  ,number: true
					  , minlength : 9
					  , maxlength: 11
				}
			    
			 },//-- rules
			    messages: {
			    	 
			    	  user_password : { 
				    	  required: "비밀번호를 입력해주세요."
				    	  , minlength: "비밀번호는 최소 6자 이상이어야 합니다."
				    	  , maxlength: "비밀번호는 최대 12자 미만이어야 합니다."
				      },
				      
				      user_name : { 
				    	  required: "성명을 입력해주세요."
				    	  ,kor: "한글만 사용하시오"
				    	  , minlength: "성명은 최소 2자 이상이어야 합니다."
				    	  , maxlength: "성명은 최대 17자 미만이어야 합니다."
				      },
				      
				      age : { 
				    	  required: "나이를 입력해주세요."
				    	  , number: "숫자만 입력하시오"
				    	  , minlength: "나이는 1 이상이어야 합니다."
				    	  , maxlength: "나이는 100 미만이어야 합니다."
				      },
				      
				      email : { 
				    	  required: "이메일을 입력해주세요."
				    	  ,email: "이메일 형식에 맞게 입력하시오(영문+숫자@도메인)"
				    	  , minlength: "이메일은 최소 4자 이상이어야 합니다."
				    	  , maxlength: "이메일은 최대 30자 미만이어야 합니다."
				      },
				      
				      address : { 
				    	  required: "주소를 입력해주세요."
				    	  , kor: "시+구 or 동 까지만 적으시오(공백제거)"
				    	  , minlength: "주소는 최소 4자 이상이어야 합니다."
				    	  , maxlength: "주소는 최대 10자 미만이어야 합니다."
				      },
				      
				      phone : { 
				    	  required: "폰번호를 입력해주세요."
				    	  , number: "숫자만 입력하시오.(예시:01012345678)"
				    	  , minlength: "폰번호는 최소 9자 이상이어야 합니다."
				    	  , maxlength: "폰번호는 최대 11자 미만이어야 합니다."
				      }
			     },
			  	 //invalidHandler : submit버튼을 눌렀는데, 유효성 검사에 실패한 경우
				 invalidHandler: function(form, validator){		
					
					var errors = validator.numberOfInvalids();
			        if (errors) {            	
			            alert(validator.errorList[0].message);
			            validator.errorList[0].element.focus();
			            }
				 },
				 submitHandler: function(form){
					 $.ajax({
							type:"POST",
				            url:"do_blog_update.do",
				            dataType:"html",
				            async: false,
				            data:{
								   "user_password" :$("#user_password").val(),
					               "user_name" :$("#user_name").val(),
					               "age" :$("#age").val(),
					               "email" :$("#email").val(),
					               "address" :$("#address").val(),
					               "phone" :$("#phone").val(),
					               "user_id" :$("#user_id").val(),
					               "blogOwner_id" :$("#blogOwner_id").val()
				            },
				            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
				            	alert("수정하시겠습니까?");
				            	alert("수정완료");
				            	console.log("data=??" + data);
				            	var user_id = new String(data);
				            	location.href="/mc/blog/post/post_doSearch.do?user_id="+user_id;
				            	
				            },
				            complete: function(data){//무조건 수행
				            	
				            },
				            error: function(xhr,status,error){
				            	alert("수정에러");
				            	
				            	
				            }
							
						});
				 }//-- submitHandler
			});	//--validate 끝
		});//-- 수정
		
		//한글만  입력받게 하는 메소드
		jQuery.validator.addMethod("kor", function(value, element) {
			return this.optional(element) || /^[가-힣]+$/i.test(value);
		}, "한글만 사용하시오(공백제거)");
			
		//문자+숫자 조합만 입력받게 하는 메소드
		jQuery.validator.addMethod("alphanumeric", function(value, element) {
			return this.optional(element) || /^\w+$/i.test(value);
		}, "영문+숫자만 사용하시오");
		
		//숫자로 시작하지 않게
		jQuery.validator.addMethod("alphastart", function(value, element) {
			return this.optional(element) || /^[a-zA-Z]/i.test(value);
		}, "영문으로 입력하여 주세요");	
		
	});//--JQuery
		
	/* //  취소버튼
	function do_cancel(){
		
	}//-- 취소버튼 */
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
	<div id="header" align="center" >
	
		<h1>MC</h1>
	</div>
	
	<div class="register-box">
	<form name="frm" method="post" id="frm">
	<input type="hidden" id="withdraw_flag" name="withdraw_flag">
	<input type="hidden" id="blogOwner_id" value="<%=user_id%>">
	<div id="container" align="center" >
		<div align="left">
			<label>ID</label><input  id="user_id" name="user_id" value="${inVO.user_id }"  class="form-control" disabled="disabled"  >
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		
		<div align="left">
		<label>비밀번호</label>
			<input type="password" id="user_password" name="user_password"  value="${inVO.user_password }"  class="form-control">
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		<div align="left">
			<label>이름</label><input type="text" id="user_name" name="user_name"  placeholder="이름" value="${inVO.user_name }" class="form-control">
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		<div align="left">
			<input type="radio" name="gender" value="${inVO.gender  }" id="radio1" checked="checked" disabled="disabled">남자
			<input type="radio" name="gender" value="${inVO.gender  }" id="radio2" disabled="disabled">여자
		</div>
		<div align="left">
			<label>회원구분</label><input type="text" id="user_div" name="user_div" placeholder="회원구분" value="1" class="form-control" disabled="disabled" >
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		<div align="left">
			<label>나이</label><input type="text" id="age" name="age" placeholder="나이" value="${inVO.age  }" class="form-control" >
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		<div align="left">
			<label>이메일</label><input type="text" id="email" name="email" placeholder="이메일" value="${inVO.email  }" class="form-control" >
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		<div align="left">
			<label>주소</label><input type="text" id="address" name="address" placeholder="주소" value="${inVO.address }" class="form-control" >
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		<div align="left">
			<label>연락처</label><input type="text" id="phone" name="phone" placeholder="연락처" value="${inVO.phone  }" class="form-control" >
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
	</div>
	
	<div id="footer" align="center">
		<input type="button" id=do_delete name="do_delete" class="btn btn-primary btn-block btn-flat" value="회원탈퇴" >
		<input type="submit" id=do_update name="do_update" class="btn btn-primary btn-block btn-flat" value="회원수정" >
		<a href="/mc/blog/post/post_doSearch.do?user_id=<%=blogOwner_id%>" class="btn btn-primary btn-block btn-flat">취소</a>
	</div>

	</form>
	</div>
	
</body>
</html>