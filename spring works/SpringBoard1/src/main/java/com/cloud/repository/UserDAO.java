package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.cloud.common.JDBCUtil;

@Repository
public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String CHECK_USER = "SELECT * FROM users WHERE bno=? AND passwd=?";
	private final String INSERT_USER = "INSERT INTO users(id, passwd, name, role) VALUES(?, ?, ?, user)";
	private final String UPDATE_USER = "UPDATE users SET id=?, passwd=?, name=?, role=? WHERE id=?";
	private final String DELETE_USER = "DELETE FROM users WHERE id=?";
	
	public boolean checkUser(String id, String passwd) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(CHECK_USER);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return false;
	}
	
	public int addUser(userVO userVO) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT_USER);
			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, userVO.getPasswd());
			pstmt.setString(3, userVO.getName());
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return 0;
	}
	
	public int updateUser(userVO userVO) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_USER);
			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, userVO.getPasswd());
			pstmt.setString(3, userVO.getName());
			pstmt.setString(4, userVO.getRole());
			pstmt.setString(5, userVO.getId());
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return 0;
	}
	
	public int deleteUser(String id) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_USER);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return 0;
	}
	
}
