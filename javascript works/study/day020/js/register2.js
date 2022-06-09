// 유효성 검사(체크)
let id = document.getElementById("user-id");
let pw1 = document.getElementById("user-pw1");
let pw2 = document.getElementById("user-pw2");

// 정규표현식
let pw_part1 = /[0-9A-Za-z]/;

function pw_part2(len){
    return /[0-9A-Za-z]{len}/;
}

// onchange 속성 사용
id.onchange = checkId;
// 함수 호출(괄호를 생략해서 이벤트 발생시만 호출됨)
pw1.onchange = checkPw;
pw2.onchange = comparePw;

// 아이디 자리수 체크 함수
function checkId(){
    if(id.value.length < 4 || 15 < id.value.length){
        alert("아이디는 4~15자리로 해주세요.");
        id.focus();
    }
}

// 비밀번호 자리수 체크 함수
function checkPw(){
    if(pw1.value.length < 8){
        alert("비밀번호는 8자리 이상으로 해주세요");
        pw1.value="";
        pw1.focus();
    }else if(!pw_part1.test(pw1.value)){
        alert("비밀번호는 숫자, 영 대.소문자를 사용해서 만들어주세요");
        pw1.value="";
        pw1.focus();
    }else{
        console.log(pw_part1);
        console.log(pw1.value);
        console.log(pw_part1.test(pw1.value));
        console.log(!pw_part1.test(pw1.value));
    }
}

// 비밀번호 체크 함수
function comparePw(){
    if(pw1.value != pw2.value){
        alert("비밀번호가 일치하지 않습니다.")
        pw2.value="";
        pw2.focus();
    }
}