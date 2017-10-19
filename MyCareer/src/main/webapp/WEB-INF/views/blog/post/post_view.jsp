<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080/"+contextPath;  
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
		login_id = "";//debug
	}
	
	
	
	
	

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
<title>:::::블로그 포스팅:::::</title>
<script language="javaScript">

$(document).ready(function(){
	
});
	
	function doSearch(){
	    var frm = document.frm;
	    frm.action = "post_doSearch.do?user_id=<%=user_id%>";
	    frm.submit();
	}
	
	function readPost(post_id){
		var frm = document.frm;
		frm.method = "POST";
	    frm.action = "post_edit_form.do?user_id=<%=user_id%>";
	    frm.post_id.value = post_id;
	    frm.submit();
	}
</script>
</head>
<body>
	<div id="wrapper" align = "center">
		<div id="content">
		
		<!-- form -->
		<form name = "frm" method = "post" action = "post_doSave.do">
			<input type="hidden" value="${PostDTO.post_id}" id="post_id" name="post_id"/>
	
			
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
							<div class="card-header" data-background-color="purple">
								<h2 class="title"></h2>
								<p class="category"></p>
							</div>
						</div>
					</div>
				</div>
			
			<!-- table -->
			<table width="100%" border="3" align="center" id="post_form">
				<tr>
					<td width="10%" align="center">작성자</td>
					<td width="90%"><input type = "text" name = "reg_id" size = "40" value="${PostDTO.reg_id}" disabled="disabled"/></td>
				</tr>
				<tr>
					<td width="10%" align="center">제목</td>
					<td width="90%"><input type = "text" name = "post_title" value="${PostDTO.post_title}" size = "40" disabled="disabled"/></td>
				</tr>
				
				<tr>
					<td width="10%" id="title"  align="center">내용</td>
					<td width="90%">${PostDTO.post_content}</td>
				</tr>				
				<tr>
					<tr align="center" valign="middle">
					<td colspan="5">
						<%
							if(user_id != null && user_id.equals(login_id)){
						%>
							<input onclick="readPost('${PostDTO.post_id}');" type = "button" class="btn btn-md  purple-bg" value="수정하기" /></a>
    					<%
							}
    					%>
    					<button class="btn btn-success"  onclick="doSearch()">목록으로</button>
					</td>
				</tr>
			</table>
			<!-- //table -->
		</form>
		<!-- //form -->
		</div>
		
	</div>

</body>
</html>