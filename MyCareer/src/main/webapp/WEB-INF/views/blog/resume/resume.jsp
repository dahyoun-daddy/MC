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
<!-- 부트스트랩 -->
<link href="<%=contextPath%>/resources/css/bootstrap.css" 
    rel="stylesheet" >    
<link href="<%=contextPath%>/resources/css/bootstrap-theme.min.css" 
    rel="stylesheet" >
<!--// 부트스트랩 -->

<!-- JQuery -->
<script type="text/javascript" 
  src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<!-- 부트스트랩 플러그인 -->  
<script type="text/javascript" 
  src="<%=contextPath%>/resources/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
<script type="text/javascript">
	function do_fileSave(){
		var frm = document.frm;		
		var file = document.frm.file.value;
		alert(file);
		if(frm.file.value<1){
			alert("선택한 파일이 없습니다.");
			frm.location.reload();
			return;
		}
//		var file = frm.file.value;
//		console.log(file);
		var fileExt = file.substring(file.lastIndexOf(".")+1).toLowerCase();
		alert(fileExt);
		if(file!= "" && (fileExt == 'doc' || fileExt == 'docx' || fileExt == 'hwp') ){
			alert("이력서 파일이 업로드 되었습니다.");
			frm.action = "upload.do";
			frm.submit();
		}else{
			alert("doc, docx, hwp로 된 파일만 업로드할 수 있습니다.");
			frm.location.reload();
			return;
		}		
	}
</script>
</head>
<body>
	<h2>이력서 파일 게시판입니다.</h2>
	<hr/>
	<div align="right" >
		<button>다운로드</button>
		<button>삭제</button>
	</div>
	<form>
		<table border="1" width="95%">
			<thead>
				<th class="text-center"><input type="checkbox" id="checkAll" name="checkAll"></th>				
				<th class="text-center">파일명</th>
				<th class="text-center">파일용량(kb)</th>
				<th class="text-center">작성일</th>
				<th class="text-center">확장자명</th>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach var="ResumeVO" items="${list}">
						<tr>
							<td class="text-center"><input type="checkbox" id="check" name="check" ></td>
							<td><c:out value="${ResumeVO.org_file_name}"/></td>
							<td><c:out value="${ResumeVO.file_size}"/></td>
							<td><c:out value="${ResumeVO.reg_dt}"/></td>
							<td><c:out value="${ResumeVO.file_ext}"/></td>							
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
	<hr/>
<%
	//TODO
	//블로그 주인과 로그인된 회원의 아이디가 같으면 보이게 하고 다르면 안 보이게 하기
	//String str = "";
	//if(blog_owner.equals(request.getParameter("loginedId"))){
  	//	str = "style=\"display:block\""; 
	//}else{
	//	str = "style=\"display:none\"";
	//}
%>	
	<div <%-- TODO<%=str%> --%> >
        <div>이력서 업로드</div>
        
        <form method="post" name="frm" enctype="multipart/form-data">            
            <div>               
                <div>
                   <input type="file" name="file" id="file"/>   
                </div>                                                               
                <button onclick="do_fileSave()">업로드
                </button>
            </div>        
        </form>
        
    </div>
</body>
</html>