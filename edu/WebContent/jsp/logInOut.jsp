<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/logInOut.jsp</title>
<style>
	table {
		border-collapse: collapse;
	}
	.logIn {
		text-align: right;	
	}
</style>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("err");
		if(msg == null) {
			msg = "";
		};
	%>
	<%=msg %>
	<%
		// info 값이 없다면 로그인창 띄우기
		if(session.getAttribute("info") == null){	
			
		%>
		<form action="logInfo.jsp" method="POST">
			<table border="1">
				<tr>
					<td>ID  </td><td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>PASS  </td><td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" class="logIn"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form><br>
		<%
		// info 값이 있다면 로그아웃 링크 띄우기
		} else {
		%>
		<a href="logInfo.jsp">로그아웃</a>
		<%
		}
	%>
</body>
</html>