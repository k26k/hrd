package com.mvc.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.common.JDBCUtil;

public class BoardDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	
	public boolean add() {
		return false;
	}
	public boolean update() {
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
	public boolean getBoard() {
		return false;
	}
}
