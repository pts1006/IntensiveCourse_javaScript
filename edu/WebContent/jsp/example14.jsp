<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example14.jsp</title>
</head>
<body>
	<!-- example11.jsp를 먼저 실행하고 해당 페이지를 실행해야 제대로 값을 받아올 수 있다. -->
	<h3>Example14 page</h3>
	<%
		String res = (String) application.getAttribute("welcomeMsg");
		request.setAttribute("result", res);
	%>

	<jsp:forward page="example05.jsp"></jsp:forward>
	<!-- 이건 밑에 내용을 간략하게 한 것 -->
	<%--
		RequestDispatcher rd = request.getRequestDispatcher("example12.jsp");
		rd.forward(request, response);
	--%>
</body>
</html>