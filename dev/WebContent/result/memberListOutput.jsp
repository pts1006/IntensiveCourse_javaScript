<%@page import="com.dev.dao.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberListOutput.jsp</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty list }">
			<h1>없다</h1>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${list }" var="member">
					<li>${member.id }-${member.name }</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<a href = "index.jsp">홈으로</a>


	<%-- 
	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");

	if (list.size() == 0) {
		%>
		<h1>없다</h1>
		<%
	} else {
		
		out.print("<ul>");
		for (MemberVO member : list) {
			out.print("<li></li>");
		}
		out.print("</ul>");
	}
	%>
--%>
</body>
</html>