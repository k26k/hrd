package com.spring.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.common.JDBCUtil;

@Component("boardDAO")
public class BoardDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private final static String SELECT_BOARD_ALL = "SELECT * FROM board ORDER BY bno DESC";
	private final static String INSERT_BOARD = "INSERT INTO board(bno, title, writer, content) VALUES(seq.NEXTVAL, ?, ?, ?)";
	
	public List<BoardVO> getAllList(){
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_BOARD_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return boardList;
	}
	
	
	public int insert(BoardVO boardVO){
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT_BOARD);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getWriter());
			pstmt.setString(3, boardVO.getContent());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return 0;
	}
	
}
