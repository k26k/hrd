package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.JDBCUtil;
import com.vo.Member;

public class MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private MemberDAO(){}
	
	private static class single{
		static MemberDAO dao = new MemberDAO();
		static MemberDAO getDao() {
			return dao;
		}
	}
	
	public static MemberDAO getInstance() {
		return single.getDao();
	}
	
	public Member getMember(String id) {
		Member member = new Member();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * from member WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				member.setMail(rs.getString("mail"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setRegistDay(rs.getString("regist_day"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return member;
	}
	
	
	
}
