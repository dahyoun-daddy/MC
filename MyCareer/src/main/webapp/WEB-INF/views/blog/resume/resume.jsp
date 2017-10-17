<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String contextPath = request.getContextPath();
	contextPath = "http://localhost:8080/" + contextPath;
	//로그인된 회원의 아이디
	String logined_Id = ""; 
	if(session.getAttribute("user_id").toString() !=null ){
		logined_Id = session.getAttribute("user_id").toString();
	}else{
		logined_Id = "";
	}
	//블로그 주인의 아이디
	String blogOwner_Id = request.getAttribute("user_id").toString();
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">   
<title>Insert title here</title>
<script type="text/javascript">
	//다운로드 버튼 눌렀을때 파일 다운로드
 	 function do_down(){
		var frm = document.orgfrm;
		alert(frm);
		//var thisplus = $(this);
	    //alert(thisplus.text());
	    //var record = $(thisplus).parents("tr");
	    //alert(record.text());
	    //var org_file_name = $(record).find('td').eq(1).text();
	    //alert(org_file_name);
	  	//var file_path = $(record).find(".file_path").val();
	    //alert(file_path);		    		
	    //var save_file_name = $(record).find(".save_file_name").val();
    	//alert(save_file_name);
    	frm.action = "download.do";
    	frm.method = "GET";
    	frm.submit();
	}
	
	//이력서 파일 저장
	function do_fileSave(){
		var frm = document.frm;		
		var file = document.frm.file.value;
		alert(file);
		if(frm.file.value<1){
			alert("선택한 파일이 없습니다.");
			frm.location.reload();
			return;
		}
//		var file = frm.file.value;
//		console.log(file);
		var fileExt = file.substring(file.lastIndexOf(".")+1).toLowerCase();
		alert(fileExt);
		if(file!= "" && (fileExt == 'doc' || fileExt == 'docx' || fileExt == 'hwp') ){
			alert("이력서 파일이 업로드 되었습니다.");
			frm.action = "upload.do";
			frm.submit();
		}else{
			alert("doc, docx, hwp로 된 파일만 업로드할 수 있습니다.");
			frm.location.reload();
			return;
		}
		
	}
	$(document).ready(function(){
		//최상단 체크박스 클릭
		$("#checkAll").click(function(){
	        //클릭되었으면
	        if($("#checkAll").prop("checked")){
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
	            $("input[name=check]").prop("checked",true);
	            //클릭이 안되있으면
	        }else{
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
	            $("input[name=check]").prop("checked",false);
	        }
	    });//--최상단 체크박스 클릭
	    
	    //do_delete
	    $("#do_delete").on("click", function(){
	    	var file_idArray = new Array();
	    	//checked
	    	$("#check:checked").each(function(idx,row){
	    		var record = $(row).parents("tr");
	    		var file_id = $(record).find('#file_id').val();
	    		//console.log(file_id);
	    		file_idArray.push(file_id);	    		
	    	});//--checked
	    	console.log(file_idArray);
	    	if(file_idArray.length<=0){
	    		alert("삭제할 이력서를 선택해주세요.");
	    		return false;
	    	}
	    	if(false==confirm("삭제하시겠습니까?")){
	    		return;
	    	}
	    	
	    	var jsonFile_idList = JSON.stringify(file_idArray);
	    	console.log("jsonFile_idList: " + jsonFile_idList);
	    	
	    	$.ajax({
	    		url:"do_checkedDelete.do",
	    		type:"POST",
	    		dataType:"JSON",
	    		async:false,
	    		data:{
	    			"file_idList":jsonFile_idList
	    		},
	    		success: function(data){
	    			console.log("success data: " + data);	    			
	    			alert("총 "+data.no+"건이 삭제되었습니다.");
	    			return location.reload();
	    		},
	    		complete: function(data){
	    			
	    		},
	    		error: function(xhr, status, error){
	    			console.log("삭제 error입니다" + error);	
	    		}
	    	});
	    });//--do_delete
	    
	    //do_down
	    
	    $(".do_down").on("click", function(){
	    	alert("파일을 다운로드 하시겠습니까?");
	    	//var record = $(row).parents("tr");
	    	
		    var thisplus = $(this);
		    //alert(thisplus.text());
		    var record = $(thisplus).parents("tr");
		    //alert(record.text());
		    var org_file_name = $(record).find('td').eq(1).text();
		    //alert(org_file_name);
		  	var file_path = $(record).find(".file_path").val();
		    //alert(file_path);		    		
		    var save_file_name = $(record).find(".save_file_name").val();
	    	//alert(save_file_name);
	    	var frm = $("documnet").orgfrm();
	    	$.ajax({	    		
	    		url:"download.do",
	    		type:"GET",	    		
	    		dataType:"html",
	    		async:false,
	    		data:{
	    			"file_path":file_path,
	    			"org_file_name":org_file_name,
	    			"save_file_name":save_file_name
	    		},
	    		success: function(data){	    			
	    			alert("success data: " + data);
					frm.submit();    			
	    			//alert("선택한 이력서 파일이 다운로드 되었습니다.");
	    			//return location.reload();
	    		},
	    		complete: function(data){
	    			//alert("complete탐");
	    		},
	    		error: function(xhr, status, error){
	    			console.log("error입니다" + error);	
	    		}
	    	});
	    });//--do_down
	    
	    
	}); //--jquery document
