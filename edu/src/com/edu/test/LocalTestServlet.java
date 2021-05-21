package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
private class Member {
	private String name; // 멤버변수 (instance멤버)
	private static int age; // 클래스변수 (static멤버)

	public void setName(String name) {
		int accNo;
	}
}
*/

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{
	
	int number = 0;	/* 
					여기는 전역변수 자리
					int number = 0 을 doGet 안에 넣냐 안넣냐의 차이가 매우 큼.
					서로 다른 2개의 창에서 실행시켰을 때,
					밖에 있으면 10까지 과정을 공유해서 진행하게 되고
					안에 있으면 각각 따로따로 10까지 과정을 진행한다	
					*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		int number = 0;
					여기는 지역변수 자리
		*/
		
		String str = req.getParameter("msg");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Thread Test</title></head>");
		out.print("<body><h2>처리결과(지역변수)</h2>");
		while(number++ < 10) {
			out.print(str + " : " + number + "<br>");
			out.flush(); // flush : stream 에 있는 내용들을 꽉채우지 않더라도 바로바로 출력하겠다는 것
			System.out.println(str + " : " + number);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h2>Done: " + str + "</h2>");
		out.print("</body></html>");
		out.close();
	}
}
