<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example17.jsp</title>
</head>
<body>
	<%
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");
		String name = request.getParameter("memberName");
		String age = request.getParameter("memberAge");
		
		Member member1 = new Member();
		
		member1.setMemberId(id);
		member1.setMemberName(name);
		member1.setMemberAge(Integer.parseInt(age));
		member1.setMemberPwd(pwd);
		
		out.print(member1.getMemberId() + "<br>");
		out.print(member1.getMemberPwd() + "<br>");
		out.print(member1.getMemberName() + "<br>");
		out.print(member1.getMemberAge() + "<br>");
		
	%>
	
	<!-- 위와 달리 태그로 기능을 구현하고자 함. -->
	
	<jsp:useBean id="member2" class = "com.edu.test.stateless.Member"></jsp:useBean>
	
	<!--
	
	받아오는 건 전부 *(아스타)로 대체할 수 있다.
	단, Member.jave에서 선언한 변수명과 똑같은 변수명을 example18.jsp에서 써야 한다.
	
	<jsp:setProperty property="memberId" name="member2" value = "10"/>
	<jsp:setProperty property="memberPwd" name="member2" value = "1234"/>
	<jsp:setProperty property="memberName" name="member2" value = "Hong"/>
	<jsp:setProperty property="memberAge" name="member2" value = "20"/>
	
	반면 출력하는 건 아래와 같이 일일이 다 적어 줘야 한다.
	
	-->
	
	<jsp:setProperty property="*" name="member2"/>
	<!-- 주석 처리했는데도 위에 값 읽어 버려서 밑으로 옮김. -->
	<br>
	<jsp:getProperty property="memberId" name="member2" /><br>
	<jsp:getProperty property="memberPwd" name="member2" /><br>
	<jsp:getProperty property="memberName" name="member2" /><br>
	<jsp:getProperty property="memberAge" name="member2" /><br>

</body>
</html>