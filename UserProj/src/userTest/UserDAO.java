package userTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void close() {

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (psmt != null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public List<UserVO> getUserList() {

		conn = DBCon.getConnect();
		List<UserVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from user_temp");
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setUserID(rs.getString("user_id"));
				vo.setName(rs.getString("user_name"));
				vo.setUserPass(rs.getString("user_pass"));
				vo.setPhone(rs.getString("user_phone"));
				vo.setGender(rs.getString("user_gender"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int userInsert(UserVO vo) {

		conn = DBCon.getConnect();
		int result = 0;
		String sql = "insert into user_temp values(?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getUserID());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getUserPass());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getGender());

			result = psmt.executeUpdate();

			if (result != 0) {
				System.out.println(result + "건 입력.");
			} else {
				System.out.println("입력 안 됨.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public int updateUser(UserVO vo) {
		
		conn = DBCon.getConnect();
		
		int cnt = 0;
		
		String sql = "update user_temp "
				+ "set "
				+ "user_name = ?, "
				+ "user_pass = ?, "
				+ "user_phone = ?, "
				+ "user_gender = ? "
				+ "where user_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getUserPass());
			psmt.setString(3, vo.getPhone());
			psmt.setString(4, vo.getGender());
			psmt.setString(5, vo.getUserID());
			
			cnt = psmt.executeUpdate();
			
			System.out.println(cnt + "건 수정");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}
	
}
