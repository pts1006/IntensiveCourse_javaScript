package com.edu.test.stateless;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister")
public class PutMemberServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원 전체 목록 조회.
		// db에서 리스트 가져와서 memberList.jsp 로 전송(forward)
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getMemberList();
		
		RequestDispatcher rd =  req.getRequestDispatcher("memberList.jsp");
		req.setAttribute("memberList", list);
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자가 입력한 parameter 값을 읽어서 각각의 값을 DB에 한 건 insert, 입력한 요청 정보들을 memberResult.jsp 로 전송
		// 읽어올 값 : name=id, name=pwd, name=name
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		//System.out.println("DB에 입력 ㅇ");
		
		Member member = new Member(); // 이거 그냥 MemberVO 임
		
		//한번에 넘기는 방법
		member.setMemberId(id);
		member.setMemberPwd(pwd);
		member.setMemberName(name);
		member.setMemberAge(Integer.parseInt(age));
		
		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
		
		// ServletContext sc = this.getServletContext(); // SerlvetContext RD 객체 호출
		RequestDispatcher rd = req.getRequestDispatcher("memberResult.jsp");
		
		/* 각각 넘기는 방식
		req.setAttribute("id", id);
		req.setAttribute("pwd", pwd);
		req.setAttribute("name", name);	
		*/
		
		req.setAttribute("member", member);
		
		rd.forward(req, resp);
		
	}
}