</script>
</head>
<body>
	<h3>이력서 파일 게시판입니다.</h3>	
	<!-- TODO 블로그 주인과 로그인한 회원이 다를 경우 div 안보이게 -->
	<!-- 블로그 주인과  -->
<%
	String str = "";
	if(logined_Id.equals(blogOwner_Id)){
		str = "style=\"display:block\""; //보이게
	}else{
		str = "style=\"display:none\""; //안보이게
	}
%>	
	<div align="right" <%=str%> >		
		<button id="do_delete" >삭제</button>&emsp;
	</div>
	<br/>
	<form name="orgfrm">
		<table border="1" width="99%" class="w3-table-all w3-card-4">
			<input type="hidden" name="user_id" value="<%=blogOwner_Id%>">
			<thead align="center">
				<tr class="w3-blue w3-centered" align="center">
					<th align="center" class="text-center"><input type="checkbox" id="checkAll" name="checkAll"></th>				
					<th align="center" class="text-center">파일명</th>
					<th align="center" class="text-center">파일용량(kb)</th>
					<th align="center" class="text-center">작성일</th>
					<th align="center" class="text-center">확장자명</th>
					<th <%=str%> align="center" class="text-center">다운로드</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach var="ResumeVO" items="${list}">
						<tr>
							<td class="text-center"><input type="checkbox" id="check" name="check" ></td>
							<td class="text-left org_file_name"><c:out value="${ResumeVO.org_file_name}"/></td>
							<td class="text-right"><c:out value="${ResumeVO.file_size}"/></td>
							<td class="text-center"><c:out value="${ResumeVO.reg_dt}"/></td>
							<td class="text-center"><c:out value="${ResumeVO.file_ext}"/></td>
							<!-- TODO -->
							<!-- 블로그 주인과 로그인한 회원이 다를 경우 클릭이 되지 않도록 한다. -->
							<!-- <td class="text-center"><button type="button" class="do_down">다운로드</button></td> -->
							<td <%=str%> class="text-center"><input type="button" value="다운로드" onclick="javascript:do_down();" ></td>
							<input type="hidden" name="file_id" id="file_id" value="${ResumeVO.file_id}" >
							<input type="hidden" name="file_path" class="file_path" value="${ResumeVO.file_path}" >
							<input type="hidden" name="save_file_name" class="save_file_name" value="${ResumeVO.save_file_name}" >						
						</tr>						
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="99" class="text-center">올린 이력서 파일이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>		
	</form>
	<hr/>
	<div <%=str%> >
        <div>이력서 업로드</div>
        
        <form method="post" name="frm" enctype="multipart/form-data">
        	<input type="hidden" name="user_id" value="<%=blogOwner_Id%>">           
            <div style="border:1px dotted green; width:99%">               
                <div>
                   <input type="file" name="file" id="file"/>   
                </div>                                                               
                <button class="btn btn-success btn-sm" onclick="do_fileSave()">업로드
                </button>
            </div>        
        </form>
        
    </div>
</body>
</html>