package com.edu.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	// 전체리스트, 신규입력, 수정, 삭제 - DBMS

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 한 건 조회
	public BookBean getBook(String title) {

		conn = DAO.connect();

		String sql = "select * from book where title = ?";
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, title);
			rs = psmt.executeQuery();

			if (rs.next()) {
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				System.out.println("조회ㅇㅇ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return book;
	}

	// 전체 조회
	public List<BookBean> getBookList() {

		conn = DAO.connect();

		String sql = "select * from book";

		List<BookBean> bookList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BookBean book = new BookBean();

				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));

				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return bookList;
	}

	// 저자별 출판물 리스트 출력
	public List<BookBean> getBooksByAuthor(BookBean book) {

		String sql = "select * from book where author = ?";

		conn = DAO.connect();

		List<BookBean> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, book.getAuthor());
			rs = psmt.executeQuery();

			while (rs.next()) {
				book = new BookBean();

				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));

				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	// 한 건 입력 BookBean insertBook(BookBean book)
	public int insertBook(BookBean book) {

		int result = 0;

		conn = DAO.connect();

		String sql = "insert into book values (?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());

			result = psmt.executeUpdate();

			if (result != 0) {
				System.out.println(result + "건 입력.");
			} else {
				System.out.println("입력 실패.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 한 건 삭제
	public int deleteBook(BookBean book) {

		int result = 0;

		conn = DAO.connect();

		String sql = "delete from book where book_title = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());

			result = psmt.executeUpdate();

			if (result != 0) {
				System.out.println(result + "건 삭제.");
			} else {
				System.out.println("삭제 실패.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 한 건 수정
	public int modifyBook(BookBean book) {

		int result = 0;

		conn = DAO.connect();

		String sql = "update book set book_author = ?, book_publisher = ? where book_title = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, book.getAuthor());
			psmt.setString(2, book.getPublisher());
			psmt.setString(3, book.getTitle());

			result = psmt.executeUpdate();

			if (result != 0) {
				System.out.println(result + "건 수정.");
			} else {
				System.out.println("수정 실패.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public void close() {

		try {
			if (rs != null) rs.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
