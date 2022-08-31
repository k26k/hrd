package com.cloud.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class MemberTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void testInsertMember() {
		String sql = "INSERT INTO tbl_member(userid, userpw, username) VALUES(?, ?, ?)";
		
		for(int i=0; i<100; i++) {
			try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				String num;
				if(i<10) {
					num="0"+i;
				}else {
					num=String.valueOf(i);
				}
				pstmt.setString(2, passwordEncoder.encode("pw"+num));
				if(i<80) {
					pstmt.setString(1, "user"+num);
					pstmt.setString(3, "일반사용자"+num);
				}else if(i<90) {
					pstmt.setString(1, "member"+num);
					pstmt.setString(3, "회원"+num);
				}else {
					pstmt.setString(1, "admin"+num);
					pstmt.setString(3, "관리자"+num);
				}
				log.info(pstmt.executeUpdate());
				
			}catch(Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
	@Test
	public void testInsertMemberAuth() {
		String sql = "INSERT INTO tbl_member_auth(userid, auth) VALUES(?, ?)";
		
		for(int i=0; i<100; i++) {
			try(Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)){
				String num;
				if(i<10) {
					num="0"+i;
				}else {
					num=String.valueOf(i);
				}
				if(i<80) {
					pstmt.setString(1, "user"+num);
					pstmt.setString(2, "ROLE_USER");
				}else if(i<90) {
					pstmt.setString(1, "member"+num);
					pstmt.setString(2, "ROLE_MEMBER");
				}else {
					pstmt.setString(1, "admin"+num);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				log.info(pstmt.executeUpdate());
				
			}catch(Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
}
