<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl sql 태그 예제</title>
</head>
<body>
	<form action="./insertProcess.jsp" method="post">
		<p>id: <input type="text" name="eid"></p>
		<p>pw: <input type="text" name="passwd"></p>
		<p>이름: <input type="text" name="name"></p>
		<p><input type="submit" value="가입"></p>
	</form>
</body>
</html>