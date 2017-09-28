<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080"+contextPath;  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<style type="text/css">
	#buttons{
		text-align:right;
	}
	
	.pf_img{
		width: 300px;
	 	height: 500px;
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
	
	#tmp1_09{
		width: 1248px;
	}
	
</style>
<title>:::포트폴리오 편집 2:::</title>
</head>
<body>
	
	<div id="wrapper" align="center">
		<div id="pf_title">
			<h6>포트폴리오 제목</h6>
		</div>
		<div id="buttons">
			<select name="job">
			    <option value="" selected="selected">포트폴리오 템플릿</option>
			    <option value="tmp_1">템플릿 1</option>
			    <option value="tmp_2">템플릿 2</option>
			</select>
			<br>
			<a href="<%=contextPath%>/blog/portfolio_view_tmp1.do">포트폴리오 저장</a>
		</div>
		<div id=contents align="center">
			<img class="pf_img" src="" alt="tmp1_01" id="tmp1_01">
			<img class="pf_img" src="" alt="tmp1_02" id="tmp1_02">
			<img class="pf_img" src="" alt="tmp1_03" id="tmp1_03">
			<img class="pf_img clearfix" src="" alt="tmp1_04" id="tmp1_04">
			
			<img class="pf_img" src="" alt="tmp1_05" id="tmp1_05">
			<img class="pf_img" src="" alt="tmp1_06" id="tmp1_06">
			<img class="pf_img" src="" alt="tmp1_07" id="tmp1_07">
			<img class="pf_img clearfix" src="" alt="tmp1_08" id="tmp1_08">
			
			<img class="pf_img clearfix" src="" alt="tmp1_09" id="tmp1_09">
			<div id="clearfix"></div>
		</div>
	</div>
	
	
</body>
</html>