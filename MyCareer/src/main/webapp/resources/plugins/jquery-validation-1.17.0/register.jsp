<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>register page</title>

<!-- AdminLTE -->
<link href="AdminLTE-2.3.11/dist/css/AdminLTE.min.css" rel="stylesheet" />
<link href="AdminLTE-2.3.11/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="AdminLTE-2.3.11/bootstrap/css/bootstrap-theme.min.css"	rel="stylesheet" />
<link href="AdminLTE-2.3.11/dist/css/skins/_all-skins.min.css"	rel="stylesheet" />
<link href="AdminLTE-2.3.11/plugins/datepicker/datepicker3.css"	rel="stylesheet" />
<link href="AdminLTE-2.3.11/plugins/iCheck/all.css" rel="stylesheet" />
<link href="AdminLTE-2.3.11/plugins/iCheck/square/blue.css"	rel="stylesheet" />

<!-- script src -->
<script src="AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
<script src="AdminLTE-2.3.11/dist/js/app.min.js"></script>
<script src="AdminLTE-2.3.11/plugins/iCheck/icheck.js"></script>
<script	src="AdminLTE-2.3.11/plugins/datepicker/bootstrap-datepicker.js"></script>
<script	src="AdminLTE-2.3.11/plugins/datepicker/locales/bootstrap-datepicker.kr.js"></script>

<!-- 발리데이션 -->
<script src="jquery-validation-1.17.0/dist/jquery.validate.js"></script>

