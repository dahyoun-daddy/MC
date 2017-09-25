<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//todo - userVO 가져와서 id 표시 및 유저 메뉴 생성



%>    
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080"+contextPath;  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<style type="text/css">
	#wrapper{
		
	}

	#logo{
		float:left;
	}
	
	#title{
		
	}
	
	#user_menu{
		float:right;
		
	}
	
	.menu a{cursor:pointer;}
    .menu .hide{display:none;}
    
    ul{
	    list-style:none;
	    padding-left:0px;
    }

    

</style>
<title>header</title>
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
	<div id="wrapper">	
		<div id="logo" align="left">
			<a href="<%=contextPath%>/main/home_main.do">MC(thumb-nail)</a>
		</div>
		<div id="user_menu" align="right">
			<ul>
				<li class="menu">
	            <a><img src="" alt="유저 메뉴"/></a>
		            <ul class="hide">
		                <li><a href="<%=contextPath%>/user/user_login.do">로그인/로그아웃</a></li>
		                <li><a href="<%=contextPath%>/user/user_modify.do">회원 정보 수정</a></li>
		                <li><a href="<%=contextPath%>/user/user_register.do">즐겨찾기 메뉴</a></li>
		            </ul>
		        </li>
			</ul>	
		</div>
		<div id="title" align="center">
			<a href="<%=contextPath%>/blog/portfolio.do">XXX님의 구직 블로그</a>
		</div>
	</div>
</body>
</html>