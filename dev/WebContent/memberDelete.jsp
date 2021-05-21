<%@page import="com.dev.dao.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
</head>
<body>
	<FORM action = "memberSearch.do" method = "post">
		아디 : <input type = "text" name = "id"><br>
		<input type = "hidden" name = "job" value = "delete">
		<input type = "submit" value = "조회">
	</FORM>
	
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if(member != null){
			%>
				<br>
				<p>아디 : <%=member.getId() %> / 이름 : <%=member.getName() %> / 메일 : <%=member.getMail() %>
				<form action="memberDelete.do" method = "post">
					<input type = "hidden" name = "id" value = "<%=member.getId() %>"><br>
					<input type = "submit" value = "삭제">
				</form>
			<%
		} else {
			%>
				<h3>삭제할 놈 찾아 봐</h3>
			<%
		}
	%>
	<a href = "index.jsp">홈으로</a>
</body>
</html>