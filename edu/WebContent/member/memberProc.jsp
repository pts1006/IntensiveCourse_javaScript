<%@page import="com.edu.member.model.MemberService"%>
<%@page import="com.edu.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자 입력 ~> Oracle 저장 ~> 처리결과 (memberOutput.jsp)
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	// 서비스 로직(MemberService.java), DB 처리(MemberDAO.java);
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPasswd(pw);
	member.setName(name);
	member.setMail(mail);
	
	MemberService service = new MemberService();
	service.memberInsert(member);
	
	request.setAttribute("member", member);	// 얘가 필요한가?
	//ㅇㅇ 필요하네 memberOutput.jsp에서 ${member.name }ㅡㅡ 이름 값을 출력하는 기능이 작동하려면 이게 필요함.
	
	// 처리 결과 (memberOutput.jsp)
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
	
%>