package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public MemberDAO() {
//		DataSource ds = DataSource.getInstance();
//		conn = ds.getConnection();
		
		// 위 두 개를 활용하지 않고, Connection Pool을 활용해서 Connection 객체를 불러오겠다.
		try {
			InitialContext ic = new InitialContext(); // 리소스 관리 객체
			javax.sql.DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	public Member checkInfo(String id, String pwd) {
		// id, pwd 조회 -> 한 건가져오기
		String sql = "Select * from member where member_id=? and member_pwd=?";
		Member mem = new Member();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				mem.setMemberName(rs.getString("member_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return mem;
	}
	
	// 한 건 조회
	public Member getMember(String id) {
		// id 조회해서 한 건 가져와서 Member
		String sql = "Select * from member where member_id=?";
		Member mem = new Member();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				mem.setMemberName(rs.getString("member_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return mem;
	}
	
	public List<Member> getMemberList() {
		
		String sql = "select * from member order by 1";
		List<Member> list = new ArrayList<Member>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mem = new Member();
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				mem.setMemberName(rs.getString("member_name"));
				
				list.add(mem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	public void insertMember(Member mem) {
		String sql = "insert into member(member_id, member_name, member_age, member_pwd) values (?,?,?,?)";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemberId());
			psmt.setString(2, mem.getMemberName());
			psmt.setInt(3, mem.getMemberAge());
			psmt.setString(4, mem.getMemberPwd());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력ㅇ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void close() {
		try {
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
