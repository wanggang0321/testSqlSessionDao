package com.ppdtbb.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static final String url = "jdbc:mysql://localhost:3306/test0129";
	private static final String username = "root";
	private static final String password = "123456";
	
	private static Connection conn = null;
	
	static {
		
		try {
			//1.加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.获得数据库连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		return conn;
	}
	
}
