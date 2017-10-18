<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080"+contextPath;  
  
%>
<%
	
	String login_id ="";
	if(session.getAttribute("user_id") != null){
		login_id = session.getAttribute("user_id").toString();
	}
	
	

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<style type="text/css">
	#user_menu{
		text-align: right;
	}
	
	#searchText{
		margin-top: 20%;
		
	}
	
	#function_menu, #logo{
		float:left;
		
	}
	
	.menu a{cursor:pointer;}
    .menu .hide{display:none;}
    
    ul{
	    list-style:none;
	    padding-left:0px;
    }
	
</style>
	<title>:::My Career - main:::</title>
<script type="text/javascript">
	//html dom 이 다 로딩된 후 실행된다.
	$(document).ready(function(){
	    // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
	    $(".menu>a").click(function(){
	        var submenu = $(this).next("ul");
	
	        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
	        if( submenu.is(":visible") ){
	            submenu.slideUp();
	        }else{
	            submenu.slideDown();
	        }
	    });
	});



</script>
</head>
<body>
	<div id="logo" align="left">
		<a href="<%=contextPath%>/main/home_main.do"><img src="<%=contextPath%>/resources/images/logo.png" width="90" height="50" alt="MC(thumb-nail)"/></a>
	</div>
	<div id="wrapper">
		<div id="user_menu">
		<%
			if(login_id == null || login_id.equals("")){
		%>
			 <a href="<%=contextPath%>/user/login_page.do">로그인</a>
		<%
			} else {
		%>
			(<%=login_id%>)님
			<a href="<%=contextPath%>/user/do_logout.do"> 로그아웃</a>//
			<a href="<%=contextPath%>/user/do_updateForm.do"> 회원수정</a>
			<a href="<%=contextPath%>/blog/post/post_doSearch.do?user_id=<%=login_id%>">블로그로</a>
		<%
			} 
		%>	
		<a href="<%=contextPath%>/user/do_look.do"><img src="" alt="회원 가입"/></a>
		</div>
		<div id="searchText" align="center">
			<form name="search_frm" method="get" action="<%=contextPath%>/blog/post/post_doSearch.do">
			블로그 검색: 구분(콤보박스) <input type="text" name="searchWord"  value=""/>
			<input type="hidden" name="searchDiv" value="10">
			<input type="submit" value="검색">
			</form>
		</div>
	</div>
	
	

</body>
</html>
