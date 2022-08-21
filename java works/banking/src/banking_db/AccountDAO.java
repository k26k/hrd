package banking_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import banking_db.common.JDBCUtil;

public class AccountDAO {
	
//	JDBC 변수 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
//	private Scanner sc = new Scanner(System.in);
	
//	계좌 생성
	public void createAccount(Account account) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO account(ano, owner, balance) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAno());
			pstmt.setString(2, account.getOwner());
			pstmt.setInt(3, account.getBalance());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
//	계좌 목록 가져오기
	public List<Account> getAccountList() {
		List<Account> accountList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM account";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String ano = rs.getString("ano");
				String owner = rs.getString("owner");
				int balance = Integer.parseInt(rs.getString("balance"));
				Account account = new Account(ano, owner, balance);
				accountList.add(account);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return accountList;
	}
	
//	계좌 가져오기
	public Account getAccount(String ano) {
		Account account = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM account WHERE ano=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ano = rs.getString("ano");
				String owner = rs.getString("owner");
				int balance = Integer.parseInt(rs.getString("balance"));
				System.out.println(ano+""+owner+""+balance);
				account = new Account(ano, owner, balance);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return account;
	}
	
//	계좌 수정
	public void updateAccount(Account account) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE account SET balance = ? WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getBalance());
			pstmt.setString(2, account.getAno());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
//	계좌 삭제
	public void deleteAccount(String ano) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "DELETE FROM account WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	
}
