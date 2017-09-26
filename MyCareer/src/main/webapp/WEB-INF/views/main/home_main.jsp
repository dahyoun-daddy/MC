<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080"+contextPath;  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
	#user_menu{
		text-align: right;
	}
	
	#searchText{
		margin-top: 15%;
		
	}
	
</style>
	<title>:::My Career - main:::</title>
</head>
<body>
	<h1>
		My Career
	</h1>
	<div id="user_menu" align="right">
		<ul>
			<li class="menu">
            <a><img src="" alt="유저 메뉴"/></a>
	            <ul class="hide">
	                <li><a href="<%=contextPath%>/user/user_login.do">로그인/로그아웃</a></li>
	                <li><a href="<%=contextPath%>/user/user_modify.do">회원 정보 수정</a></li>
	                <li><a href="<%=contextPath%>/user/user_register.do">회원 가입</a></li>
	                <li><a href="<%=contextPath%>/user/favorite.do">즐겨찾기 메뉴</a></li>
	            </ul>
	        </li>
		</ul>	
	</div>
	
	
	<div id="wrapper">
		<div id="user_menu">
			<a href="<%=contextPath%>/user/user_login.do">로그인/로그아웃</a>//<a href="<%=contextPath%>/blog/post.do">블로그로(로그인 되어 있을 경우에만)</a>
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
