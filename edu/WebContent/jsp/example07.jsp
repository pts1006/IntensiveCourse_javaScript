<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example07.jsp</title>
<style>
	table {
		border-collapse: collapse;
		text-align: center;
	}
	td {
		width: 20px;
	}
	.Rblock {
		border-right: 3px solid black;
	}
	.Lblock {
		border-left: 3px solid black;
	}
</style>
</head>
<body>
	<h1>스크립트릿(애플릿, 서블릿)으로 구구단 출력</h1>
	<h3>table 활용해서 만들기</h3>
	<%!
		// 멤버변수 선언
		// 메소드 선언
	%>
	<table border="1">
	<%
		for(int i=1; i<10; i++){
	%><tr>
		<%
			for(int j=2; j<10; j++){
				out.print("<td class='Lblock'>" + j + "</td><td>*</td><td>" + i + "</td><td>=</td><td class='Rblock'>" + (i*j) + "</td>");
		%>
		<% } %></tr>
	<% } %></table>
	
</body>
</html>