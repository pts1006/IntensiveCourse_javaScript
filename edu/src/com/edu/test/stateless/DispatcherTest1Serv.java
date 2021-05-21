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

/*
	정보유지
	1) application 단위(ServletContext)
	2) Client 단위	  (Cookie, Session)
	3) 요청 단위 -> (HttpRequetstServlet)
		: service(request, response)	client <===> server
		doGet, doPost
		request => dispatcher1, dispatcher2
*/

@WebServlet("/dispatcher1")
public class DispatcherTest1Serv extends HttpServlet{
	
	/* 	
	  	실행 결과 = dispatcher1 이 보이는 것이 아니라 dispatcher2 가 화면에 보임
	 	근데 왜 굳이 1내용을 2에서 보여줌?? > 지금은 이걸 이렇게 쓴다고 보여준거라 억지로 그런 것. 실제로는 이렇게 쓰지 않음
	 	
	 	예시
	 	form : 회원 가입 -> DB에 한 건 입력 서블릿 -> logOut.jsp (jsp = 서블릿과 비슷한 기능. 이게 더 편하다고 함)
	 	 				여기서 배운 것들은 이 과정에 요청 정보를 넘겨줄 때 쓰는 기능이다
	 	 				
	 	위의 예시를 만들어 볼 것
	 	회원가입 memberReg.html -> member 한 건 입력 서블릿 PutMemberServ -> 결과 출력 memberResult.jsp
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String Param = req.getParameter("p");
		
		if(Param == null || Param.isEmpty()) {	// 여기서 Param.isEmpty() 만 달랑 넣으니까 실행되지않았음. null 값인 경우도 집어서 넣어줘야하는 듯
			Param = "Null";
		}
		
		out.print("<h3>Dispatcher 수행 1</h3>");
		
		ServletContext sc =  this.getServletContext();	// edu 객체 관리
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");	// 받아온 정보를 다음 페이지로 정보를 전달
		req.setAttribute("data1", "Good");
		req.setAttribute("data2", Param);
		rd.forward(req, resp);		// 요청 정보와 응답 정보를 그대로 공유해서 forward 로 보내는 듯
		
		
		out.close();
	}
}
