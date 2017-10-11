<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080"+contextPath;  
  
  // 로그인 로그아웃 버튼 활성화
  
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
		margin-top: 15%;
		
	}
	
	#function_menu{
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
<%
	Object user_id = session.getAttribute("user_id");
%>
	<h1>
		My Career
	</h1>
	<div id="function_menu" align="right">
		<ul>
			<li class="menu">
            <a><img src="" alt="PortfolioMenu"/></a>
	            <ul class="hide">
	                <li><form action="portfolio.do" method="get">포트폴리오 화면</form></li>
	                <li><a href="<%=contextPath%>/blog/portfolio_edit.do">포트폴리오 편집</a></li>
	                <li><a href="<%=contextPath%>/blog/portfolio_save.do">포트폴리오 저장</a></li>
	                <li><a href="<%=contextPath%>/blog/portfolio_delete.do">포트폴리오 삭제</a></li>
	            </ul>
	        </li>
		</ul>	
	</div>
	<div id="wrapper">
		<div id="user_menu">
		<%
			if(user_id == null){
		%>
			 <a href="<%=contextPath%>/user/login_page.do">로그인</a>
		<%
			} else {
		%>
			(<%=user_id%>)님
			<a href="<%=contextPath%>/user/do_logout.do"> 로그아웃</a>//
			 <a href="<%=contextPath%>/user/do_updateForm.do"> 회원수정</a>
			<a href="<%=contextPath%>/blog/post.do">블로그로(로그인 되어 있을 경우에만)</a>
		<%
			} 
		%>	
		</div>
		<div id="searchText" align="center">
			<form name="search_frm" method="get" action="blog_search.do">
			블로그 검색: 구분(콤보박스) <input type="text" name="searchWord"  value=""/>
			<input type="submit" value="검색">
			</form>
		</div>
	</div>
	
	

</body>
</html>
