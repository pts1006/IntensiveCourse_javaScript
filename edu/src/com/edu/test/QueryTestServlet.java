package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String relegion = req.getParameter("relegion");
		String introduction = req.getParameter("introduction");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열</title></head>");
		out.print("<body><h1>Get 방식 요청</h1>");
		out.print("<h3>아이디 : " + id + "</h3>");
		out.print("<h3>비밀번호 : " + pwd + "</h3>");
		out.print("<h3>이름 : " + name + "</h3>");
		for(String hob : hobby) {
			out.print("<h3>취미 : " + hob + "</h3>");
		}
		out.print("<h3>성별 : " + gender + "</h3>");
		out.print("<h3>종교 : " + relegion + "</h3>");
		out.print("<h3>자기소개 : " + introduction + "</h3>");
		out.print("<h3>QueryString : " + req.getQueryString() + "</h3>");
		out.print("</body><html>");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
//		String id = req.getParameter("id");
//		String pwd = req.getParameter("pwd");
//		String name = req.getParameter("name");
//		String[] hobby = req.getParameterValues("hobby");
//		String gender = req.getParameter("gender");
//		String relegion = req.getParameter("relegion");
//		String introduction = req.getParameter("introduction");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열</title></head>");
		out.print("<body><h1>Post 방식 요청</h1>");
//		out.print("<h3>아이디 : " + id + "</h3>");
//		out.print("<h3>비밀번호 : " + pwd + "</h3>");
//		out.print("<h3>이름 : " + name + "</h3>");
//		for(String hob : hobby) {
//			out.print("<h3>취미 : " + hob + "</h3>");
//		}
//		out.print("<h3>성별 : " + gender + "</h3>");
//		out.print("<h3>종교 : " + relegion + "</h3>");
//		out.print("<h3>자기소개 : " + introduction + "</h3>");
		
		ServletInputStream input = req.getInputStream();
		int len = req.getContentLength();
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len); // 쓰는곳, 0부터, len까지
		String str = new String(buf);
		out.print("<h3>ContentLength : " + str + "</h3>");
		// 이게 웃긴게 getParameter 로 가져와서 출력하고나면 InputStream 에 갈 정보가 남아있지 않아서 이거는 출력이 안됨.
		// 그래서 getParameter 나 INputStream 둘 중 하나밖에 못봄. 위에 주석처리한 이유도 이러한 이유로 인해서 해둠. 보고싶은 것의 반대 것을 주석처리 ㄱㄱ
		
		// out.print("<h3>QueryString : " + req.getQueryString() + "</h3>");  << QueryString 은 GET 방식에서 값 가져오는 것이라 여기서는 쓸모 없다
		
		out.print("</body><html>");
		out.close();
	}
	
}
