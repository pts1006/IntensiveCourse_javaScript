<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<tiles:getAsString name = "title" /><!-- tiles.xml 파일과 함께 볼 것. -->
</title>
<!-- 
	/WEB-INF/jsp/layout/template.jsp
	컨트롤을 통해서만 접속할 수 있도록 경로를 WEB-INF의 안으로 지정했음.
 -->
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
    .fakeimg {
      height: 200px;
      background: #aaa;
    }
  </style>
  
</head>

<body>

	<tiles:insertAttribute name = "menu">
	</tiles:insertAttribute>
	
	<hr>
	
	<tiles:insertAttribute name = "body">
	</tiles:insertAttribute>
	
	<hr>
	
	<tiles:insertAttribute name = "foot">
	</tiles:insertAttribute>
	
	
</body>
</html>