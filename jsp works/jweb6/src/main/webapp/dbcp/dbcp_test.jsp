<%@page import="javax.print.attribute.standard.PrinterMessageFromOperator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");

	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/oracle"); // "java:/comp/env/jdbc/oracle"
		
		conn = ds.getConnection();
		
		if(request.getParameter("name")!=null && request.getParameter("email")!=null){
			if(!request.getParameter("name").equals("") && !request.getParameter("email").equals("")){
				String sql = "INSERT INTO dbcp_test VALUES(?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, request.getParameter("name"));
				pstmt.setString(2, request.getParameter("email"));
				pstmt.executeUpdate();
			}
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="text-align: center;">
		<h2>이벤트 등록</h2>	
		<hr>
		<form action="" method="post">
			<p>
				이름: <input type="text" name="name" style="background-color: #def; border: 1px solid #666; border-radius: 3px; padding: 3px 6px;">
				이메일: <input type="text" name="email" style="background-color: #def; border: 1px solid #666; border-radius: 3px; padding: 3px 6px;">
				<input type="submit" value="등록">
			</p>
		</form>
	</div>
	<hr>
	<p>=== 등록 목록 ===</p>
	<% 
		try{
			String sql = "SELECT * FROM dbcp_test";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()){
				out.println("<p>"+(i++)+". 이름: "+rs.getString("name")+", 이메일: "+rs.getString("email")+"</p>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>