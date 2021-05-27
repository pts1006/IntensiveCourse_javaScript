package com.yedam.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.product.service.ProductService;
import com.yedam.product.vo.CartVO;
import com.yedam.product.vo.ProductVO;

public class ProductServiceImpl extends DAO implements ProductService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public void close() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ID로 장바구니 조회
	public List<CartVO> showCart(String id) {
		
		sql = "select *\r\n"
				+ "from (select user_id, item_code, sum(item_qty) qty from cart group by user_id, item_code) cart, product p\r\n"
				+ "where cart.item_code = p.item_code\r\n"
				+ "and cart.user_id = ?";
		List<CartVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				CartVO vo = new CartVO();
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setItemName(rs.getString("item_name"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setPrice(rs.getInt("price"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
				vo.setItemCode(rs.getString("item_code"));
				vo.setQty(rs.getInt("qty"));
				
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	// cart 정보 추가하는 메소드
	public void addCart(String id, String item, int qty) {

		sql = "insert into cart values(?, ?, ?)";
		int result = 0;

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, item);
			psmt.setInt(3, qty);

			result = psmt.executeUpdate();

			if (result != 0) {
				System.out.println(result + "건 저장");
			} else {
				System.out.println("저장 ㄴㄴ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 회원별 장바구니 상품 개수
	public int getCountCart(String id) {

		sql = "select count(*) cnt from cart where user_id = ?";
		int cnt = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	@Override
	public List<ProductVO> productSelectList() {
		// TODO 전체 조회

		List<ProductVO> list = new ArrayList<>();
		sql = "select * from product order by 1";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setItemName(rs.getString("item_name"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setPrice(rs.getInt("price"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		// TODO 하나 조회
		return null;
	}

	@Override
	public int insertProduct(ProductVO vo) {
		// TODO 입력
		return 0;
	}

	@Override
	public int updateProduct(ProductVO vo) {
		// TODO 수정
		return 0;
	}

	@Override
	public int deleteProduct(ProductVO vo) {
		// TODO 삭제
		return 0;
	}

}
