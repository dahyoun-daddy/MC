<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080/"+contextPath;  
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
<script src="https://cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>  
<title>:::::사용자관리:::::</title>
<script language="javaScript">
 
$(document).ready(function(){
	CKEDITOR.replace('ck1');
});
	

</script>
</head>
<body>
    <h3>글쓰기</h3>
    <hr/>
    
    int post_id        ; //포스트 id
	int blog_id        ; //소속 블로그 id
	int sup_post_id    ; //상위 게시글 id
	String post_title  ; //제목
	String post_content; //내용
	String reg_id      ; //작성자 id
	String reg_dt      ; //작성일자
	String mod_id      ; //수정자 id
	String mod_dt      ; //수정일자
	int del_flag       ; //삭제 플래그

    <form method="POST" action="doSave.do">
        아이디 : <input type="text" name="post_id" value = "${PostDTO.post_id}"/><br/>
        이름    : <input type="text" name="gb_name"  value="${PostDTO.gb_name}"/><br/>
        이메일 : <input type="text" name="gb_email"  value="${PostDTO.gb_email}"/><br/>
        비밀번호 :<input type="text" name="gb_password"  value="${PostDTO.gb_password}"/><br/>
        제목 :<input type="text" name="post_title"  value="${PostDTO.post_title}"/><br/>
        내용 :<input type="text" name="post_content"   row="20" cols="50" value="${PostDTO.post_content}"/>
        
        <br/>
        
        <textarea name="ck1"></textarea>
        
        
        <input type="submit" value="전송" />
    </form>
</body>
</html>