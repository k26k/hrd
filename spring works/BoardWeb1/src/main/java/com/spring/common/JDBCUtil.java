package com.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static String driverClass = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localHost:1521:xe";
	private static String username = "C##JWEB";
	private static String password = "54321";
	
	// DB���� �޼ҵ�
	public static Connection getConnection() {
		try {
			Class.forName(driverClass);
			return DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	// DB���� ���� �޼ҵ�
	public static void close(Connection conn, PreparedStatement pstmt){
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// DB���� ���� �޼ҵ�
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rst){
		if(rst != null) {
			try {
				rst.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}