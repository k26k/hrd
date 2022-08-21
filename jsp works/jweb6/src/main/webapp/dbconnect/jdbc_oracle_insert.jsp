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
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "C##JWEB";
	String password = "54321";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try{
		Class.forName(driverClass);
		conn = DriverManager.getConnection(url, username, password);
		String sql = "INSERT INTO t_student(stdid, stdname) values(?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "102");
		pstmt.setString(2, "가나다");
		pstmt.executeUpdate();
		out.println("성공");
		
	}catch(Exception e){
		out.println("실패<hr>");
		out.println(e);
		
	}finally{
		if(pstmt != null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
%>
</body>
</html>