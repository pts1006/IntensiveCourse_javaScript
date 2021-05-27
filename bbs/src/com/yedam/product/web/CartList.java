package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.CartVO;

public class CartList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		
		ProductServiceImpl serv = new ProductServiceImpl();
		List<CartVO> list = serv.showCart(id);
		
		request.setAttribute("list", list);
		
		return "product/cartList.tiles";
	}

}
