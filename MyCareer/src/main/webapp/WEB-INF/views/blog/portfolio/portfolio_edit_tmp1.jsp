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
			alert("do_save")
			
			
			
			frm.submit();
		});
		
		
		$(".pf_img").click(function(e){
			e.preventDefault();
			var img = $(this).attr("id");
			var i = img.substring(img.length-2);
			var getfile = "getfile_"+i;
			
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
			<form name="frm" method="post" action="portfolio_save.do" enctype="multipart/form-data">
			<input type="hidden" name="tmp_no" id="tmp_no" value="01">
			<input type="hidden" name="user_id" id="user_id" value="111">
			<input type="hidden" name="workDiv" id="workDiv" value="pf_save">
			<input type="hidden" name="table_div" id="table_div" value="31">
			<input type="hidden" name="table_id" id="table_id" value="63">
			
			<img class="pf_img" src="" alt="tmp1_02" id="tmp1_02">
			<img class="pf_img" src="" alt="tmp1_03" id="tmp1_03">
			<img class="pf_img" src="" alt="tmp1_04" id="tmp1_04">
			<img class="pf_img clearfix" src="" alt="tmp1_05" id="tmp1_05">
			
			<img class="pf_img clearfix" src="" alt="tmp1_01" id="tmp1_01">
			
			<img class="pf_img" src="" alt="tmp1_06" id="tmp1_06">
			<img class="pf_img" src="" alt="tmp1_07" id="tmp1_07">
			<img class="pf_img" src="" alt="tmp1_08" id="tmp1_08">
			<img class="pf_img clearfix" src="" alt="tmp1_09" id="tmp1_09">
			
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