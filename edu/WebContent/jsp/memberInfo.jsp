<%@page import="com.edu.test.stateless.Member"%>
<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/memberInfo.jsp</title>
</head>
<body>
	<jsp:useBean id="dao" class="com.edu.test.stateless.MemberDAO"></jsp:useBean>
	<jsp:useBean id="mem" class = "com.edu.test.stateless.Member"></jsp:useBean>
	<%
		String id = request.getParameter("memberId");
		
		//MemberDAO dao = new MemberDAO();
		mem = dao.getMember(id);
	%>
	<table border = "1">
		<tr>
			<td>아이디</td>
			<td><%=mem.getMemberId() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=mem.getMemberPwd() %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=mem.getMemberName() %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=mem.getMemberAge() %></td>
		</tr>
	</table>
	<a href = "memberList.jsp">리스트 보기</a>
</body>
</html>