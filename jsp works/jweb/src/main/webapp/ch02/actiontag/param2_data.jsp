<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param ์ก์ ํ๊ทธ</title>
</head>
<body>
	<% 
		String title = request.getParameter("title");
	%>
	<h3><%=URLDecoder.decode(title) %></h3>
	<p>today is <%=request.getParameter("date") %></p>
</body>
</html>