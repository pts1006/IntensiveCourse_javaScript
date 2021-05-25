package com.yedam.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {

	PreparedStatement psmt;
	ResultSet rs;
	
	public void close() {
		
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ID와 Password를 체크해 주는 메소드
	public MemberVO loginCheck(MemberVO vo) {
		
		String sql = "select * from member where id = ? and passwd = ?";
		MemberVO rvo = null;
		
		// Public boolean으로 할 수도 있음.
//		boolean exist = false;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
//				exist = true;
				rvo = new MemberVO();
				rvo.setId(rs.getString("id"));
				rvo.setPasswd(rs.getString("passwd"));
				rvo.setName(rs.getString("name"));
				rvo.setAddress(rs.getString("address"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return rvo;
//		return exist;
	}
	
	// ID 중복 여부 체크 메소드
	public boolean idCheck(String id) {

		boolean exist = false;
		// 중복 존재하면 true, 아니면 false.
		
		String sql = "select id from member where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				exist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}
	
	// 전체 리스트
	@Override
	public List<MemberVO> selectMemberList() {
		return null;
	}

	// 한 건
	@Override
	public MemberVO selectMember() {
		return null;
	}

	// 추가
	@Override
	public int insertMember(MemberVO vo) {
		
		String sql = "insert into member(id, name, passwd, address) values(?, ?, ?, ?)";
		
		int result = 0;
		
		try {
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPasswd());
			psmt.setString(4, vo.getAddress());
			
			result = psmt.executeUpdate();
			
			System.out.println(result + "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	// 수정
	@Override
	public int updateMember(MemberVO vo) {
		
		String sql = "update member set passwd = ?, name = ?, address = ? where id = ?";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	// 삭제
	@Override
	public int deleteMember(MemberVO vo) {
		
		String sql = "delete from member where id = ?";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	
}
