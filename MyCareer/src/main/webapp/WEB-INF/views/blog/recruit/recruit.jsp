<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="project.mc.commons.StringUtil" %>
<%@ page import="project.mc.blog.user.domain.UserVO" %>
<%  //contextPath
String contextPath = request.getContextPath();
contextPath = "http://localhost:8080/"+contextPath;
%>
<%
int bottomCount = 10;
String page_num = "1";
String page_size = "10";
int totalCnt = 100;

page_size = StringUtil.nvl(request.getParameter("page_size"),"10");
page_num  = StringUtil.nvl(request.getParameter("page_num"),"1");

int oPage_size = Integer.parseInt(page_size);
int oPage_num  = Integer.parseInt(page_num);

String user_id = request.getParameter("user_id");
%>  
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 부트스트랩 -->
<link href="<%=contextPath%>/resources/css/bootstrap.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/bootstrap-theme.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">   
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-3.2.1.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="<%=contextPath%>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
function do_search_page(url, page_num){
    var frm = document.frm;
    frm.page_num.value = page_num;
    var user_id = frm.user_id.value;
    url = url + "?user_id=" + user_id;
    frm.action = url;
    frm.submit();
}
function readPop(url){
    window.open(
            url,
            "pop",
            "menubar=no,width=800,height=600,toolbar=no"
            );
}
</script>
<title>Insert title here</title>
</head>
<body>
    <h3>공채 목록</h3>
    <form name="frm" id="frm" method="GET" action="recruit.do">
        <input type="hidden" name="page_num" value="1"/>
        <input type="hidden" name="user_id" value="<%=user_id%>"/>
        <table id="listTable"  class="table table-bordered table-hover table-striped w3-table-all w3-card-4" >
           <thead>
            <tr class="w3-blue w3-centered" align="center">
               <th class="text-center">공고 제목</th>
               <th class="text-center">회사명</th>
               <th class="text-center">공고 마감일</th>
               <th class="text-center">연봉</th>
             </tr>
            </thead>
            <tbody >
            <c:choose>
               <c:when test="${list.size()>0}" >
                   <c:forEach var="ParseVO" items="${list}">
                           <tr><td class="text-left" style="cursor:pointer" onclick="readPop('${ParseVO.reUrl}');"><c:out value="${ParseVO.reSubject}"/></td>
                               <td class="text-left" style="cursor:pointer" onclick="readPop('${ParseVO.reUrl}');"><c:out value="${ParseVO.reCompany}"/></td>
                               <td class="text-center"><c:out value="${ParseVO.reExDate}"/></td>
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
                <%=StringUtil.renderPaging(totalCnt, oPage_num, oPage_size, bottomCount, "parse.do", "do_search_page") %>
           </div>
         </form>   
</body>
</html>