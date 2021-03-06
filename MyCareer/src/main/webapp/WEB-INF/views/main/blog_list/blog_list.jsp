<%@page import="project.mc.blog.post.domain.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
int bottomCount   = 10;
String searchDiv  = "10";
String searchWord = "";
String page_size  = "10";
String page_num   = "1";
int totalCnt      = 0; //총글수

searchWord= StringUtil.nvl(request.getParameter("searchWord"),"");
page_size = StringUtil.nvl(request.getParameter("page_size"),"10");
page_num  = StringUtil.nvl(request.getParameter("page_num"),"1");

int oPage_size = Integer.parseInt(page_size);
int oPage_num  = Integer.parseInt(page_num);

totalCnt = Integer.parseInt(
		    StringUtil.nvl(
			request.getAttribute("totalCnt").toString(),"0"));

String login_id = "";
if(session.getAttribute("user_id") != null){
	login_id = session.getAttribute("user_id").toString();
}
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
<title>:::::블로그 포스팅:::::</title>
<script language="javaScript">

	//paiging 이동
	function do_search_page(url, page_num){
	    console.log(url +"\t"+ page_num);
	    var frm = document.frm;
	    frm.page_num.value = page_num;
	    frm.action = url+"?page_num="+page_num;;
	    frm.submit();
	}
	
	function doSearch(){
	    var frm = document.frm;
	    frm.page_num.value = "1";
	    frm.method = "GET";
	    frm.action = "post_doSearch.do";
	    frm.submit();
	}
	
	function readPost(post_id, reg_id){
		var frm = document.frm;
		frm.method = "POST";
		frm.post_id.value = post_id;
	    frm.action = "post_doSelectOne.do?user_id="+reg_id+"&post_id="+post_id;
	    frm.submit();
	}
	

</script>
</head>
<body>
    
     <form name="frm" action="doSearch.do" method="post" class="form-inline">
         <input type="hidden"  name="page_num" id="page_num" value="<%=page_num %>"  >
         <input type="hidden"  name="post_id" id="post_id" value=""  >
	<!-- Button Area -->    
	<div class="form-inline pull-right ">
      <select name="page_size" id="page_size" class="form-control input-sm">
              <option value="10"  <%if(page_size.equals("10"))out.print("selected='selected'"); %>>10</option>
              <option value="20"  <%if(page_size.equals("20"))out.print("selected='selected'"); %>>20</option>
              <option value="50"  <%if(page_size.equals("50"))out.print("selected='selected'"); %>>50</option>
      </select>	
	 </div>
     </form>
    
     <table id="listTable"  class="table table-bordered table-hover table-striped" >
        <thead>
            <th class="text-center" style="width: 5%">글 번호</th>
            <th class="text-center" style="width: 60%">제목</th>
            <th class="text-center" style="width: 20%">작성일자</th>
        </thead>
        <tbody >
        <c:choose>
            <c:when test="${list.size()>0}" >
                <c:forEach var="PostDTO" items="${list}">
		                <tr>
		                    <td class="text-left"><c:out value="${PostDTO.post_id}"/></td>
		                    <td class="text-left" style="cursor:pointer" onclick="javascript:readPost('${PostDTO.post_id}','${PostDTO.reg_id}');"><c:out value="${PostDTO.post_title}"/></td>
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
                <%=StringUtil.renderPaging(totalCnt, oPage_num, oPage_size, bottomCount, "post_doSearch.do", "do_search_page") %>
            </div>
            <!--// Paging << < 1 2 ... > >> -->

</body>
</html>

