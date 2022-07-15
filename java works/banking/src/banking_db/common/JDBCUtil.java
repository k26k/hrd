package banking_db.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DB 연결, 종료
public class JDBCUtil {

	private static String driverClass = "oracle.jdbc.OracleDriver"; 
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "system";
	private static String password = "12345";

//	DB 연결 메소드
	public static Connection getConnection() {
		try {
			Class.forName(driverClass);
			return DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	DB 종료 메서드
	public static void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
//	DB 종료 메서드
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
