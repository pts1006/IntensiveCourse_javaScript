package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	전체 어플리케이션의 컨트롤러를 등록하고 관리하는 목적으로 생성한 파일
	"*.do", "*.action"
*/
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HashMap<String, Controller> list;
	String charset = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		charset = config.getInitParameter("charset");
		
		// front 요청 시 제일 처음 한 번만 실행됨.
		// HashMap<키 값, 밸류>
		list = new HashMap<>();

		// list.put("/요청페이지.do", "컨트롤러");
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원 정보 생성하는 기능

		req.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI();	// /dev/insertMember.do
		String contextPath = req.getContextPath();	// /dev/insertMember.do
		String path = uri.substring(contextPath.length());
		System.out.println(path);

		Controller sub = list.get(path); // controller
		sub.execute(req, resp);
	}

}
