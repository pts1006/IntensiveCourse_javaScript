package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerInfo")
public class HeaderInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Request 정보 출력</title></head>");
		out.print("<body>");
		out.print("<h1>요청 헤더 정보</h1>");
		
		Enumeration<String> en = req.getHeaderNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement(); // request 정보의 head
			String val = req.getHeader(key);
			out.print(key + " : " + val + "<br/>");
		}
		
		out.print("</body></html>");
		out.close();
		
	}
	
}
