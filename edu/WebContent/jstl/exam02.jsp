<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/exam02.jsp</title>
<!--
	jstl에서의 조건문.
-->
</head>
<body>
	<c:set var = "num" value = "${85 }" />
	<!-- 해당 밸류 값을 변경해 보자. -->
	
	점수 <c:out value = "${num }" />는
	<c:if test = "${num gt 60 }">합격</c:if>
	<c:if test = "${num lt 60 }">불합격</c:if>
	<!-- "c:if" 태그는 하나로 묶어표현하는 게 안 되나 봄. 그냥 출력해 버리네. -->
	<br>
	<c:choose >
		<c:when test = "${num ge 90 }">A학점</c:when>
		<c:when test = "${num ge 80 }">B학점</c:when>
		<c:when test = "${num ge 70 }">C학점</c:when>
		<c:otherwise>F학점</c:otherwise>
	</c:choose>
	
	<%
		ArrayList<BookBean> blist = new ArrayList<>();
		// BookBean에서 생성자와, 매개 값을 담는 메소드를 만들었다.
		blist.add(new BookBean("title1", "aithor1", "publ1"));
		blist.add(new BookBean("title2", "aithor2", "publ2"));
		blist.add(new BookBean("title3", "aithor3", "publ3"));
		
		/*
		
		for(BookBean book : list){
			out.print("title" + book.getTitle());
		}
		
		해당 반복문을 밑의 jstl을 이용해 출력해 본다.
		*/
		request.setAttribute("list", blist);
	%>
	<br>
	<c:forEach items = "${list }" var = "item">
		${item.title } / ${item.author } / ${item.publisher }<br>
		<!-- 해당 값이 일반 반복문이니까 마지막에 "br"태그 넣어 주면 하나씩 띄워 줌 -->
	</c:forEach>
</body>
</html>