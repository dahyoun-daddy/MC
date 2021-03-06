<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080/"+contextPath;
  String reg_id = request.getParameter("user_id").toString();
  
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
<title>상세 페이지</title>
<!-- 부트스트랩 -->
  
<link href="<%=contextPath%>/resources/css/bootstrap.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"/>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="<%=contextPath%>/resources/js/bootstrap.min.js"></script>  
<script src="https://cdn.ckeditor.com/4.7.3/full-all/ckeditor.js"></script>  
<title>:::::사용자관리:::::</title>
<script language="javaScript">
 
		
$(document).ready(function(){
	CKEDITOR.replace('ck1');
	
	//do_save
	$("#do_save").on("click",function(){
		if(CKEDITOR.instances.ck1.getData().length < 1){
			alert("내용을 입력해 주세요.");
			return;
		}
		
	   if(false==confirm("등록하시겠습니까?"))return;
	   
       $.ajax({
           type:"POST",
           url:"post_doSave_form.do",
           dataType:"html",// JSON
           async: false,
           data:{
              "post_title"       :$("#post_title").val(),
              "post_content"     :CKEDITOR.instances.ck1.getData(),
              "reg_id" :$("#reg_id").val()
              
           },
           success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
               console.log("success data: "+data);
           	   location.href="/mc/blog/post/post_doSearch.do?user_id=<%=login_id%>"
           },
           complete: function(data){//무조건 수행
               
           },
           error: function(xhr,status,error){
        	   console.log("error: "+error);
           }
       });			
		
	});//--do_save
});

function doSearch(){
    var frm = document.frm;
    frm.action = "post_doSearch.do?user_id=<%=user_id%>";
    frm.submit();
}

</script>
</head>
<body>
    <h3>글쓰기</h3>
    <hr/>
    
	<form name="frm" method="POST" action="post_doSave.do">
		<input type="hidden"  name="page_num" id="page_num" value="1"  >
        	제목    : <input type="text" id="post_title" name="post_title" /><br/>
       <textarea id="ck1" name="ck1"></textarea>
		<input type="hidden" id="reg_id" value="<%=reg_id%>"/>
	</form>
    <button class="btn btn-success"  id="do_save">등록</button>
    <button class="btn btn-success"  onclick="doSearch()">취소(목록으로)</button>
</body>
</html>