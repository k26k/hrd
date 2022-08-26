package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.cloud.common.JDBCUtil;

@Repository
public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String SELECT_BOARD = "SELECT * FROM board WHERE bno=?";
	private final String SELECT_BOARD_ALL = "SELECT * FROM board ORDER BY bno DESC";
	private final String INSERT_BOARD = "INSERT INTO board(bno, title, writer, content) VALUES(seq.NEXTVAL, ?, ?, ?)";
	private final String UPDATE_BOARD = "UPDATE board SET title=?, content=? WHERE bno=?";
	private final String DELETE_BOARD = "DELETE FROM board WHERE bno=?";
	private final String GET_BOARD_CNT = "SELECT cnt FROM board WHERE bno=?";
	private final String SET_BOARD_CNT = "UPDATE board SET cnt=? WHERE bno=?";
	
	public BoardVO getBoard(int bno) {
		BoardVO boardVO = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_BOARD);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardVO.setBno(rs.getInt("bno"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setWriter(rs.getString("writer"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setRegDate(rs.getDate("regdate"));
				boardVO.setCnt(rs.getInt("cnt"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardVO;
	}
	
	public ArrayList<BoardVO> getAllList() {
		ArrayList<BoardVO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_BOARD_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setBno(rs.getInt("bno"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setWriter(rs.getString("writer"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setRegDate(rs.getDate("regdate"));
				boardVO.setCnt(rs.getInt("cnt"));
				boardList.add(boardVO);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	public int addBoard(BoardVO boardVO) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT_BOARD);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getWriter());
			pstmt.setString(3, boardVO.getContent());
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		return 0;
	}
	
	public int updateBoard(BoardVO boardVO) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_BOARD);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			pstmt.setInt(3, boardVO.getBno());
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		return 0;
	}
	
	public int deleteBoard(int bno) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_BOARD);
			pstmt.setInt(1, bno);
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		return 0;
	}
	
	public boolean cntUp(int bno) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(GET_BOARD_CNT);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				pstmt = conn.prepareStatement(SET_BOARD_CNT);
				pstmt.setInt(1, cnt+1);
				pstmt.setInt(2, bno);
				if(pstmt.executeUpdate()>0) {
					return true;
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return false;
	}
	
}
