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
	
	${pageContext.request.contextPath } === 최상위 폴더를 지칭
 -->
 
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/bootstrap/js/scripts.js"></script>
  
  <!-- 별 나오게 -->
  <!-- Bootstrap icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  
  <!-- 스크립트 기능 -->
  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
  
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
	
	<tiles:insertAttribute name = "head">
	</tiles:insertAttribute>
	
	<hr>
	
	<tiles:insertAttribute name = "body">
	</tiles:insertAttribute>
	
	<hr>
	
	<tiles:insertAttribute name = "foot">
	</tiles:insertAttribute>
	
	
</body>
</html>