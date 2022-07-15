package banking_db.common;

import java.sql.Connection;

public class JDBCTest {

	public static void main(String[] args) {
		
		Connection conn = JDBCUtil.getConnection();
		System.out.println(conn);
		
	}
	
}
