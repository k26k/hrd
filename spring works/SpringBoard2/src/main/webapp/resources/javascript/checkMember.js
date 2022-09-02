function checkMember() {
	let regExNumEng=/^[0-9a-zA-Z]*$/;
	let regExNumEngSpe=/^[0-9a-zA-Z!@#$%^&*?]*$/;
	let regExNumEngKor=/^[0-9a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ]*$/;
	
	if(!userid.value){
		alert("아이디를 입력해 주세요");
		userid.focus();
		return false;
	}
	if(userid.value.length<4 || 12<userid.value.length || !userid.value.match(regExNumEng)){
		alert("아이디는 숫자와 영어를 사용해 4~12자리로 입력해 주세요");
		userid.focus();
		return false;
	}
	if(!userpw.value){
		alert("비밀번호를 입력해주세요");
		userpw.focus();
		return false;
	}
	if(userpw.value.length<4 || 12<userpw.value.length || !userpw.value.match(regExNumEngSpe)){
		alert("비밀번호는 숫자와 영어, 특수문자를 사용해 4~12자리로 입력해 주세요");
		userpw.focus();
		return false;
	}
	if(!userpw2.value || userpw.value!=userpw2.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		userpw2.focus();
		return false;
	}
	if(!username.value){
		alert("이름을 입력해 주세요");
		username.focus();
		return false;
	}
	if(username.value.length<2 || 10<username.value.length || !username.value.match(regExNumEngKor)){
		alert("이름은 숫자와 영어, 한글을 사용해 2~10자리로 입력해 주세요");
		userpw2.focus();
		return false;
	}
	
	return true;
}