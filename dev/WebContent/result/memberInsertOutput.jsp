<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberInsertOutput.jsp</title>
</head>
<body>
	<h3>가입 완료</h3>
	<p>${member.name }님 환영함.</p>
	<p>ID : ${member.id }</p>
	<p>Mail : ${member.mail }</p>
	<a href = "index.jsp">홈으로</a>
</body>
</html>