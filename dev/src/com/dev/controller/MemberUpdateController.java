package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.service.MemberService;
import com.dev.dao.vo.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String ps = request.getParameter("pwd");
		String na = request.getParameter("name");
		String em = request.getParameter("mail");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setMail(em);
		member.setName(na);
		member.setPasswd(ps);
		
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("result/memberUpdateOutput.jsp");
		rd.forward(request, response);
	}

}
