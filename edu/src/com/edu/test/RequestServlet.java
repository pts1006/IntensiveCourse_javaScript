package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String met = req.getMethod();
		//System.out.println(met);
		
		String name = req.getParameter("name");
		String age = req.getParameter("user_age");
		String id = req.getParameter("user_id");
				
		PrintWriter out = resp.getWriter();
		
		if (met.equals("GET")) {	// repeat.html 에서 method 방식의 변경에 따라 달라지게
			out.print("<table border='1'>");
			out.print("<tr><td>이름</td><td>");
			out.print(name + "</td></tr><tr><td>나이</td><td>");
			out.print(age + "</td></tr><tr><td>아이디</td><td>");
			out.print(id + "</td></tr></table>");
		} else {
			out.print("<ul><li>");
			out.print(name + "</li><li>");
			out.print(age + "</li><li>");
			out.print(id + "</li></ul>");
		}
		
		/* 서블릿의 실행
		 * 												netInfo servlet
		client -> server(apache) -> container(tomcat) -> init()
		-> service(request, response) IOC : Inversion Of Control
			: doPost, doGet
		*/
		
	}
	

}
