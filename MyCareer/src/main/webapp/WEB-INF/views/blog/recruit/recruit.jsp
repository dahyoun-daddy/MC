<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="project.mc.commons.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
int bottomCount   = 10;
String searchDiv  = "";
String searchWord = "";
String page_size  = "10";
String page_num   = "1";
int totalCnt      = 0; //총글수

searchDiv = StringUtil.nvl(request.getParameter("searchDiv"),"");
searchWord= StringUtil.nvl(request.getParameter("searchWord"),"");
page_size = StringUtil.nvl(request.getParameter("page_size"),"10");
page_num  = StringUtil.nvl(request.getParameter("page_num"),"1");

int oPage_size = Integer.parseInt(page_size);
int oPage_num  = Integer.parseInt(page_num);

totalCnt = Integer.parseInt(
            StringUtil.nvl(
            request.getAttribute("totalCnt").toString(),"0"));

%>

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
<title>Insert title here</title>
</head>
<body>
    
</body>
</html>