<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 로그인 성공</title>
</head>
<body>
	<h2>로그인 성공</h2>
	<%= session %><br>
	<p>세션 id: <%= session.getId() %></p>
	<p>userID: <%= session.getAttribute("userID") %></p>
	<p>userPW: <%= session.getAttribute("userPW") %></p>
	<p><a href="session.jsp">데이터 확인</a></p>
</body>
</html>