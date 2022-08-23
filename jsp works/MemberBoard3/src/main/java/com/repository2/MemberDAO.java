package com.repository2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.common.JDBCUtil;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rst = null;
	
	public boolean addMember(Member member) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO t_member(memberid, passwd, name, gender) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberID());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	public ArrayList<Member> getAllList() {
		ArrayList<Member> memberList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_member ORDER BY joindate DESC";
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			
			while(rst.next()) {
				Member member = new Member();
				member.setMemberID(rst.getString("memberid"));
				member.setPasswd(rst.getString("passwd"));
				member.setName(rst.getString("name"));
				member.setGender(rst.getString("gender"));
				member.setJoinDate(rst.getDate("joindate"));
				memberList.add(member);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		return memberList;
	}
	
	
	public Member getMember(String memberID) {
		Member member = new Member();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_member WHERE memberid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rst = pstmt.executeQuery();
			
			while(rst.next()) {
				member.setMemberID(rst.getString("memberid"));
				member.setPasswd(rst.getString("passwd"));
				member.setName(rst.getString("name"));
				member.setGender(rst.getString("gender"));
				member.setJoinDate(rst.getDate("joindate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		return member;
	}
	
	
	public boolean updateMember(Member member, String originalID) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE t_member SET memberid = ?, passwd = ?, name = ?, gender = ? WHERE memberid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberID());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, originalID);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		return false;
	}
	
	
	public boolean checkLogin(String memberID, String passwd) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_member WHERE memberid = ? and passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			pstmt.setString(2, passwd);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		return false;
	}
	
	
	public boolean delete(String memberID) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_member WHERE memberid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rst = pstmt.executeQuery();
			if(!rst.next()) {
				return false;
			}
			
			sql = "DELETE t_member WHERE memberid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			pstmt.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		return false;
	}
	
}
