function signUp( ) {
	let regExNumEng=/^[0-9a-zA-Z]*$/;
	let regExNumEngSpe=/^[0-9a-zA-Z!@#$%^&*?]*$/;
	let regExNumEngKor=/^[0-9a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ]*$/;
	
	let id = document.getElementById("id");
	let password = document.getElementById("password");
	let password2 = document.getElementById("password2");
	let name = document.getElementById("name");
	
	
	if(!id.value){
		alert("아이디를 입력해 주세요");
		id.focus();
		return false;
	}
	if(id.value.length<4 || 12<id.value.length || !id.value.match(regExNumEng)){
		alert("아이디는 숫자와 영어를 사용해 4~12자리로 입력해 주세요");
		id.focus();
		return false;
	}
	if(!password.value){
		alert("비밀번호를 입력해주세요");
		password.focus();
		return false;
	}
	//if(password.value.length<4 || 12<password.value.length || !password.value.match(regExNumEngSpe)){
	//	alert("비밀번호는 숫자와 영어, 특수문자를 사용해 4~12자리로 입력해 주세요");
	//	password.focus();
	//	return false;
	//}
	if(password.value.length<4 || 12<password.value.length || !password.value.match(regExNumEng)){
		alert("비밀번호는 숫자와 영어를 사용해 4~12자리로 입력해 주세요");
		password.focus();
		return false;
	}
	if(!password2.value || password.value!=password2.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		password2.focus();
		return false;
	}
	if(!name.value){
		alert("이름을 입력해 주세요");
		name.focus();
		return false;
	}
	if(name.value.length<2 || 10<name.value.length || !name.value.match(regExNumEngKor)){
		alert("이름은 숫자와 영어, 한글을 사용해 2~10자리로 입력해 주세요");
		name.focus();
		return false;
	}
	
	return true;
}