<!-- function -->
<script>
	//날짜선택
	$(function() {
		$("#m_birth").datepicker({
			autoclose : true,
			disableTouchKeyboard : true,
			format: 'yyyy-mm-dd',
			language: 'kr'
		});		
	});
	
	//체크박스
	$(function() {
		$("input").iCheck({
			checkboxClass : 'icheckbox_square-blue',
			radioClass : 'iradio_square-blue',
			increaseArea : '20%' // optional
		});
	});
	
	//ready
	$(document).ready(function(){
		//validate : 유효성
		$("#signupForm").validate({
			rules: {
				m_id: {
					required: true,
					alphastart: true,
					alphanumeric: true,					
					minlength: 4,
					maxlength: 12,					
						 remote : { 
					     url : "idCheck.jsp",
					     type : "post",
					     data : { m_id : function(){ return $('#m_id').val();} }  
					     } 					
				},
				m_name: {
					required: true,
					alphanumeric: true,
					minlength: 3,
					maxlength: 12
				},
				m_email: {
					required: true,
					email: true
				},
				m_pw: {
					required: true,
					minlength: 4,
					maxlength: 20
				},
				m_pw2: {
					required: true,					
					equalTo: "#m_pw"
				},		
				m_birth: {
					required: true
				},
				m_gender: {
					required: true					
				},
				m_nation: {
					required: true
				},
				agreement: {
					required: true
				}
			},
			//--rules
			//message : 해당 에러가 발생하였을 때, 출력될 에러메시지
			messages: {
				m_id: {
					required: "Please enter an id.",
					alphastart: "Your id must be start with character.",
					alphanumeric: "Letters, numbers, spaces or underscores only please.",					
					minlength: "Your id must consist of at least 4 characters.",
					maxlength: "Your id must consist of up to 12 characters.",
					remote: "This ID is a duplicate."
				},
				m_name: {
					required: "Please enter a Nickname.",
					alphanumeric: "Only characters can be used.",
					minlength: "Your Nickname must consist of at least 3 characters.",
					maxlength: "Your Nickname must consist of up to 12 characters."
				},
				m_email: "Please enter a valid email address.",
				m_pw: {
					required: "Please provide a password.",
					minlength: "Your password must be at least 5 characters long.",
					maxlength: "Your password must be up to 20 characters."
				},
				m_pw2: {
					required: "Please provide a password.",					
					equalTo: "Please enter the same password as above."
				},
				m_birth: "Please select your birthday.",
				agreement: "Please acept the term."
			},			
			//--message : 유효성 검사 실패 메시지가 출력될 부분
			// the errorPlacement has to take the table layout into account
			errorPlacement: function(error, element) {			
				if (element.is(":radio")){
					error.appendTo(element.parent().next().next());
				}
				else if (element.is(":checkbox")){
					error.appendTo(element.parent().parent().parent());
				}else{
					//error.appendTo(element.parent().next());				
					//error.appendTo(element.parent().prev());
					//error.appendTo(element.next());				
					error.appendTo(element.parent("div"));
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
			//--invalidHandler
			//submitHandler : 유효성 검사 성공시 시작되는 메소드
			submitHandler: function(form){
				$("#work_div").val("Insert");
				
				var date = $("#m_birth").val().replace(/-/g,'');
				$("#m_birth").val(date);				
				
				var gender = $("#gender_select").val();
				if(gender == "Male"){					
					$("#m_gender").val("1");
					alert("남자"+$("#m_gender").val());
				}else{					
					$("#m_gender").val("2");
					alert("여자"+$("#m_gender").val());
				}				
				var $form = $("#signupForm").initialize();
				
				console.log($form)
				$form.submit();
			}			
			//--submitHandler
		});
		//--validate
		
		//문자만 입력받게 하는 메소드
		jQuery.validator.addMethod("lettersonly", function(value, element) {
			  return this.optional(element) || /^[a-z]+$/i.test(value);
			}, "Letters only please");
		
		//문자+숫자 조합만 입력받게 하는 메소드
		jQuery.validator.addMethod("alphanumeric", function(value, element) {
			return this.optional(element) || /^\w+$/i.test(value);
		}, "Letters, numbers, spaces or underscores only please");
		
		//숫자로 시작하지 않게
		jQuery.validator.addMethod("alphastart", function(value, element) {
			return this.optional(element) || /^[a-zA-Z]/i.test(value);
		}, "Your id must be start with character.");
		
	});
	//--ready
	
</script>
<style type="text/css">
input.error, textarea.error{
  border:1px dashed red;
}
label.error{
  display:block;
  color:red;
}
</style>


</head>
<body>
	<!-- 회원가입 박스 시작 -->
	<div class="register-box">
	<!-- TODO : 회원가입 성공시  이동할 페이지 만들 것-->
	<form id="signupForm" name="signupForm" action="member_control.jsp">
	<input type="hidden" id="work_div" name="work_div">
	<input type="hidden" id="m_gender" name="m_gender" value="1">
		<div class="register-logo">			
			<b>Hi</b>Seoul
		</div>
		<p class="login-box-msg">회원가입</p>
		<div class="register-box-body">						
				<div class="form-group has-feedback">
					<label>ID</label> <input id="m_id" name="m_id" type="text" class="form-control"
						placeholder="아이디를 입력하세요."> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<label>NickName</label> <input id="m_name" name="m_name" type="text"
						class="form-control" placeholder="Name"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<label>E-Mail</label> <input id="m_email" name="m_email" type="email"
						class="form-control" placeholder="Email"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<label>Password</label> <input id="m_pw" name="m_pw" type="password"
						class="form-control" placeholder="Password"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<label>Confirm Password</label> <input id="m_pw2" name="m_pw2" type="password"
						class="form-control" placeholder="Confirm Password"> <span
						class="glyphicon glyphicon-log-in form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<label>Gender</label> 
					<select id="gender_select" name="gender_select" class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option selected="selected">Male</option>
						<option>Female</option>						
					</select>
				</div>
				<div class="form-group has-feedback">
					<label>Birth</label>
					<div class="input-group date">
						<input id="m_birth" name="m_birth" type="text" class="form-control pull-right"> 
						<span class="glyphicon glyphicon-calendar form-control-feedback"></span>
					</div>
				</div>

				<div class="form-group has-feedback">
					<label>Nation</label> <select id="m_nation" name="m_nation"
						class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option selected="selected">KR</option>
						<option>US</option>
						<option>CN</option>
						<option>JP</option>
						<option>UK</option>
					</select>
				</div>			
		</div>
		<div class="row">
			<div class="col-xs-8">
				<div class="checkbox icheck">
					<label class="">
						<div class="icheckbox_square-blue" aria-checked="false"
							aria-disabled="false" style="position: relative;">
							<input type="checkbox" id="agreement" name="agreement"
								style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">
							<ins class="iCheck-helper"
								style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
						</div> <!-- TODO : 약관 페이지 만들것 --> <a href="#">약관</a>에 동의합니다.
					</label>
				</div>
			</div>			
			<div class="col-xs-4">
				<input type="submit" class="btn btn-primary btn-block btn-flat" value="가입하기">
			</div>			
		</div>		
	</form>
	</div>
	<!-- 회원가입 박스 끝 -->

</body>
</html>