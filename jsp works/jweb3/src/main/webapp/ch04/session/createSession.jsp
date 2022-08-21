<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 생성</title>
</head>
<body>
	<h2>세션 생성 성공</h2>
	<%= session %><br>
	<p>세션 id: <%= session.getId() %></p>
</body>
</html>