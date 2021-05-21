<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/exam03.jsp</title>
</head>
<body>
	<h3>JSP Standard Tag Library</h3>
	<c:set var = "num" value = "${80 }"></c:set>
	<c:out value = "${num }"></c:out><br>
	
	<c:if test="${num >= 60 }">합격</c:if><br>
	<c:if test="${num < 60 }">불합격</c:if><br>
	
	<c:choose>
		<c:when test="${num >= 90 }">A</c:when>
		<c:when test="${num >= 80 }">B</c:when>
		<c:when test="${num >= 70 }">C</c:when>
		<c:otherwise>F</c:otherwise>
	</c:choose>
</body>
</html>