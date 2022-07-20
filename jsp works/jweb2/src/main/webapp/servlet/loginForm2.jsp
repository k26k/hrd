<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servlet 요청하기</title>
</head>
<body>
	<form action="/login2" method="post">
		<p>
			<label for="userid">아이디: </label>
			<input type="text" id="userid" name="userid">
		</p>
		<p>
			<label for="userpw">패스워드: </label>
			<input type="password" id="userpw" name="userpw">
		</p>
		<p><input type="hidden"	id="phone" name="phone" value="010-1234-1234"></p>
		<p><input type="submit"	value="전송"></p>
	</form>
</body>
</html>