package com.yedam.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DbCommand;
import com.yedam.product.serviceImpl.ProductServiceImpl;

public class AddCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO add cart 클릭 시 cart table에 회원 아이디, 상품 정보, 수량(=1) 담기.
		
		HttpSession session = request.getSession();
		// HttpSession에 남아 있는 로그인 정보 불러오기.
				
		String id = request.getParameter("id");
		String itemCode = request.getParameter("itemCode");
		int qty = 1;
		
		ProductServiceImpl serv = new ProductServiceImpl();
		serv.addCart(id, itemCode, qty);
		
		ProductServiceImpl service = new ProductServiceImpl();
		int cnt = service.getCountCart(id);
		
		//session.setAttribute("id", id);
		// 값 지정하기.
		session.setAttribute("cnt", cnt);
		
		return "/productList.do";
	}

}
