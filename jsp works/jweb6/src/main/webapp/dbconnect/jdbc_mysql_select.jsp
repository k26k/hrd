<%@page import="java.sql.ResultSet"%>
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
<style type="text/css">
	table, td {border-collapse: collapse; border: 1px solid #ccc;}
	td {padding: 10px 15px;}
</style>
</head>
<body>
<%
	String driverClass = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&serverTimezone=Asia/Seoul";
	String username = "root";
	String password = "12345";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	
	try{
		Class.forName(driverClass);
		conn = DriverManager.getConnection(url, username, password);
		out.println("mysql db연결 성공<hr>");
		String sql = "SELECT * FROM user";
		pstmt = conn.prepareStatement(sql);
		rst = pstmt.executeQuery();
		
		out.println("mysql 조회 성공<hr>");
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>uid</td>");
		out.println("<td>pwd</td>");
		out.println("<td>name</td>");
		out.println("</tr>");
		StringBuffer str = new StringBuffer("");
		while(rst.next()){
			out.println("<tr>");
			out.println("<td>"+rst.getInt("uid")+"</td>");
			out.println("<td>"+rst.getString("pwd")+"</td>");
			out.println("<td>"+rst.getString("name")+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
	}catch(Exception e){
		out.println("실패<hr>");
		out.println(e.getMessage());
		
	}finally{
		if(rst != null){
			rst.close();
		}
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