<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logInfo.jsp</title>
</head>
<body>
	<a href = 'logInOut.jsp'>로그인 페이지로</a><br>
	<%
		// POST -> 로그인
		// String 객체 -> equals    ????
		if(request.getMethod().equals("POST")) {
			// db조회 후 가져온 Member 확인 -> 이름, 나이 출력 
			// 						없으면 해당 사용자 없다 출력
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			Member mem = new Member();
			MemberDAO dao = new MemberDAO();
			
			mem.setMemberId(id);
			mem.setMemberPwd(pwd);
			
			mem = dao.checkInfo(id, pwd);
			
			/* 교수님 로그인 처리
				if (mem == null || mem.getMemberId() == null) {
					out.print("사용자 정보 없음");
				} else {
					session.setAttribute("info", mem);
					out.print("이름: " + mem.getMemberName() + "나이: " + mem.getMemberAge());
				}
			*/
			
			// 아래는 내가 만든것
			if(id.equals(mem.getMemberId())){
				session.setAttribute("info", mem);
				out.print("Name : " + mem.getMemberName());
			%><br><%
				out.print("Age : " + mem.getMemberAge());
			%>
			<%
			} else {
				out.print("해당 사용자는 존재x");
			%>
			<%
			}
		// GET -> 로그아웃
		} else {
			session.invalidate();
			out.print("로그아웃 ㅇ");
		}
	%>
</body>
</html>