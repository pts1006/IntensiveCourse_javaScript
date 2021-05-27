package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// TODO 전체 품목 불러오기
		
//		String id = request.getParameter("memberId");
//		
//		MemberVO vo = new MemberVO();
//		vo.setId(id);
		
		ProductService serv = new ProductServiceImpl();
		List<ProductVO> list = serv.productSelectList();
		
		//request.setAttribute("id", "user1");	// 로그인을 아직 만들지 않아서 임의의 값을 집어 넣음.
		request.setAttribute("list", list);
		
		return "product/productList.tiles";
	}

}
