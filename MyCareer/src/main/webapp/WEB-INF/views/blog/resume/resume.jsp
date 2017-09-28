<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String contextPath = request.getContextPath();
	contextPath = "http://localhost:8080/" + contextPath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이력서 파일 게시판입니다.</h2>
	<hr/>
	<div>
		<button>저장</button>
		<button>삭제</button>
	</div>
	<form>
		<table>
			<thead>
				<th><input type="checkbox" id="checkAll" name="checkAll"></th>				
				<th>파일명</th>
				<th>파일용량</th>
				<th>작성일</th>
				<th>다운로드</th>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach var="ResumeVO" items="${list}">
						<tr>
							<td><input type="checkbox" id="check" name="check" ></td>
							<td><c:out value="${ResumeVO.org_file_name}"/></td>
							<td><c:out value="${ResumeVO.file_size}"/></td>
							<td><c:out value="${ResumeVO.reg_dt}"/></td>
							<td><input type="button" value="다운로드" onclick="#" ></td>							
						</tr>						
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="99">올린 이력서 파일이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</form>
</body>
</html>