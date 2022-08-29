package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.common.JDBCUtil;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rst = null;
	
	public ArrayList<Board> getAllList(){
		ArrayList<Board> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_board ORDER BY regdate DESC";
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			
			while(rst.next()) {
				Board board = new Board();
				board.setbNum(rst.getInt("bnum"));
				board.setTitle(rst.getString("title"));
				board.setContent(rst.getString("content"));
				board.setRegDate(rst.getDate("regdate"));
				board.setMemberID(rst.getString("memberid"));
				board.setRecommend(rst.getInt("recommend"));
				board.setViews(rst.getInt("views"));
				boardList.add(board);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		
		return boardList;
	}
	
	public Board getBoard(int bNum){
		Board board = new Board();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_board where bnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rst = pstmt.executeQuery();
			
			if(rst.next()) {
				board.setbNum(rst.getInt("bnum"));
				board.setTitle(rst.getString("title"));
				board.setContent(rst.getString("content"));
				board.setRegDate(rst.getDate("regdate"));
				board.setMemberID(rst.getString("memberid"));
				board.setRecommend(rst.getInt("recommend"));
				board.setViews(rst.getInt("views"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		
		return board;
	}
	
	
	public boolean addBoard(String memberID, Board board){
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO t_board(bnum, title, content, memberid, recommend, views) VALUES(b_seq.NEXTVAL, ?, ?, ?, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, memberID);
			pstmt.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt);
			
		}
		
		return false;
	}
	
	
	public boolean delete(int bNum) {
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM t_board WHERE bnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rst = pstmt.executeQuery();
			if(!rst.next()) {
				return false;
			}
			
			sql = "DELETE t_board WHERE bnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			pstmt.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt,rst);
			
		}
		
		return false;
	}
	
	
	public boolean update(Board board) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE t_board SET title = ?, content = ? WHERE bnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getbNum());
			pstmt.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt);
			
		}
		
		return false;
	}
	
	
	public boolean viewsUp(int bNum) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT views FROM t_board WHERE bnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				sql = "UPDATE t_board SET views = ? WHERE bnum = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rst.getInt("views")+1);
				pstmt.setInt(2, bNum);
				pstmt.executeUpdate();
			return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		return false;
	}
	
	
	public boolean recommendUp(int bNum) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT recommend FROM t_board WHERE bnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				sql = "UPDATE t_board SET recommend = ? WHERE bnum = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rst.getInt("recommend")+1);
				pstmt.setInt(2, bNum);
				pstmt.executeUpdate();
			return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		return false;
	}
	
}