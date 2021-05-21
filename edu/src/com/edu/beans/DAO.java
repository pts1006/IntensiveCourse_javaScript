package com.edu.beans;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
	// Data Access Object
	
	public static Connection connect() {

		Connection conn = null;
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			// java:comp/env/ 는 톰캣을 이용하니까 추가로 적어준 것. 이곳에서 정보를 읽어온다.
			try {
				conn = ds.getConnection();
				System.out.println("연결 ㅇㅇ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
