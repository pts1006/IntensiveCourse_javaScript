package com.yedam.bulletin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;


@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		BulletinVO vo = new BulletinVO();
		vo.setId(Integer.parseInt(id));
		
		BulletinService serv = new BulletinServiceImpl();
		int deleteCnt = serv.deleteBulletin(vo);
		
		request.setAttribute("bulletin", vo);
		response.getWriter().print(deleteCnt);
	}
}
