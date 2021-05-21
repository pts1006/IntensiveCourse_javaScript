package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {
	
	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// logInOut.html 의 name=id , name=pwd 를 parameter 로 지정
		req.getParameter("id");
		req.getParameter("pwd");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// 둘 중 하나라도 값이 없다면 끝
		if(id.isEmpty() || pwd.isEmpty()) {	
			out.print("ID 또는 PASS를 입력하시오");
			return;
		}
		
		HttpSession session = req.getSession();
		// session이 새로 만들어졌거나 id라는 값이 null일 경우에는
		if(session.isNew() || session.getAttribute("id") == null) {
			// id 값이 null 인데 그 자리에 가져온 id 값을 넣는다. session 사용도 높음. 활용도 잘 생각해보기
			session.setAttribute("id", id);
			session.setAttribute("data1", "100");
			out.print("로그인 ㅇ");
		} else {
			// null이 아니란 것을 이미 로그인이 되어있다는 말
			out.print("이미 로그인이 되어있다");
		}
		out.close();
		
	}
	
	// 로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// session의 유무 체크를 위해 false
		HttpSession session = req.getSession(false);
		
		// 위의 req.getSession(false) 에서 null 값 조건 : session 이 없을때
		if(session != null && session.getAttribute("id") != null) {
			session.invalidate(); // session이 있고, id 기록도 있는 상태니까 session 삭제
			out.print("로그아웃 ㅇ");
		} else {
			out.print("로그인 상태가 아니다");
		}
		out.close();
	}

}
