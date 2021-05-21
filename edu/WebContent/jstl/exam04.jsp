<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/exam04.jsp</title>
<!--

그래서 이걸 왜 쓰냐,
자바스크립트 안에서 최대한 자바를 사용하지 않고, 태그 형식으로 하고 싶어서.
즉, 자바스크립트를 자바스크립트답게 써 먹기 위해서.

-->
</head>
<body>
	<%
	List<BookBean> bookList = new ArrayList<>();
	bookList.add(new BookBean("title1", "author1", "publisher1"));
	bookList.add(new BookBean("title2", "author2", "publisher2"));
	bookList.add(new BookBean("title3", "author3", "publisher3"));
	request.setAttribute("list", bookList);
	/* for(BookBean book : bookList){
		// bookList변수에 있는 오브젝트의 개수만큼 반복시키겠다.
		out.print(book.getTitle());
		out.print(book.getAuthor());
		out.print(book.getPublisher());
	} */
	%>

	<h3>forEach 반복문</h3>
	<c:forEach items="${list }" var="book">
		<p>${book.title }/${book.author } / ${book.publisher }</p>
	</c:forEach>

	<c:forEach begin="2" end="9" var="val">
		<c:forEach begin="1" end="9" var="num">
			<p>${val }* ${num } = ${val * num }</p>
		</c:forEach>
	</c:forEach>
</body>
</html>