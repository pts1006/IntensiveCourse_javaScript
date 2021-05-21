package com.edu.test.stateless;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//공유하는 Servlet 만드는 곳. app 전체에서 공유. 여기서는 불러옴

@WebServlet("/context3")
public class ServletContextTest3Servl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletContext -> 값을 읽어오도록. obj1, obj2
		
		ServletContext sc = this.getServletContext();
		ShareObject so1 = (ShareObject) sc.getAttribute("data1");
		ShareObject so2 = (ShareObject) sc.getAttribute("data2");
		System.out.println(so1.getCount() + ", " + so1.getStr());
		System.out.println(so2.getCount() + ", " + so2.getStr());
		// ServletContextTest2Servl 를 먼저 실행하지않고 여기부터 하면 저장된 값이 없어서 아무것도 나오지 않음.
	}
}
