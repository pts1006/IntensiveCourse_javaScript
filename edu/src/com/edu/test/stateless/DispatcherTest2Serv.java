package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher2")
public class DispatcherTest2Serv extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String str = (String) req.getAttribute("data1");	// 이걸로 나중에 로그인 정보 가져오는건가?? dispatcher1 에서 set 한거를 가져온거니?
		String par = (String) req.getAttribute("data2");
		
		out.print("<h3>Dispatcher 수행 2</h3>");
		out.print("<h3>응답 결과 : " + str + "</h3>");
		out.print("<h3>응답 결과2 : " + par + "</h3>");
		
		out.close();
	}
}
