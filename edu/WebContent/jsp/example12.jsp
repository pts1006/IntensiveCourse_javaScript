<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example12.jsp</title>
</head>
<body>
<h1>Example12.jsp</h1>
<%-- <%@ include file="example05.jsp" %> --%>
<%!
	public void work(String p, PageContext pc) {
		try {
			JspWriter out = pc.getOut();
			if(p.equals("include")) {
				out.print("include 전");
				pc.include("example05.jsp");
			} else if(p.equals("forward")) {
				pc.forward("example05.jsp");
			}
		}catch(Exception e) {
			System.out.println("오류 발생");
		}
	}
%>
<%
	String p = request.getParameter("p");
	this.work(p, pageContext);	// work 는 무슨 method > 넘겨주는 parameter 값이
%>
</body>
</html>