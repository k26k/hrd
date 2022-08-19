package com.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.common.JDBCUtil;
import com.vo.Board;

public class BoardDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	
	private static BoardDAO instance;
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	public boolean add(Board board) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO board VALUES(default, ?, ?, ?, ?, 0, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getwriteDate());
			pstmt.setString(5, board.getId());
			pstmt.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	
	public boolean update(Board board) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE board SET subject=?, content=?  WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNum());
			pstmt.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	
	public ArrayList<Board> getAllList() {
		ArrayList<Board> boardsList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * from Board";
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				Board board = new Board();
				board.setNum(rst.getInt("num"));
				board.setName(rst.getString("name"));
				board.setSubject(rst.getString("subject"));
				board.setContent(rst.getString("content"));
				board.setwriteDate(rst.getString("write_date"));
				board.setHit(rst.getInt("hit"));
				board.setRecommend(rst.getInt("recommend"));
				board.setId(rst.getString("id"));
				boardsList.add(board);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		
		return boardsList;
	}
	
	
	public Board getBoard(int num) {
		Board board = new Board();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				board.setNum(rst.getInt("num"));
				board.setName(rst.getString("name"));
				board.setSubject(rst.getString("subject"));
				board.setContent(rst.getString("content"));
				board.setwriteDate(rst.getString("write_date"));
				board.setHit(rst.getInt("hit"));
				board.setRecommend(rst.getInt("recommend"));
				board.setId(rst.getString("id"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		
		return board;
	}
	
	
	public boolean delete(int num) {
		Board board = new Board();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "DELETE FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	
	public boolean viewUp(int num) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT hit FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				int hit = rst.getInt("hit")+1;
				sql = "UPDATE board SET hit=? WHERE num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, hit);
				pstmt.setInt(2, num);
				pstmt.executeUpdate();
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
		}
		
		return false;
	}
}
