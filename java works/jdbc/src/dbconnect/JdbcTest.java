package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	private static String driverclass = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "system";
	private static String password = "12345";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			Class.forName(driverclass);
			System.out.println("오라클 드라이버 로딩");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection 객체 생성 : "+conn);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				System.out.println("Connection 객체 종료");
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
