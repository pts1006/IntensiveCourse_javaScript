<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch.jsp</title>
</head>
<body>
	<H3>회원 정보 검색</H3>
	<FORM action = "memberSearch.do" method = "post">
		아디 : <input type = "text" name = "id"><br>
		<input type = "hidden" name = "job" value = "search">
		<input type = "submit" value = "조회">
	</FORM>
	<a href = "index.jsp">홈으로</a>
</body>
</html>