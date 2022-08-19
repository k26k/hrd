function checkMember(){
	let form = document.getElementsByClassName("member_add_form")[0];
	let id = form.memberID;
	let pw1 = form.passwd;
	let pw2 = form.passwd_confirm;
	let name = form.name;
	let gender = form.gender;
	let idV = id.value;
	let pw1V = pw1.value;
	let pw2V = pw2.value;
	let nameV = name.value;
	let genderV = gender.value;
	//console.log(id.value,pw1.value,pw2.value,name.value,gender.value);
	//console.log(id,pw1,pw2,name,gender);
	//console.log(idV,pw1V,pw2V,nameV,genderV);
	
	let regExpId = /^[a-zA-Z0-9]*$/;
	let regExpPw1 = /[a-zA-Z0-9]/;
	let regExpPw2 = /[!@#$%^&*]/;
	let regExpPw3 = /[ㄱ-ㅎㅏ-ㅣ가-힣]/;
	let regExpName = /[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]/;
	
	if(idV.length < 4 || 10 < idV.length || !regExpId.test(idV)){
		alert("아이디는 영문과 숫자만 사용하여 4~10자 이내로 입력해주세요.");
		id.focus();
		return;
		
	}else if(pw1V.length < 4 || 10 < pw1V.length || !regExpPw1.test(pw1V) || !regExpPw2.test(pw1V) || regExpPw3.test(pw1V)){
		alert("비밀번호는 영문과 숫자, 특수문자를 전부 사용하여 4~10자 이내로 입력해주세요.");
		pw1.focus();
		return;
		
	}else if(pw1V !== pw2V){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		pw2.focus();
		return;
		
	}else if(nameV.length < 2 || 10 < nameV.length || !regExpName.test(nameV)){
		alert("이름은 영문과 한글만 사용하여 2~10자 이내로 입력해주세요.");
		name.focus();
		return;
		
	}else if(genderV===""){
		alert("성별을 선택해주세요.");
		gender.focus();
		return;
		
	}
	
	form.submit();
}