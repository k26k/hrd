<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param 액션 태그</title>
</head>
<body>
	<h2></h2>
	<jsp:forward page="param1_data.jsp">
		<jsp:param value="admin" name="id"/>
		<jsp:param value="1234" name="pw"/>
	</jsp:forward>
</body>
</html>