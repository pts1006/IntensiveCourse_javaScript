<%@page import="com.dev.dao.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate.jsp</title>
</head>
<body>
	<form action = "memberSearch.do" method = "post">
		아디 : <input type = "text" name = "id"><br>
		<input type = "hidden" name = "job" value = "update">
		<input type = "submit" value = "조회">
	</form>
	
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		
		if(member != null){
			%>
				<br>
				<br>
				<form action = "memberUpdate.do" method = "post">
					아디 : <input type = "text" name = "id" readonly value = "<%=member.getId() %>"><br>
					비번 : <input type = "password" name = "pwd" value = "<%=member.getPasswd() %>"><br>
					이름 : <input type = "text" name = "name" value = "<%=member.getName() %>"><br>
					메일 : <input type = "email" name = "mail" value = "<%=member.getMail() %>"><br><br>
					<input type = "submit" value = "수정">
				</form>
			<%	
		} else {
			%>
			<h3>조회할 놈 골라 봐</h3>
			<%
		}
	%>
	<a href = "index.jsp">홈으로</a>
</body>
</html>