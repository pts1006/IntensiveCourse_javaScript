package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String ti = request.getParameter("title");
		String co = request.getParameter("content");
		
		NoticeVO vo = new NoticeVO();
		vo.setTitle(ti);
		vo.setContent(co);
		
		NoticeService serv = new NoticeServiceImpl();
		serv.insertNotice(vo);
		
		request.setAttribute("notice", vo);
		return "noticeListPaging.do";
	}

}
