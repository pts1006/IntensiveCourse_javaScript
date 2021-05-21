<%@page import="com.dev.dao.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberUpdateOutput.jsp</title>
</head>
<body>
	<h3>수정 결과</h3>
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
	%>
	<p><%=member.getId() %> / <%=member.getName() %> / <%=member.getMail() %>
	
	<br>
	<br>
	<br>
	<p>${member.id } / ${member.name } / ${member.mail }</p>	
	<a href = "index.jsp">첫 페이지</a>
</body>
</html>