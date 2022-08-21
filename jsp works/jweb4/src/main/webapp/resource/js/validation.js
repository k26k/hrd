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