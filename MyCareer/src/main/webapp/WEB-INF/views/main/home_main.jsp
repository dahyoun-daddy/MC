<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../js/bootstrap.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/defaultLayout.css?ver=1">
<style type="text/css">
	#searchText{
		margin: 100px;
	}
	
</style>
	<title>:::My Career - main:::</title>
</head>
<body>
	<h1>
		Welcome!
	</h1>


	<div id="wrapper" align="center">
		<div id="searchText">
			<form name="frm" method="get" action="blog_search.do">
			블로그 검색: <input type="text" name="searchWord"  value=""/>
			</form>
		</div>
	</div>

</body>
</html>
