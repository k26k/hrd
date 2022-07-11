package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconnect.common.JDBCUtil;

// DAO data access object DB 작업을 수행하는 클래스
public class PersonDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
//	CRUD(create, read, update, delete)
	
//	자료 삽입
	public void insertPerson(Person person) {
		conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO person(userid, userpw, name, age) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getUserId());	// person의 id를 가져와서 sql에 세팅
			pstmt.setString(2, person.getUserPw());	// person의 pw를 가져와서 sql에 세팅
			pstmt.setString(3, person.getName());  	// person의 name를 가져와서 sql에 세팅
			pstmt.setInt(4, person.getAge());		// person의 age를 가져와서 sql에 세팅
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	
//	자료 전체 조회
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> personList = new ArrayList<>();
		// DB 연결
		conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM person";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Person person = new Person();
				person.setUserId(rs.getString("userid"));
				person.setUserPw(rs.getString("userpw"));
				person.setName(rs.getString("name"));
				person.setAge(Integer.parseInt(rs.getString("age")));
				
				personList.add(person);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return personList;
	}
	
	
//	상세조회
	public Person getPerson(String userId) {
		Person person = new Person();
		conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM person WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				person.setUserId(rs.getString("userid"));
				person.setUserPw(rs.getString("userpw"));
				person.setName(rs.getString("name"));
				person.setAge(Integer.parseInt(rs.getString("age")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return person;
	}
	
	
//	자료 수정
	public void updatePerson(Person person) {
		conn = JDBCUtil.getConnection();
		String sql = "UPDATE person SET userpw=?, name=?, age=? WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getUserPw());	// person의 pw를 가져와서 sql에 세팅
			pstmt.setString(2, person.getName());  	// person의 name를 가져와서 sql에 세팅
			pstmt.setInt(3, person.getAge());		// person의 age를 가져와서 sql에 세팅
			pstmt.setString(4, person.getUserId());	// person의 id를 가져와서 sql에 세팅
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	
//	자료 삭제
	public void deletePerson(Person person) {
		conn = JDBCUtil.getConnection();
		String sql = "DELETE FROM person WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getUserId());
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
}
