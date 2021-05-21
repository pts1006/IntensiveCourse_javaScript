<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/exam01.jsp</title>
<!-- 
	jstl 기본 사용 방법 및 출력 결과.
-->
</head>
<body>
	<!--
	< %
		String name = "Hon";
	%>
	이 방법 안 쓰려고 3 번째 줄에 있는 방식으로 라이브러리를 불러온다.
	
	라이브러리를 불러왔으면 아래처럼 쓴다.
	
	jstl = jsp standard Tag library
	jsp = javaServerPage
	-->
	
	<%
		BookBean book = new BookBean();
		book.setAuthor("길동");
		book.setPublisher("홍출");
		book.setTitle("의적");
		
		request.setAttribute("Hong", book);
		// Hong이라는 애한테 book이라는 값을 넣는다.
		
	%>
	<c:set var="name" value="123"></c:set>
	<c:out value="${name }"></c:out> <!-- 위 set에서 지정한 name을 불러오겠다. -->
	<p>${name eq 123 }</p>
	<c:remove var="name" />
	
	<c:set var = "title" value = "${Hong.title }"/>
	<c:out value = "${title } " />	<!-- value가 있는 것들은 반드시 따옴표로 묶어 주어야 한다. ( 안 그러면 에러 터진다. ) -->
	<p>${Hong }</p>	<!-- 반면 얘는 따옴표로 묶으면 불러오는 값을 따옴표 안으로 집어넣어 준다. -->
	
	<c:set var = "author" />${Hong.author }
	<c:out value = "${author }"/>
	
	<c:set var = "pub" /><%=book.getPublisher() %>
	<c:out value = "${pub }" />
	
</body>
</html>