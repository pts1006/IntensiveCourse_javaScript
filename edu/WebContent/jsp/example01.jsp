<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/example01.jsp</title>
</head>
<body>
	<%!	// <%! -> ! 를 쓰면 field(멤버변수) 작성하는 곳
		String name ; // 필드(멤버변수)
		//메소드 정의
		public int sum(int a, int b) {
			return a+ b;
		}
	%>
	<%
		//	주석1
		/* 
			주석2
		*/
		String user = request.getParameter("name"); // requset - 내장 객체
		if (user == null){
			user = "Guest";
		}
		int result = sum(11, 20);
	%>
	<h1>Hi <%=user %></h1>
	<h2>result : <%=result %></h2>
	<!-- HTML 주석 -->
</body>
</html>