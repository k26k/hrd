<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<script type="text/javascript">
	// 아이디 체크 - 영어 소문자만 입력
	// 비밀번호 체크 - 숫자만 입력 가능 
	function checkForm() {
		// if(!confirm("가입하시겠습니까")){return;}
		
		let form = document.loginForm;
		let uid = form.id.value; 
		let upw = form.pw.value;
		
		let a = /^[a-z]*$/;
		
		if(uid == ""){
			alert("아이디를 입력해 주세요.");
			form.id.focus();
			return;
		}
		
		// 정규식을 사용하는 방법
		if(a.test(uid)){
			alert("아이디는 영어 소문자만 입력해 주세요.");
			form.id.focus();
			return;
		}
		
		/* 
		// 포문으로 문자를 하나하나 대조하는 방법
		for(let i in uid){
			if(uid.charAt(i) < 'a' || 'z' < uid.charAt(i)){
				alert("아이디는 영어 소문자만 입력해 주세요.");
				form.id.focus();
				return;
			}
		} 
		*/
		
		
		if(upw == ""){
			alert("패스워드를 입력해 주세요.");
			form.pw.focus();
			return;
		}
		
		form.submit();
	}		
</script>
</head>
<body>
	<form action="../validation/loginProcess2.jsp" method="post" name="loginForm">
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