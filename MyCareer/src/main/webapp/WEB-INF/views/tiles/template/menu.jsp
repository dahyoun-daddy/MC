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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="<%=contextPath%>/post.do">포스팅</a></td>
		</tr>
		<tr>
			<td><a href="<%=contextPath%>/blog/portfolio.do">포트폴리오 템플릿</a></td>
		</tr>
		<tr>
			<td><a href="<%=contextPath%>/resume.do">이력서</a></td>
		</tr>
		<tr>
			<td><a href="<%=contextPath%>/media.do">동영상</a></td>
		</tr>
		<tr>
			<td><a href="<%=contextPath%>/recruit.do">공채목록</a></td>
		</tr>
		<tr>
			<td><a href="<%=contextPath%>/calander.do">공채달력</a></td>
		</tr>
	</table>
</body>
</html>