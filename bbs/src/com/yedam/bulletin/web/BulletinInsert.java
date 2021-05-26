package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class BulletinInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 입력 값을 DB insert한 뒤 bulletinList/jsp로 이동
		
		String wr = request.getParameter("id");
		String ti = request.getParameter("title");
		String co = request.getParameter("content");
		
		BulletinVO vo = new BulletinVO();
		vo.setContent(co);
		vo.setTitle(ti);
		vo.setWriter(wr);
		
		BulletinService serv = new BulletinServiceImpl();
		int cnt = serv.insertBulletin(vo);
		
		String path = "";
		if (cnt > 0) {
			path = "bulletinList.do";
		} else {
			path = "main.do";
		}
		
		request.setAttribute("bulletin", vo);
		return path;
	}

}
