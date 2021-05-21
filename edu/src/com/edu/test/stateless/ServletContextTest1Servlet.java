package com.edu.test.stateless;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	server 	<-(요청) client1
		   	->(Return) : 하고나면 연결 끊힘. 연결상태 유지x > 무상태(Stateless) 방식이라 함
 	
 	이러면 연결할 때마다 새로운 것이 나오므로 이전의 값을 저장을 해야함
 	
 	client(/addInfo) -> server -> container(tomcat) 
 	-> instance 생성 -> servlet 객체 생성 -> ServletConfig -> init(sc) -> service()
 															= ServletConfig
 	
 	edu 	<- client1 (/addInfo)
 			-> : application 전체에서 공유. 	Servletcontext(객체)
 			
 			<- client2 (/login) -> list, bucket,
 			-> : session에서 공유				HttpSession(객체)
 			
 			<- client3 (/bucket) -> payment
 			-> : request에서 공유				HttpServletRequest(객체)
 			
 	webProj	-> Servletcontext(객체)
 	userProj-> 
*/

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet {
	ServletContext sc;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		sc = config.getServletContext();	// 지역변수자리니까 아래 doGet에서 못가져옴. 이걸 전역변수로 선언해주기 위해 위에 ServletContext sc;
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sc = this.getServletContext();
		String location = sc.getInitParameter("data1");
		System.out.println(location);
	}
	
}
