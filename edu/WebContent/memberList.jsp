<%@page import="java.util.List"%>
<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
<style>
	table {
		border-collapse: collapse;
		text-align: center;
	}
	th {
		border-bottom : 2px solid black;
	}
</style>
</head>
<body>
	<table border="1">
	<%
	List<Member> list = (List<Member>) request.getAttribute("memberList");
	out.print("<tr><th>ID</th><th>이름</th><th>나이</th></tr>");
	for(Member mem : list) {
		out.print("<tr><td>" + mem.getMemberId() + "</td><td>" + mem.getMemberName() + "</td><td>" + mem.getMemberAge() + "</td></tr>");
	}
	%>
	</table>
</body>
</html>