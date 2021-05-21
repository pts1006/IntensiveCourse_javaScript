package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// login 정보를 Cookie에 저장해두고, 다른곳으로 이동 시 Cookie를 사용해서 login을 새롭게 할 필요 없도록 해주는 곳

@WebServlet("/cookie")
public class CookieTestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie c1 = new Cookie("id", "guest");
		c1.setPath("/");	// 서버의 특정 위치 -> / : root 를 지칭(= /edu Application 전체를 뜻함)
		resp.addCookie(c1);	// 클라이언트쪽으로 c1 전송
		
		Cookie c2 = new Cookie("code", "0001");
		c2.setMaxAge(2 * 60);	// 한번 Cookie를 등록해놨을 때, 여기서 지정해둔 시간이 지나면 Cookie는 사라짐. 초단위. 여기선 60초
		c2.setPath("/");
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("subject", "java");
		c3.setMaxAge(10 * 24 * 60 * 60); // 10일. 작성일 21.05.12니까 21.05.22까지.
		c3.setPath("/");
		resp.addCookie(c3);
		
		out.print("쿠키 전송 ㅇ");
		out.close();
	}
	
}
