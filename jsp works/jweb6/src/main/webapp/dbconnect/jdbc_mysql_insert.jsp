<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String driverClass = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&serverTimezone=Asia/Seoul";
	String username = "root";
	String password = "12345";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try{
		Class.forName(driverClass);
		conn = DriverManager.getConnection(url, username, password);
		out.println("mysql db연결 성공<hr>");
		String sql = "INSERT INTO user(uid, pwd, name) VALUES(?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 135);
		pstmt.setString(2, "4321");
		pstmt.setString(3, "안산");
		pstmt.executeUpdate();
		out.println("mysql db삽입 성공<hr>");
		
	}catch(Exception e){
		out.println("실패<hr>");
		out.println(e.getMessage());
		
	}finally{
		if(pstmt != null){
			pstmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
%>
</body>
</html>