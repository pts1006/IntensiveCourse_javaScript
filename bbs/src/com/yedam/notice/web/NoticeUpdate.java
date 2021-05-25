package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 파라미터 (id, title, content)를 ServiceImpl을 통해 update 기능 작성
		// 공지사항 리스트로 페이지 호출.
		
		String id = request.getParameter("id");
		String ti = request.getParameter("title");
		String co = request.getParameter("content");
		
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		vo.setTitle(ti);
		vo.setContent(co);
		
		NoticeService serv = new NoticeServiceImpl();
		serv.updateNotice(vo);
		
		request.setAttribute("notice", vo);
		return "noticeList.do";
	}

}
