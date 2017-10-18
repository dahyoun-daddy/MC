<%@page import="project.mc.blog.user.domain.UserVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="project.mc.blog.resume.domain.ResumeVO"%>
<%@page import="java.util.List"%>
<%@page import="project.mc.blog.portfolio.domain.PortfolioVO"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080"+contextPath;  
%>
<%
	
	PortfolioVO pfVO = (PortfolioVO)request.getAttribute("pfVO");
	
	List<ResumeVO> imgList = pfVO.getImgList();
	
	Map<String, String> srcMap = new HashMap<String, String>();
	
	for(ResumeVO rsVO : imgList){
		int seq = rsVO.getSeq();
		String path = "";
		path = contextPath+"\\resources\\uploadImages\\"+rsVO.getSave_file_name()+rsVO.getFile_ext();
		srcMap.put(String.valueOf(seq), path);
	}
	
	pageContext.setAttribute("srcMap", srcMap);  
	
	UserVO usVO = (UserVO)request.getAttribute("usVO");
	String user_id = usVO.getUser_id();
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="<%=contextPath%>/resources/css/bootstrap.css">
<link rel="stylesheet" href="<%=contextPath%>/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="<%=contextPath%>/resources/css/custom-mc.css">
<style type="text/css">
	#buttons{
		text-align:right;
	}
	
	.pf_img{
		width: 230px;
	 	height: 300px;
	 	text-align: left;
	 	float: left;
	 	border: 3px solid gold;
	 	margin: 5px;
	}
	
	#clearfix{
		clear: both;
	}
	
	.clearfix+*{
		clear: both;
	}
	
	#tmp1_01{
		width: 950px;
	}
	
</style>
<title>:::포트폴리오 뷰 1:::</title>
<script>
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<div id=wrapper align="center">
		<div id="pf_title">
			<h6>포트폴리오 제목</h6>
		</div>
		<div id="buttons">
			<a href="<%=contextPath%>/blog/portfolio_edit_tmp1.do?user_id=<%=user_id%>&pf_id=<%=pfVO.getPf_id()%>">편집</a>
			<a href="<%=contextPath%>/blog/portfolio_delete.do?user_id=<%=user_id%>&pf_id=<%=pfVO.getPf_id()%>">삭제</a>
		</div>
		<div id=contents align="center">
			<img class="pf_img" src="${srcMap['2']}" alt="tmp1_02" id="tmp1_02">
			<img class="pf_img" src="${srcMap['3']}" alt="tmp1_03" id="tmp1_03">
			<img class="pf_img" src="${srcMap['4']}" alt="tmp1_04" id="tmp1_04">
			<img class="pf_img clearfix" src="${srcMap['5']}" alt="tmp1_05" id="tmp1_05">
			
			<img class="pf_img clearfix" src="${srcMap['1']}" alt="tmp1_01" id="tmp1_01">
			
			<img class="pf_img" src="${srcMap['6']}" alt="tmp1_06" id="tmp1_06">
			<img class="pf_img" src="${srcMap['7']}" alt="tmp1_07" id="tmp1_07">
			<img class="pf_img" src="${srcMap['8']}" alt="tmp1_08" id="tmp1_08">
			<img class="pf_img clearfix" src="${srcMap['9']}" alt="tmp1_09" id="tmp1_09">
			
			<div id="clearfix"></div>
		</div>
		
		
	</div>
</body>
</html>