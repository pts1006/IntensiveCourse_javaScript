<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/example10.jsp</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	String rid = null;
	String name = null;
	int age = 0;
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if(id == null) {
		id = (String) session.getAttribute("id");
	}
	
	if(pwd == null) {
		pwd = (String) session.getAttribute("pwd");
	}
		
	
	if(id.isEmpty() || pwd.isEmpty()){
		request.setAttribute("err", "ID, PASS 입력하시오");
		RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
		rd.forward(request, response);
		return;
	}
	
	// 로그인 처리
	if(session.isNew() || session.getAttribute("id") == null){
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
		session.setAttribute("name", "가나다");
		session.setAttribute("age", 15);
		out.print("로그인 ㅇ");
	} else {
		out.print("이미 로그인 중");
		rid = (String) session.getAttribute("id");
		name = (String) session.getAttribute("name");
		age = (int) session.getAttribute("age");
	}
	
	%>
	<h3>접속 중 ID = <%=rid %></h3>
	<h3>ID = <%=id %></h3>
	<h3>PASS = <%=pwd %></h3>
	<h3>Welcome : <%=name %>, <%=age %></h3>
</body>
</html>