<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isErrorPage="true" %> <!-- error page(example04.jsp 에서 error 만들 것)가 발생했을 때 이 페이지로 대체한다 -->
<!-- /jsp/example01.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외상황</title>
</head>
<body>
	<h4>다음 에러가 발생</h4>
	에러타입 : <%=exception.getClass().getName() %><br>
	에러내용 : <%=exception.getMessage() %>
</body>
</html>