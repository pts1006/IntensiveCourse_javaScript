package com.yedam.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.serviceImpl.MemberServiceImpl;

@WebServlet("/ajaxMemberIdCheck")
public class AjaxMemberIdCheck extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.setCharacterEncoding("UTF-8"); 필요없나 보네
		
		String id = req.getParameter("id");
		
		MemberServiceImpl service = new MemberServiceImpl();
		// 얘는 다른 CRUD랑은 다르게 Override돼 있는 게 아니어서 Impl에서 직접 받아와야 한다.
		
		int cnt = 0;
		
		if(service.idCheck(id)) {
			cnt = 1;
		}
		
		resp.getWriter().print(cnt);
	}
	
}
