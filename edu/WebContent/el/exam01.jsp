<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language(/el/exam01.jsp)</title>
</head>
<body>
	<%
		//String name = "h";	// 밑의 첫 <h3>에 연결됨
		//request.setAttribute("name", name);	// 두 번째 <h3>에 값을 넣어줌.
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	%>
	<!--
	<h3><%=name %></h3>
	<h3>${name == 'h'}</h3>
	-->
	<%=name %>/<%=age %><br>
	${param.name } / ${param.age }
	<!-- 주소창에 name이랑 age값 입력해 보자 -->
</body>
</html>