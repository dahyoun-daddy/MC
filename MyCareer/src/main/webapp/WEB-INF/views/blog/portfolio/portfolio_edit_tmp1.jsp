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
		
		$(".pf_img").click(function(e){
			alert("pf_img");
			e.preventDefault();
			$("#file1").click();
		});
		
		
	});

	function changeValue(obj){
        alert(obj.value);
        var file2 = document.all.file1.value;
		alert("file2: "+file2);
		$("#file2").val(file2);
		
		e.preventDefault();

		  var file = upload.files[0],
		      reader = new FileReader();
		  reader.onload = function (event) {
		    var img = new Image();
		    img.src = event.target.result;
		    // note: no onload required since we've got the dataurl...I think! :)
		    if (img.width > 560) { // holder width
		      img.width = 560;
		    }
		    holder.innerHTML = '';
		    holder.appendChild(img);
		  };
		  reader.readAsDataURL(file);

		  return false;
		
		
    }


	
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
			<a href="<%=contextPath%>/blog/portfolio_view_tmp1.do">포트폴리오 저장</a>
		</div>
		<div id=contents align="center">
			<img class="pf_img" src="" alt="tmp1_02" id="tmp1_02">
			<img class="pf_img" src="" alt="tmp1_03" id="tmp1_03">
			<img class="pf_img" src="" alt="tmp1_04" id="tmp1_04">
			<img class="pf_img clearfix" src="" alt="tmp1_05" id="tmp1_05">
			
			<img class="pf_img clearfix" src="" alt="tmp1_01" id="tmp1_01">
			<input type=file name='file1' id="file1" style='display: none;'  onchange="changeValue(this)">
			<input type='text' name='file2' id='file2'> 
			
			<img class="pf_img" src="" alt="tmp1_06" id="tmp1_06">
			<img class="pf_img" src="" alt="tmp1_07" id="tmp1_07">
			<img class="pf_img" src="" alt="tmp1_08" id="tmp1_08">
			<img class="pf_img clearfix" src="" alt="tmp1_09" id="tmp1_09">
			
			
			
			<div id="clearfix"></div>
		</div>
	</div>
	
	
</body>
</html>