package com.yedam.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;
import com.yedam.common.Paging;

public class BulletinListPaging implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page = request.getParameter("page");	// 페이지 번호
		if (page == null) page = "1";

		int pageCnt = Integer.parseInt(page);

		BulletinServiceImpl serv = new BulletinServiceImpl();
		List<BulletinVO> total = serv.bulletinSelectList(); // 전체 카운트
		// 전체 카운트 기준으로 만들기 때문에 필요함.

		serv = new BulletinServiceImpl();
		List<BulletinVO> list = serv.bulletinListPaging(pageCnt); // 페이지에 뿌려 줄 용도

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(total.size());

		request.setAttribute("bulletinList", list);
		request.setAttribute("paging", paging);
		
		return "bulletin/bulletinListPaging.tiles";
	}

}
