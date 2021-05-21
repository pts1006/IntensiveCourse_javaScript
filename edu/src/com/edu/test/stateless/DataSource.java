package com.edu.test.stateless;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {	// 싱글턴 클래스 - DAO의 관례적 명칭 datasource << 이걸로 쓰기
	private static DataSource dataSource = new DataSource();	// 자기자신
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {}
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		dbConfig(); //환겨파일을 불러 db 정보ㅡㄹ 담는다
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void dbConfig() {	//환경파일을 불러오는 메소드
		String resource = getClass().getResource("db.properties").getPath();
//		System.out.println(resource);	//실제 물리적 패스를 출력해본다.
		Properties properties = new Properties();	//properties 객체 생성
		
		try {
			properties.load(new FileReader(resource));	//환경파일을 Reader 객체를 통해 읽음
			driver = properties.getProperty("driver");	//변수에 환경파일의 값을 적용
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
