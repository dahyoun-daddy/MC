<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
    String contextPath = request.getContextPath();
    contextPath = "http://localhost:8080/"+contextPath;  

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
<script type="text/javascript">
  function do_fileSave()
  {
	  var frm = document.frm;
	  frm.submit();
  }

</script>  
<title>:::File_Upload</title>
</head>
<body>
    <h3>File Upload</h3>
    <hr/>
    
    <div class="container">
        <div class="col-lg-12"></div>
        <div class="col-lg-12"></div>
        <div class="panel panel-default"></div>
        <div class="panel-heading text-center">파일업로드</div>
        
        <form method="post" name="frm" action="upload.do" 
            enctype="multipart/form-data"
            class="form-horisontal">
            <div class="form-group">
                <label class="col-lg-4 control-label">File</label>
                <div class="col-lg-8">
                   <input type="file" name="file" id="file"
                   class="form-control input-lg" />   
                </div>                                                               
                <button class="btn btn-success" 
                onclick="do_fileSave()">업로드
                </button>
            </div>
        
        </form>
        
    </div>
    

    <div class="container">
         <div class="form-group">
             <label class="col-lg-4 control-label">Upload경로</label>
             <div class="col-lg-8">
             
               <c:forEach var="resumeVO" items="${resume_list}">
<a href="<c:url value='/download.do?path=c:/file/
&fileName=${resumeVO.save_file_name}
&orgFileName=${resumeVO.org_file_name}'/>">
${resumeVO.org_file_name}
</a>               
		                   원본파일:${resumeVO.org_file_name}<br/>
		                   저장파일:${resumeVO.save_file_name}<br/>		                   
		                   파일사이즈:${resumeVO.file_size}<br/>		                   
               </c:forEach>    	
             </div>
         </div>        
    </div>
    
</body>
</html>