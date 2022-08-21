<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function signUpCheck(){
		let form = document.getElementById("login");
		let id = form.id.value;
		let pw = form.pw.value;
		let name = form.name.value;
		
		let regExpId = /^[a-zA-Zㄱ-ㅎ가-힣]/;
		let regExpPw1 = /[a-zA-Z]/;
		let regExpPw2 = /[0-9]/;
		let regExpPw3 = /[~!@#$%^&*+-/_]/;
		
		if(!regExpId.test(id)){
			alert("아이디는 문자로 시작해 주세요");
			return;	
		}
		
		if(	!regExpPw1.test(pw)
			|| !regExpPw2.test(pw)
			|| !regExpPw3.test(pw)){
			alert("비밀번호는 영문자, 숫자, 특수문자를 전부 포함해주세요.");
			return;	
		}
		
		if(name == ""){
			alert("이름을 입력해주세요.");
			return;	
		}
		
		form.submit();
	}
</script>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="test_process.jsp" method="post" id="login">
	<p>아이디: <input type="text" name="id" ></p>
	<p>비밀번호: <input type="text" name="pw" ></p>
	<p>이름: <input type="text" name="name" ></p>
	<p><input type="button" onclick="signUpCheck()" value="가입하기" ></p>
	</form>
</body>
</html>