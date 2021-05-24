package com.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DbCommand;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberJoin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("memberId"); 
		String pwd = request.getParameter("memberPwd");
		String name = request.getParameter("memberName");
		String addr = request.getParameter("memberAddress");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pwd);
		vo.setName(name);
		vo.setAddress(addr);
		
		MemberServiceImpl service = new MemberServiceImpl();
		service.insertMember(vo);
		
		// 판별용 등록
		session.setAttribute("id", id);
		session.setAttribute("member", vo);
		
		return "main/main.tiles";
	}

}
