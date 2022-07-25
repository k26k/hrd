<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록 폼</title>
<style type="text/css">
	h2{background-color: green; text-align: center; padding: 15px; border-radius: 5px; color: #eee;}
	#regform{width: 50%; margin: 0 auto; background-color: lightgreen; padding: 15px 20px; border-radius: 10px;}
	#result{width: 50%; margin: 0 auto; background-color: lightgreen; padding: 15px 20px; display: none;}
</style>
<script type="text/javascript">
	function signUp() {
		if(!confirm("가입하시겠습니까")){return;}
		document.getElementById("regform").style.display="none";
		document.getElementById("rname").innerHTML = document.form1.name.value;
		document.getElementById("rmale").innerHTML = document.form1.email.value;
		document.getElementById("result").style.cssText = "display: block !important;";
	}
</script>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<div id="regform">
		<form action="" method="post" name="form1">
				<label for="name">이름: </label>
				<input type="text" id="name" name="name">
				<hr>
				<label for="email">이메일: </label>
				<input type="text" id="email" name="email">
			<p><input type="button" onclick="signUp()" value="전송"></p>
		</form>
	</div>
	
	<div id="result">
		<h3>가입정보</h3>
		<hr>
		<p>이름: <span id="rname"></span></p>
		<p>이메일: <span id="rmale"></span></p>
	</div>
</body>
</html>