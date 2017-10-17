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

	String user_id = request.getParameter("user_id");
	if(user_id == null){
		user_id="";
	}
	
	String login_id = "";
	if(session.getAttribute("user_id") != null){
		login_id = session.getAttribute("user_id").toString();
	}else{
		login_id = "111";//debug
	}
	
	
	System.out.print("login_id"+login_id);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	
	a{	
		cursor:pointer;
	}
	
	.pf_menu{
	    padding-left:25px;
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
	<table style="margin-left:50px; bor" border="" bordercolor="black" rules="none">
		<tr>
			<td><a href="<%=contextPath%>/blog/post/post_doSearch.do?user_id=<%=user_id%>" style="text-decoration: none"><h3>포스팅</h3></a></td>
		</tr>
		<tr>
			<td id="pf_tmp_td">
				<a id="pf_tmp" style="text-decoration: none"><h3>포트폴리오</h3></a>
				<!-- 여기에 템플릿들이 추가 -->
			</td>
		</tr>
		<tr>
			<td><a href="<%=contextPath%>/blog/resume/resume.do?user_id=<%=user_id%>" style="text-decoration: none"><h3>이력서</h3></a></td>
		</tr>
		<tr>
			<td><a href="<%=contextPath%>/blog/recruit/recruit.do?user_id=<%=user_id%>" style="text-decoration: none"><h3>공채목록</h3></a></td>
		</tr>
	</table>
</body>
</html>