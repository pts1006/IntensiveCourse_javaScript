package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String param = req.getParameter("p");
		String msg = null;

		HttpSession session = null; // 383783343423 같은 session 값. session이 없으면 새로운 session 생성해줌
		// req.getSession(false) > false = 있으면 session 값 return, 없으면 새로운것 생성이 아닌 null 반환
		// req.getSession(true) > true = 있으면 session 값 return, 없으면 새로운 session 생성해줌

		if (param.equals("create")) {

			session = req.getSession();

			if (session.isNew()) {
				msg = "새로운 세선 객체 생성";
			} else {
				msg = "기존 세션 객체 리턴";
			}
		} else if(param.equals("delete")) {
			session = req.getSession(false);	// session 정보가 있으면 session 값, 없으면 null 값 return
			if(session != null) {
				session.invalidate(); // invalidate : 존재하는 session 삭제해주는 것
				msg = "세션 객체 삭제ㅇ";
			} else {
				msg = "삭제할 세션 존재x";
			}
		}
		
		out.print("<h2>" + msg + "</h2>");
		out.close();
	}

}
