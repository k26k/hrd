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
				boardList.add(board);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(conn, pstmt, rst);
			
		}
		
		return boardList;
	}
	
	
}
