<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 전역 변수 선언 -->
<%!
	int count = 0;
%>
</head>
<body>

	<h3>Page Count is<%= ++count%></h3>

	<%-- <p>Today's date: <%= new java.util.Date().toLocaleString() %></p> --%>  
	<p>Today's date: <%= new Date().toLocaleString() %></p>  
	
</body>
</html>