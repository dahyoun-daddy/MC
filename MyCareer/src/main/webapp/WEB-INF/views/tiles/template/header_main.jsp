<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//todo - userVO 가져와서 id 표시 및 유저 메뉴 생성
	
	String login_id = "";
	if(session.getAttribute("user_id") != null){
		login_id = session.getAttribute("user_id").toString();
	}else{
		login_id = "";//debug
	}
	
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
	
	#searchText{
		
	}
	#user_menu{
		float:right;
		width:150px;
	}
	
	.menu a{cursor:pointer;}
    
    .menu_ul{
	    list-style:none;
	    padding-left:0px;
    }


</style>
<title>Insert title here</title>
<script type="text/javascript">
	//html dom 이 다 로딩된 후 실행된다.
	$(document).ready(function(){
		$(".menu>a").next("ul").toggleClass("hide");
		
		
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
			<a href="<%=contextPath%>/main/home_main.do"><img src="<%=contextPath%>/resources/images/logo.png" width="90" height="50" alt="MC(thumb-nail)"/></a>
		</div>
		
		<div id="user_menu" align="right">
			<ul>
				<li class="menu menu_ul">
	            <a><img src="" alt="유저 메뉴"/></a>
		            <ul class="hide menu_ul" style="display:none">
		            	<%
		            		if(login_id == null || login_id.equals("")){
		            	%>
		                	<li><a href="<%=contextPath%>/user/login_page.do" id="login"><img src="" alt="로그인"/></a></li>
		                <%
		            		}else{
		                %> 
		                	<li><a href="<%=contextPath%>/user/do_logout.do" id="logout"><img src="" alt="로그아웃"/></a></li>
		                	<li><a href="<%=contextPath%>/user/do_updateForm.do"><img src="" alt="회원 정보 수정"/></a></li>
		                	<li><a href="<%=contextPath%>/blog/post/post_doSearch.do?user_id=<%=login_id%>">블로그로</a></li>
		                <%
		            		}
		                %>
		                <li><a href="<%=contextPath%>/user/do_look.do"><img src="" alt="회원 가입"/></a></li>
		                
		            </ul>
		        </li>
			</ul>
		</div>
		<div id="searchText" align="center">
			<form name="search_frm" method="get" action="blog_search.do">
			블로그 검색: 구분(콤보박스) <input type="text" name="searchWord"  value=""/>
			<input type="submit" value="검색">
		</form>
		<br/>
        <hr id="hrHeader" style="border-top-width: 4px;border-top-color: black"/>
	</div>
</body>
</html>