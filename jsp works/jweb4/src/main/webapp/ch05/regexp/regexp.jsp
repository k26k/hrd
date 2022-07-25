<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정규 표현식 연습</title>
<script type="text/javascript">
	function checkForm(){
		// 변수 선언
		let form = document.frm;
		let name = form.name.value;
		
		// 정규 표현식 선언
		// - 문자열은 영어 대소문자와 한글로만 시작할수 있음
		let regExp1 = /^[a-zA-Z가-힣]/
		
		// 문자열 일치 비교
		if(!regExp1.test(name)){
			alert("첫 글자가 영어 대소문자나 한글이 아님");
			return;
		}
				
		form.submit();
	}
</script>
</head>
<body>
	<form action="" method="post" name="frm">
		<label for="name">이름: </label>
		<input type="text" id="name" name="name">
		<hr>
		<label for="email">이메일: </label>
		<input type="text" id="email" name="email">
		<p><input type="button" onclick="checkForm()" value="전송"></p>
	</form>
</body>
</html>