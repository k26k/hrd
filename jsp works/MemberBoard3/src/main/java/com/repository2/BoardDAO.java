package com.repository2;

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
				board.setHit(rst.getInt("hit"));
				boardList.add(board);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		
		return boardList;
	}
	
	
	public int getBoardListSize(){ // 게시글 총 개수
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT COUNT(*) as total FROM t_board";
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				return rst.getInt("total");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		
		return 0;
	}
	
	
	public ArrayList<Board> getBoardListPage(int startPage, int pageSize ){
		ArrayList<Board> boardList = new ArrayList<>();
		int startRow = (startPage-1)*pageSize+1;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_board ORDER BY regdate DESC LIMIT ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rst = pstmt.executeQuery();
			
			while(rst.next()) {
				Board board = new Board();
				board.setbNum(rst.getInt("bnum"));
				board.setTitle(rst.getString("title"));
				board.setContent(rst.getString("content"));
				board.setRegDate(rst.getDate("regdate"));
				board.setMemberID(rst.getString("memberid"));
				board.setHit(rst.getInt("hit"));
				boardList.add(board);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		
		return boardList;
	}
	
	
	public ArrayList<Board> getRecentList(){
		ArrayList<Board> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM t_board ORDER BY bnum DESC LIMIT 5";
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			
			while(rst.next()) {
				Board board = new Board();
				board.setbNum(rst.getInt("bnum"));
				board.setTitle(rst.getString("title"));
				board.setContent(rst.getString("content"));
				board.setRegDate(rst.getDate("regdate"));
				board.setMemberID(rst.getString("memberid"));
				board.setHit(rst.getInt("hit"));
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
			String sql = "INSERT INTO t_board(title, content, memberid) VALUES(?, ?, ?)";
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
	
	
	public boolean hitUp(int bNum) {
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "SELECT hit FROM t_board WHERE bnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				sql = "UPDATE t_board SET hit = ? WHERE bnum = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rst.getInt("hit")+1);
				pstmt.setInt(2, bNum);
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
