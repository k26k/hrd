<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 로그인</title>
</head>
<body>
	<form action="loginCheck.jsp" method="post">
		<p>
			<label for="userid">아이디: </label>
			<input type="text" id="userid" name="userid">
		</p>
		<p>
			<label for="userpw">패스워드: </label>
			<input type="password" id="userpw" name="userpw">
		</p>
		<p><input type="submit"	value="로그인"></p>
	</form>
</body>
</html>