<%@page import="project.mc.commons.RecruitParse"%>
<%@page import="project.mc.blog.recruit.domain.ParseVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String pageNo = "0";
ParseVO vo = new ParseVO();
String empty = (String)session.getAttribute("pageNo");
List<ParseVO> list = new ArrayList<ParseVO>();

vo.setTotalNo(100);
RecruitParse rp = new RecruitParse();
if(empty.equals("") && empty.isEmpty()){
	session.setAttribute("pageNo", pageNo);
}else{
	pageNo = (String)session.getAttribute("pageNo");
}
list = rp.SaramParse(pageNo);
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
<script type="text/javascript">
function do_search_page(url, page_num){
    var frm = document.frm;
    frm.page_num.value = page_num;
    frm.action = url;
    frm.submit();
}
</script>   
<title>Insert title here</title>
</head>
<body>
    <table id="listTable"  class="table table-bordered table-hover table-striped" >
       <thead>
           <th class="text-center">공고 제목</th>
           <th class="text-center">회사명</th>
           <th class="text-center">공고 마감일</th>
           <th class="text-center">공고 주소</th>
           <th class="text-center">연봉</th>
        </thead>
        <tbody >
        <c:choose>
           <c:when test="${list.size()>0}" >
               <c:forEach var="ParseVO" items="${list}">
                       <tr><td class="text-center"><input type="checkbox" id="check" name="check" /> </td>
                           <td class="text-left"><c:out value="${ParseVO.reSubject}"/></td>
                           <td class="text-left"><c:out value="${ParseVO.reCompany}"/></td>
                           <td class="text-left" style="cursor:pointer" onclick="goRecruit('${ParseVO.reUrl}');"><c:out value="${ParseVO.reUrl}"/></td>
                           <td class="text-center"><c:out value="${ParseVO.reSalary}"/></td>
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
           <div class="form-inline text-center ">
                
           </div>
           
    
</body>
</html>