<%@page import="project.mc.blog.post.domain.StringUtil"%>
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
<title>:::::사용자관리:::::</title>
<script language="javaScript">

	/* 체크박스 전체선택, 전체해제 */
	function checkAll() {
		
	    if( $("#checkAll").is(':checked') ){
	        $("input[name=check]").prop("checked", true);
	    }else{
	        $("input[name=check]").prop("checked", false);
	    }
	    
	}
	
	//do_searchOne
	$("#listTable>tbody").on("dblclick","tr",function(){
		var tr = $(this);
		var td = tr.children();
		var id = td.eq(2).text()
		
		$.ajax({
			type:"POST",
			url:"post_doSelectOne.do",
			dataType:"html",
			data:{
				"id":id
			},
			success: function(data){
				var userVO = $.parseJSON(data);
				$("#workDiv").val(userVO.id);
				
				$("#post_id").val(userVO.post_id);
				$("#gb_name").val(userVO.gb_name);
				$("#gb_email").val(userVO.gb_email);
				$("#gb_date").val(userVO.gb_date);
				$("#gb_password").val(userVO.gb_password);
				$("#gb_title").val(userVO.gb_title);
				$("#gb_contents").val(userVO.gb_contents);
				
			},
			complete:function(data){
				
			},
			error:function(xhr, status, error){
				console.log("error: "+error);
				
			}
			
		});
		
	});//do_searchOne
	
	//paiging 이동
		function do_search_page(url, page_num){
		    console.log(url +"\t"+ page_num);
		    var frm = document.frm;
		    frm.page_num.value = page_num;
		    frm.action = url;
		    frm.submit();
		}
		
		function doSearch(){
		    var frm = document.frm;
		    frm.page_num.value = "1";
		    frm.action = "post_doSearch.do";
		    frm.submit();
		}
		
		//do_delete
		function do_delete(){
			
		}

		
		
		//do_save
		$("#do_save").on("click",function(){
		   
		   if(false==confirm("등록하시겠습니까?"))return;
		   
		   var workDiv = $("#workDiv").val();
		   var insertYN = (workDiv == "")?"":"update";
		   console.log("insertYN: "+insertYN);
	       $.ajax({
               type:"POST",
               url:"doSave.do",
               dataType:"html",// JSON
               async: false,
               data:{
                  "workDiv"  : insertYN,
                  "id"       :$("#gb_id").val(),
                  "name"     :$("#gb_name").val(),
                  "email"    :$("#gb_email").val(),
                  "date"     :$("#gb_date").val(),
                  "title"    :$("#gb_title").val(),
                  "contents" :$("#gb_contents").val()
               },
               success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
                   //console.log("success data: "+data);
                   doSearch();
               },
               complete: function(data){//무조건 수행
                   
               },
               error: function(xhr,status,error){
            	   console.log("error: "+error);
               }
           });			
			
		});//--do_save
		
		

</script>
</head>
<body>  
	<h3>UserList</h3>
    <hr/>
    
     <form name="frm" action="doSearch.do" method="post" class="form-inline">
         <input type="hidden"  name="page_num" id="page_num" value="<%=page_num %>"  >
         <input type="hidden"  name="file_nm"  id="file_nm"  >
<!-- Button Area -->    
	<div class="form-inline pull-right ">
      <select name="page_size" id="page_size" class="form-control input-sm">
              <option value="10"  <%if(page_size.equals("10"))out.print("selected='selected'"); %>>10</option>
              <option value="20"  <%if(page_size.equals("20"))out.print("selected='selected'"); %>>20</option>
              <option value="50"  <%if(page_size.equals("50"))out.print("selected='selected'"); %>>50</option>
      </select>	
	  <button class="btn btn-success" 
	  onclick="javascript:doSearch()">조회</button>
	  <button class="btn btn-success"  id="do_save">등록</button>
	  <button class="btn btn-success" id="do_delete">삭제</button>
	 </div>
<!--// Button Area -->
		<table  class="table">
	         <tr>
	             <td class="text-center">구분
	                 <select name="searchDiv" class="form-control input-sm">
                        <option value="">전체</option>
                        <option value="10" <%if(searchDiv.equals("10"))out.print("selected='selected'"); %>>제목</option>
                        <option value="20" <%if(searchDiv.equals("20"))out.print("selected='selected'"); %>>내용</option>
	                 </select>
	                 <input type="text" class="form-control input-sm" name="searchWord"  size="10"  value="<%=searchWord %>">
	                 <c:out value="${list.size()}"/>/<c:out value="${totalCnt}"/>
	             </td>
	             </tr>
	     </table>
     </form>
    
     <table id="listTable"  class="table table-bordered table-hover table-striped" >
        <thead>
            <th class="text-center">
                <input type="checkbox" id="checkAll" 
                name="checkAll" onclick="checkAll();" />
            </th>
            <th class="text-center"> </th>
            <th class="text-center">글 번호</th>
            <th class="text-center">아이디</th>
            <th class="text-center">제목</th>
            <th class="text-center">내용</th>
            <th class="text-center">작성일자</th>

            
        </thead>
        <tbody >
        <c:choose>
            <c:when test="${list.size()>0}" >
                <c:forEach var="PostDTO" items="${list}">
		                <tr><td class="text-center"><input type="checkbox" id="check" name="check" /> </td>
		               		<td class="text-left"></td>
		                    <td class="text-left"><c:out value="${PostDTO.post_id}"/></td>
		                    <td class="text-left"><c:out value="${PostDTO.reg_id}"/></td>
		                    <td class="text-center"><c:out value="${PostDTO.post_title}"/></td>
		                    <td class="text-left"><c:out value="${PostDTO.post_content}"/></td>
		                    <td class="text-center"><c:out value="${PostDTO.reg_dt}"/></td>
		                </tr>       
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr >
                    <td colspan="99">등록된 게시글이 없습니다.</td>
                </tr>    
            </c:otherwise>
        </c:choose>
        </tbody>
     </table>
            <!-- Paging << < 1 2 ... > >> -->
            <div class="form-inline text-center ">
                <%=StringUtil.renderPaging(totalCnt, oPage_num, oPage_size, bottomCount, "doSearch.do", "do_search_page") %>
            </div>
            <!--// Paging << < 1 2 ... > >> -->

</body>
</html>

