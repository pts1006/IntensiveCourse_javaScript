<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example05.jsp</title>
</head>
<body>
	<h1>include 지시자 사용</h1>
	<%=application.getAttribute("welcomeMsg").toString()%>
	<%
		out.print("<h3>" + request.getAttribute("result").toString() + "</h3>");
	%>
	<jsp:include page="copyright.jsp"></jsp:include>
	<%-- <%@ include file="copyright.jsp" %> --%>
</body>
</html>