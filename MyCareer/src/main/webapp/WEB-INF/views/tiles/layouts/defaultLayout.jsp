<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#wrapper{
		position:relative;
	}
	
	#header{
		margin:2%;
	}

	#menu{
		float:left;
		position:fixed;
	}
	
	#body{
		margin:3%;
		margin-left:20%;
		width:70%;
		border-width: 1px;
		border-color: #7f7f7f;
		border-style: dashed;
		border-radius: 5px;
	}

</style>
<title>블로그 메인 페이지</title>
</head>
<body>
	
	<div id="wrapper">
		<div id="header" align="center">
			<tiles:insertAttribute name="header"/>
		</div>
		
		<div id="menu">
            <tiles:insertAttribute name="menu" />
        </div>
		
		<div id="container" align="center">
            <div id="body">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
	
		
	</div>
	
</body>
</html>