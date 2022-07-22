<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
<script src="../resource/js/validation.js">
</script>
</head>
<body>
	<form action="loginProcess2.jsp" method="post" name="loginForm">
		<p>
			<label for="id">아이디: </label>
			<input type="text" id="id" name="id">
		</p>
		<p>
			<label for="pw">패스워드: </label>
			<input type="password" id="pw" name="pw">
		</p>
		<p><input type="button" onclick="checkForm()" value="전송"></p>
	</form>
</body>
</html>