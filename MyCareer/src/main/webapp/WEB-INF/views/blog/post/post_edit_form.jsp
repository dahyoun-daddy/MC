<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
  //contextPath
  System.out.println(request.getContextPath());
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080/"+contextPath;  
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
<script src="https://cdn.ckeditor.com/4.7.3/full-all/ckeditor.js"></script>  
<title>:::::블로그 포스팅:::::</title>
<script language="javaScript">

$(document).ready(function(){
	CKEDITOR.replace('post_content');
	
	//do_save
	$("#do_save").on("click",function(){
		if(CKEDITOR.instances.post_content.getData().length < 1){
			alert("내용을 입력해 주세요.");
			return;
		}
		
	   if(false==confirm("등록하시겠습니까?"))return;
	   
       $.ajax({
           type:"POST",
           url:"post_doSave.do",
           dataType:"html",// JSON
           async: false,
           data:{
              "post_title"       :$("#post_title").val(),
              "post_content"     :CKEDITOR.instances.post_content.getData(),
              "reg_id" :$("#reg_id").val()
              
           },
           success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
               console.log("success data: "+data);
           		alert("등록되었습니다.");
               doSearch();
           },
           complete: function(data){//무조건 수행
               
           },
           error: function(xhr,status,error){
        	   console.log("error: "+error);
           }
       });			
		
	});//--do_save
});
	//수정
	function doUpdate(){
		var frm = document.frm;
		
		if(CKEDITOR.instances.post_content.getData().length < 1){
			alert("내용을 입력해 주세요.");
			return;
		}
		frm.action = "post_do_Update.do";
	    frm.submit();
	}
	
	
	function doSearch(){
	    var frm = document.frm;
	    frm.action = "post_doSearch.do";
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
			<table width="700" border="3" align="center" id="post_form">
				<tr>
					<td align="center">작성자</td>
					<td><input type = "text" name = "reg_id" size = "40" value="${PostDTO.reg_id}" disabled="disabled"/></td>
				</tr>
				<tr>
					<td align="center">제목</td>
					<td><input type = "text" name = "post_title" value="${PostDTO.post_title}" size = "40"/></td>
				</tr>
				
				<tr>
					<td id="title"  align="center">내용</td>
					<td colspan="2">
						<textarea id="post_content" name="post_content"><c:out value="${PostDTO.post_content}"/></textarea>
					</td>
				</tr>
				<tr>
					<tr align="center" valign="middle">
					<td colspan="5">
						<input type = "button" class="btn btn-md  purple-bg" onclick="javascript:doUpdate();" value="확인"/>
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