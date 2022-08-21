<%@ page import="java.time.LocalDateTime"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>안녕~ JSP!!</h2>
	<hr>
	<!-- HTML주석 -->
	<%-- JSP주석 : <%= %> Expression(표현문) 태그라 부름 --%>
	<p>현재 날자와 시간은 <%=LocalDateTime.now() %></p>
</body>
</html>