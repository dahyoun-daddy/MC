<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>블로그 메인 페이지</title>
</head>
<body>
	<div align="center">
		<tiles:insertAttribute name="header"/>
	</div>
	<table height="500" width="100%">
		<tr>
			<td>
				<tiles:insertAttribute name="menu"/>
			</td>
			<td>
				<tiles:insertAttribute name="body"/>
			</td>
		</tr>		
	</table>
	<div align="center">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>