<%@page import="project.mc.blog.user.domain.UserVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="project.mc.blog.resume.domain.ResumeVO"%>
<%@page import="java.util.List"%>
<%@page import="project.mc.blog.portfolio.domain.PortfolioVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //contextPath
  String contextPath = request.getContextPath();
  contextPath = "http://localhost:8080"+contextPath;  
%>
<%
	
	
	PortfolioVO pfVO = null;
	List<ResumeVO> imgList = null;
	Map<String, String> srcMap = null;
	String pf_id = request.getParameter("pf_id");
	
	if(request.getAttribute("pfVO") != null){
		pfVO = (PortfolioVO)request.getAttribute("pfVO");
		imgList = pfVO.getImgList();
		srcMap = new HashMap<String, String>();
		
		for(ResumeVO rsVO : imgList){
			int seq = rsVO.getSeq();
			String path = "";
			path = contextPath+"\\resources\\uploadImages\\"+rsVO.getSave_file_name()+rsVO.getFile_ext();
			srcMap.put(String.valueOf(seq), path);
		}
		
		pageContext.setAttribute("srcMap", srcMap);  
	}
	
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
	
	#tmp1_01{
		width: 1248px;
	}
	
	
</style>
<title>:::포트폴리오 편집 1:::</title>
<script type="text/javascript">
	$(document).ready(function(){
		
		//적용 버튼 누를 시 다른 템플릿으로 이동
	    $("#tmp_apply").click(function(){
	    	var selected = $("#pf_tmp option:selected").val();
	        var url="<%=contextPath%>/blog/portfolio_edit_"+selected+".do";
	        $(location).attr('href',url);
	        
	    });
		
		$("#do_save_tmp").click(function(){
			var frm = document.frm;
			
			if(<%=pf_id%> != null){
				frm.workDiv.value = "do_update";
			}else{
				frm.workDiv.value = "do_save";
			}
			
			frm.submit();
		});
		
		
		$(".pf_img").click(function(e){
			e.preventDefault();
			var img = $(this).attr("id");
			var i = img.substring(img.length-2);
			var getfile = "getfile_"+i;
			var input = "tmp_img1_"+i;
			
			document.getElementById(img).src = "";
			document.getElementById(input).value = "";
			
			$("#"+getfile).click();
			
			$('#'+getfile).change(function(e){
			    var file = document.querySelector('input[id='+getfile+']').files[0];
			    // 읽기
			    var reader = new FileReader();
			  //파일정보 수집        
		        reader.onload = (function(theFile) 
		        {
		            return function(e) 
		            {
		                //이미지 뷰
		                document.getElementById(img).src = e.target.result;
		            };
		 			
		        })(file);
			  	
		        reader.readAsDataURL(file);
		        document.getElementById(input).value = document.getElementById(img).src;
			});
			
		});
		

	});
	
	
	
</script>
</head>
<body>
	
	<div id="wrapper" align="center">
		<div id="pf_title">
			<h6>포트폴리오 제목</h6>
		</div>
		<div id="buttons">
			<select name="pf_tmp" id="pf_tmp">
			    <option value="" selected="">포트폴리오 템플릿</option>
			    <option value="tmp1" selected="selected">템플릿 1</option>
			    <option value="tmp2">템플릿 2</option>
			</select>
			<button type="button" id="tmp_apply">적용</button>
			<br> 
			<button type="button" id="do_save_tmp" >포트폴리오 저장</button>
		</div>
		<div id=contents align="center">
			<form name="frm" method="post" action="portfolio_upsert.do" enctype="multipart/form-data">
			<input type="hidden" name="pf_id" id="pf_id" value="<%=pf_id%>">
			<input type="hidden" name="tmp_no" id="tmp_no" value="01">
			<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
			<input type="hidden" name="workDiv" id="workDiv" value="">
			<input type="hidden" name="table_div" id="table_div" value="31">
			
			<img class="pf_img" src="${srcMap['2']}" alt="tmp1_02" name="tmp1_02" id="tmp1_02">
			<img class="pf_img" src="${srcMap['3']}" alt="tmp1_03" name="tmp1_03" id="tmp1_03">
			<img class="pf_img" src="${srcMap['4']}" alt="tmp1_04" name="tmp1_04" id="tmp1_04">
			<img class="pf_img clearfix" src="${srcMap['5']}" alt="tmp1_05" name="tmp1_05" id="tmp1_05">
			
			<img class="pf_img clearfix" src="${srcMap['1']}" alt="tmp1_01" name="tmp1_01" id="tmp1_01">
			
			<img class="pf_img" src="${srcMap['6']}" alt="tmp1_06" name="tmp1_06" id="tmp1_06">
			<img class="pf_img" src="${srcMap['7']}" alt="tmp1_07" name="tmp1_07" id="tmp1_07">
			<img class="pf_img" src="${srcMap['8']}" alt="tmp1_08" name="tmp1_08" id="tmp1_08">
			<img class="pf_img clearfix" src="${srcMap['9']}" alt="tmp1_09" name="tmp1_09" id="tmp1_09">
			
			<input type="hidden" name="tmp_img1_01" id="tmp_img1_01" value="${srcMap['1']}">
			<input type="hidden" name="tmp_img1_02" id="tmp_img1_02" value="${srcMap['2']}">
			<input type="hidden" name="tmp_img1_03" id="tmp_img1_03" value="${srcMap['3']}">
			<input type="hidden" name="tmp_img1_04" id="tmp_img1_04" value="${srcMap['4']}">
			<input type="hidden" name="tmp_img1_05" id="tmp_img1_05" value="${srcMap['5']}">
			<input type="hidden" name="tmp_img1_06" id="tmp_img1_06" value="${srcMap['6']}">
			<input type="hidden" name="tmp_img1_07" id="tmp_img1_07" value="${srcMap['7']}">
			<input type="hidden" name="tmp_img1_08" id="tmp_img1_08" value="${srcMap['8']}">
			<input type="hidden" name="tmp_img1_09" id="tmp_img1_09" value="${srcMap['9']}">
			<input type=file name="getfile_01" id="getfile_01" style='display: none;' accept="image/*">
			<input type=file name="getfile_02" id="getfile_02" style='display: none;' accept="image/*">
			<input type=file name="getfile_03" id="getfile_03" style='display: none;' accept="image/*">
			<input type=file name="getfile_04" id="getfile_04" style='display: none;' accept="image/*">
			<input type=file name="getfile_05" id="getfile_05" style='display: none;' accept="image/*">
			<input type=file name="getfile_06" id="getfile_06" style='display: none;' accept="image/*">
			<input type=file name="getfile_07" id="getfile_07" style='display: none;' accept="image/*">
			<input type=file name="getfile_08" id="getfile_08" style='display: none;' accept="image/*">
			<input type=file name="getfile_09" id="getfile_09" style='display: none;' accept="image/*">
			
			<div id="clearfix"></div>
			</form>
		</div>
	</div>
	
	
</body>
</html>