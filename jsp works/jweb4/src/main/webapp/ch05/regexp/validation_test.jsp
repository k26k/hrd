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
		
		if(id == "" || pw == ""){
			alert("아이디(또는 비밀번호)를 입력해주세요.");
			return;	
		}
		if(pw.search(id)!=-1){
			alert("비밀번호는 아이디를 포함할 수 없습니다.");
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