<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example11.jsp</title>
</head>
<body>
<h1>Out 객체</h1>
<%
	String name = new String("Hi");
	int total = out.getBufferSize();
	out.print("<h3>Buffer Size : " + total + "</h3>");
	out.print("<h3>" + name + "</h3>");
	out.print("<h3>" + out.getRemaining() + "</h3>");	// 사용하고 남은 버퍼의 크기
%>
	
<h1>Application 객체 : ServletContext</h1>
<h3>서버명 : <%=application.getServerInfo() %></h3>
<h3>서블릿 버전 : <%=application.getMajorVersion() %>.<%=application.getMinorVersion() %></h3>
<%
	Set<String> list = application.getResourcePaths("/");
	Object[] path = list.toArray();
	for(int i=0; i<path.length; i++) {
		out.print(path[i] + "<br>");
	}
	application.setAttribute("welcomeMsg", "Hello");
%>
</body>
</html>