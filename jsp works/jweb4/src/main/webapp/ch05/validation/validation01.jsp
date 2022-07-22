<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<form action="loginProcess.jsp" method="post" name="loginForm">
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
<script type="text/javascript">
	function checkForm() {
		
		let form = document.loginForm;
		let id = document.loginForm.id.value;
		let pw = document.loginForm.pw.value;
		
		if(id == ""){
			alert("id is none");
			form.id.focus();
			return;
		}else if(pw == ""){
			alert("pw is none");
			form.pw.focus();
			return;
		}
		
		alert(id+"\n"+pw);
		
		form.submit();
	}
</script>
</body>
</html>