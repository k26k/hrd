<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정규 표현식 연습</title>
<!-- <script type="text/javascript">
	function checkMember(){
		// 변수 선언
		let form = document.Member;
		let id = form.id.value;
		let pw = form.pw.value;
		let name = form.name.value;
		let phone = form.phone1.value
					+"-"+form.phone2.value
					+"-"+form.phone3.value;
		let email = form.email.value;
		
		// 정규 표현식 선언
		// - 문자열은 영어 대소문자와 한글로만 시작할수 있음
		let regExpId = /^[a-zA-Z가-힣]*$/;
		let regExpPw = /^[0-9]*$/;
		let regExpName = /^[ㄱ-ㅎㅏ-ㅚ가-힣]*$/;
		let regExpPhone = /\d{2,3}-\d{3,4}-\d{4}/;
		//let regExpEmail = /^[0-9a-zA-Z]*@[0-9a-zA-Z]*\.[a-zA-Z]{2,3}$/
		let regExpEmail = 
			/^[0-9a-zA-Z]([-_]?[0-9a-zA-Z])*@/^[0-9a-zA-Z]([-_]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		/*
		// 정규식 검사
		if(id == "" || !regExpId.test(id)){
			alert("아이디는 영어 대소문자, 한글만 입력해주세요.");
			form.id.focus();
			return;
		}
		
		if(pw == "" || !regExpPw.test(pw)){
			alert("비밀번호는 숫자만 입력해주세요.");
			form.pw.value="";
			form.pw.focus();
			return;
		}
		
		if(name == "" || !regExpName.test(name)){
			alert("이름은 한글만 입력해주세요.")
			form.name.focus();
			return;
		}

		if(!regExpPhone.test(phone)){
			alert("연락처 입력을 확인해주세요.")
			form.phone1.focus();
			return;
		}
		*/
		if(!regExpEmail.test(email)){
			alert(email+"\n이메일 입력을 확인해주세요.");
			form.email.focus();
			return;
		}
		
		form.submit();
	}
</script> -->
<script type="text/javascript">
	function checkMember(){
		// 변수 선언
		let form = document.Member;
		let email = form.email.value;
		
		// 정규 표현식 선언
		//let regExpEmail = /^[0-9a-zA-Z]*@[0-9a-zA-Z]*\.[a-zA-Z]{2,3}$/
		let regExpEmail = /^[0-9a-zA-Z]([-_]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/

		if(!regExpEmail.test(email)){
			alert(email+"\n이메일 입력을 확인해주세요.");
			form.email.focus();
			return;
		}
		
		form.submit();
	}
</script>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="validation_process.jsp" method="post" name="Member">
		<p>아이디: <input type="text" name="id" ></p>
		<p>비밀번호: <input type="text" name="pw" ></p>
		<p>이름: <input type="text" name="name" ></p>
		<p>
			연락처: <select name="phone1">
				<option value="010">010</option>
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="041">041</option>
			</select>
			- <input type="text" maxlength="4" size="4" name="phone2" >
			- <input type="text" maxlength="4" size="4" name="phone3" >
		</p>
		<p>이메일: <input type="text" name="email" ></p>
		<p><input type="button" onclick="checkMember()" value="전송"></p>
	</form>
</body>
</html>