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
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "C##JWEB";
	String password = "54321";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	
	try{
		Class.forName(driverClass);
		conn = DriverManager.getConnection(url, username, password);
		String sql = "SELECT * FROM t_student";
		pstmt = conn.prepareStatement(sql);
		rst = pstmt.executeQuery();
		//rst = pstmt.getResultSet();
		
		out.println("성공<hr>");
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>stdid</td>");
		out.println("<td>stdname</td>");
		out.println("</tr>");
		StringBuffer str = new StringBuffer("");
		while(rst.next()){
			out.println("<tr>");
			out.println("<td>"+rst.getInt("stdid")+"</td>");
			out.println("<td>"+rst.getString("stdname")+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
	}catch(Exception e){
		out.println("실패<hr>");
		out.println(e);
		
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