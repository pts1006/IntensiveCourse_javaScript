package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdditionalInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Request 정보</title></head>");
		out.print("<body>");
		out.print("<h1>추가정보</h1>");
		out.print("Request Method : " + req.getMethod() + "<br/>");
		out.print("Path Info : " + req.getPathInfo() + "<br/>");
		out.print("Path Translaed : " + req.getPathTranslated() + "<br/>");
		out.print("Query String : " + req.getQueryString() + "<br/>");
		out.print("Content Length : " + req.getContentLength() + "<br/>");
		out.print("Content Type : " + req.getContentType() + "<br/>");
		out.print("</body></html>");
		
		out.close();
		
		/* 요청정보
		헤더 : Get
			name=hong 
				< Query String 값
		몸체 :
		
		헤더 : Post
		몸체 : name=hong&age=12&hobby=reading&desc=%AD%a6% << 영문,숫자,일부특수문자 제외 나머지 문자(ex) 한글) 은 %와 함께 16진수로 전달  
				< Content Length 인가봄?
		*/
	}
	
}
