package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class FirstServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}
	
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service()");
//		res.getWriter().print("<h1>1234141ㄴㄹㅇ2312</h1>");
//	}
	// service 또는 doGet,doPost 둘 중 하나 골라서 실행
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
		// 새로 저장하면 호출
	}
	
	/*
	 구조
	 Servlet > GenericServlet > HttpServlet > FirstServlet
	 
	 순서
	 init > service > destroy
	 이것들이 뭔지 볼려고 적은것이고 실제로는 상위 클래스에 있는 것
	*/
	

}
