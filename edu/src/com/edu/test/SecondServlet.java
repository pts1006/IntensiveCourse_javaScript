package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/secondServlet", "/login/second" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlet() {
		super();
	}
	// init() -> request, response -> service(request, response)

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name+"ㅇㄹ");
		System.out.println(age+"ㄴㅇ");
		
//		Enumeration<String> en = request.getHeaderNames(); // ㅁㄹ 
//		while(en.hasMoreElements()) {
//			String key = en.nextElement();
//			String val = request.getHeader(key);
//			System.out.println(key + ", " + val);
//		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		response.sendRedirect("index.html");
		PrintWriter out = response.getWriter();
//		response.setHeader("name", "hong");
//		ArrayList<String> col = (ArrayList<String>) response.getHeaderNames();
//		for(String key : col) {
//			String val = response.getHeader(key);
//			System.out.println(key + ", 나이");
//		}
//		
		out.print("<h1>"+name+"</h1>");
		out.print("<h1>"+age+"</h1>");
		// http://localhost/edu/secondServlet?name=Hong&age=20 로 들어가면 name, age에 입력이 됨. doGet 방식이라
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
