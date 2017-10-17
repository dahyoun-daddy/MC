<%@page import="project.mc.blog.portfolio.service.PortFolioSvcImpl"%>
<%@page import="java.util.List"%>
<%@page import="project.mc.blog.portfolio.dao.PortfolioDao"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="project.mc.blog.portfolio.dao.PortfolioDaoImpl"%>
<%@page import="project.mc.blog.portfolio.domain.PortfolioVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//contextPath
	String contextPath = request.getContextPath();
	contextPath = "http://localhost:8080"+contextPath;
%>
<%
	String user_id = "111";
	String login_id = "111";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 부트스트랩 -->
<link href="<%=contextPath%>/resources/css/bootstrap.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="<%=contextPath%>/resources/js/bootstrap.min.js"></script>
<style type="text/css">
	
	a{	
		cursor:pointer;
	}
	
	.pf_menu{
	    padding-left:25px;
    }
	#snb{
	    list-style-type: none;
	    margin-left: 50px;
	    padding: 0;
	    width: 200px;
	    background-color: white;
	    font-size: 20px;
	    border: 1px solid #555; 
	}
	
	li a {
	    display: block;
	    color: #000;
	    padding: 8px 16px;
	    text-decoration: none;
	    border: 1px solid #555;
	}
	
	/* Change the link color on hover */
	li a:hover {
	    background-color: coral;
	    color: white;
	}
	
</style>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			type:"post",
			url : "<%=contextPath%>/portfolio_menu.do",
			datatype : "json",
			data : {"user_id" : <%=user_id%>,
					"login_id" : <%=login_id%>},
			success : function(data){
				//디코딩하여 변수에 담는다.
		        //var outData = decodeURIComponent(data);
				
				$("#pf_tmp_td").append(data);
			}
		});
		
		$("#pf_tmp").click(function(){
			
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
	<br/>
	<br/>
	<br/>
	<br/>
	<div class="snb">
		<ul id="snb">
			<li class="s1"><a href="<%=contextPath%>/blog/post/post_doSearch.do" style="text-decoration: none">포스팅</a></li>	
			<li id="pf_tmp_td" class="s2">
				<a id="pf_tmp" style="text-decoration: none">포트폴리오</a>
				<!-- 여기에 템플릿들이 추가 -->
			</li>
			<li class="s3"><a href="<%=contextPath%>/blog/resume/resume.do" style="text-decoration: none">이력서</a></li>
			<li class="s4"><a href="<%=contextPath%>/blog/recruit/recruit.do" style="text-decoration: none">공채목록</a></li>
		</ul>
	</div>
</body>
</html>