package dbconnect.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB 연결과 종료
public class JDBCUtil {

	private static String driverclass = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "system";
	private static String password = "12345";
	
	public static Connection getConnection() {
		try {
			Class.forName(driverclass);
			return DriverManager.getConnection(url, username, password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) { // SQL 실행이 있으면
			try {
				pstmt.close(); // SQL 실행 종료
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) { // DB 연결이 있으면
			try {
				conn.close(); // DB 연결 종료
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) { // 반환 객체가 있으면
			try {
				rs.close(); // 연결 종료
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
