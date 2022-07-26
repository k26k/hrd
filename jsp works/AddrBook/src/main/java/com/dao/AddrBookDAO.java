package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.common.JDBCUtil;

public class AddrBookDAO {
	// JDBC 관련 변수 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rst = null;
	
	public void addAddress(AddrBook addrBook) {
		try{
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO t_address(num, username, tel, email, gender)"
					+ "VALUES (ab_seq.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addrBook.getUsername());
			pstmt.setString(2, addrBook.getTel());
			pstmt.setString(3, addrBook.getEmail());
			pstmt.setString(4, addrBook.getGender());
			// joinDate는 DB설정에 따라 자동으로 추가됨 
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	
	public ArrayList<AddrBook> getAllList(){
		try{
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_address";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			rst = pstmt.getResultSet();
			
			ArrayList<AddrBook> addrList = new ArrayList<>();
			while(rst.next()) {			
				AddrBook addrBook = new AddrBook();
				addrBook.setNum(rst.getInt("num"));
				addrBook.setUsername(rst.getString("username"));
				addrBook.setTel(rst.getString("tel"));
				addrBook.setEmail(rst.getString("email"));
				addrBook.setGender(rst.getString("gender"));
				addrBook.setJoinDate(rst.getDate("joinDate"));
				
				addrList.add(addrBook);
			}
			
			return addrList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		
		return null;
	}
	
	
	public AddrBook getAddress(int num){
		try{
			//System.out.println("AddrBookDAO_START");
			
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_address WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			rst = pstmt.getResultSet();
			
			if(!rst.next()) {
				System.out.println("AddrBookDAO_getAddress_rst_null");
				return null;
			}
				
			AddrBook addrBook = new AddrBook();
			addrBook.setNum(rst.getInt("num"));
			addrBook.setUsername(rst.getString("username"));
			addrBook.setTel(rst.getString("tel"));
			addrBook.setEmail(rst.getString("email"));
			addrBook.setGender(rst.getString("gender"));
			addrBook.setJoinDate(rst.getDate("joinDate"));
			
			return addrBook;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		
		return null;
	}
	
	
	public boolean checkLogin(String email) {
		try{
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_address WHERE email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.executeUpdate();
			rst = pstmt.getResultSet();
			
			if(!rst.next()) {
				return false;
			}
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		
		return false;
	}
	
	public boolean delete(int num) {
		try{
			conn = JDBCUtil.getConnection();
			String sql = "DELETE t_address WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		
		return false;
	}
	
}
