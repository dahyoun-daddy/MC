<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%   
///////////////////////////////////////////////////////////
//Cache
///////////////////////////////////////////////////////////

response.setHeader("Cache-Control","no-store");   
response.setHeader("Pragma","no-cache");   
response.setDateHeader("Expires",0);   

if (request.getProtocol().equals("HTTP/1.1")) 
        response.setHeader("Cache-Control", "no-cache");

///////////////////////////////////////////////////////////
//Session
///////////////////////////////////////////////////////////

String loginStatus = "로그인";
String adminStatus = "";
String linkPath = "../resident/login.jsp";
String welcomeText = "";
String edit_info = "";
String mgmtExpense = "";

if(session.getAttribute("resident")!=null){
	loginStatus = "로그아웃";
	linkPath="../resident/login.jsp";
	
	//ResidentDTO resident = (ResidentDTO)session.getAttribute("resident");
	//welcomeText = resident.getResi_name() + "님 환영합니다!";
	//edit_info = "회원정보수정";
	//mgmtExpense = "관리비";
	
	//if(resident.getResi_admin()==1){
	//	adminStatus="관리자페이지";
	//}
} else {
	loginStatus = "로그인";
}
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>header</title>
<script>
	
	//관리자면 관리자 페이지 생기게 만들기
	$(document).ready(function(){
		if(($("#loginYN").text()=="로그아웃")){
			$("#loginYN").on("click", function(){
				if(confirm("로그아웃 하시겠습니까?")==true){
					$("#headerFrm").submit();
				}
			});
		}else if($("#loginYN").text()=="로그인"){ //추가
			$("#loginYN").on("click", function(){
				location.href="../resident/login.jsp";
			});
		}
		
		if(($("#adminYN").text()=="관리자페이지")){
			$("#adminYN").on("click", function(){
				location.href="../admin/adminPage.jsp";
			});
		}
		
		if(($("#edit_info").text()=="회원정보수정")){
			$("#edit_info").on("click", function(){
				location.href="../resident/edit_user.jsp"
			});
		}
	});
	
	
</script>
</head>
<body>
	<form method="post" id="headerFrm" name="headerFrm" action="../resident/login_control.jsp" >
	<input type="hidden" id="work_div" name="work_div" value="doLogout" />
	</form>
		<div id="header">
			<div id="nav">
				<ul>
					<a href="../mainPage/main_page.jsp"><li class="menuLink"><label>메인 페이지</label></li></a>
					<a href="../board/board_list.jsp"><li class="menuLink"><label>공지사항</label></li></a>
					<a href="../bazar/bazar_main.jsp"><li class="menuLink"><label>장터</label></li></a>
					<a href="../parking/parking_show_b1.jsp"><li class="menuLink"><label>주차</label></li></a>
					<a href="../QnA_FAQ/Question_Start.jsp"><li class="menuLink"><label>QnA</label></li></a>
					<a href="../mgmtexpense/MGMT_form.jsp"><li class="menuLink"><label><%=mgmtExpense%></label></li></a>
					<li class="menuLink"><label id="loginYN"><%=loginStatus%></label></li>
					<li class="menuLink"><label id="adminYN"><%=adminStatus%></label></li>
					<li class="menuLink"><label><%=welcomeText%></label></li>
					<li class="menuLink"><label id="edit_info"><%=edit_info%></label></li>
				</ul>
			</div>
		</div>
</body>
</html>