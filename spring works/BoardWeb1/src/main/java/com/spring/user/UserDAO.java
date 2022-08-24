package com.spring.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.common.JDBCUtil;

public class UserDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private final static String IDPW_CHECK = "SELECT * FROM users WHERE id=? AND passwd=?";
	
	public boolean login(UserVO user){
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(IDPW_CHECK);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return false;
	}
	
}