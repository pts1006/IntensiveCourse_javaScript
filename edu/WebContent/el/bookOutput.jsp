<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/el/bookOutput.jsp</title>
</head>
<body>
	<%
		BookBean book = (BookBean) request.getAttribute("info");
	%>
	<h1>정상 처리</h1>
	<p> 책 제목 : ${info.title }</p><h3><%=book.getTitle() %></h3>
	<p> 책 저자 : ${info.author }</p><h3><%=book.getAuthor() %></h3>
	<p> 출판사 : ${info.publisher }</p><h3><%=book.getPublisher() %></h3>
	<p>toString : ${info }</p>
</body>
</html>