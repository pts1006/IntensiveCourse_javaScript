package com.yedam.notice.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.common.Paging;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeListPaging implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page = request.getParameter("page");	// 페이지 번호
		if (page == null) page = "1";

		int pageCnt = Integer.parseInt(page);

		NoticeServiceImpl serv = new NoticeServiceImpl();
		List<NoticeVO> total = serv.noticeSelectList(); // 전체 카운트
		// 전체 카운트 기준으로 만들기 때문에 필요함.

		serv = new NoticeServiceImpl();
		List<NoticeVO> list = serv.noticeListPaging(pageCnt); // 페이지에 뿌려 줄 용도

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(total.size());

		request.setAttribute("noticeList", list);
		request.setAttribute("paging", paging);
		
		return "notice/noticeListPaging.tiles";
	}

}
