// 내장함수

// 인코딩, 디코딩 함수
let kor = "안알랴쥼"
console.log(kor);
let encoded = encodeURIComponent(kor);
console.log(encoded);
let decoded = decodeURIComponent(encoded);
console.log(decoded);
// 유니코드 문자(한글)는 그냥 전송하면 오류가 나는 경우가 있을수 있다
// 그래서 인코딩 함수를 이용해 부호화해서 전송하고 디코딩 함수를 이용해 복호화한다

// 숫자, 유한.무한 판별
let num1 = "숫자";
if(isNaN(num1)){ //  isNaN은 is not a number의 약자로 ()안에 요소가 숫자면 false 숫자가 아니면 true를 반환
    console.log("숫자 아님");
}else{
    console.log("숫자임");
}

// 자바스크립트 코드 변경 함수
let str1 = "var num7 = 10;"; 
let str2 = "var num8 = 20;"; 

// eval(문자); = 문자를 자바스크립트 코드로 바꿔서 실행하는 함수
eval(str1);
eval(str2);
console.log(num7*num8);
// num7과 num8을 따로 선언하지 않았지만 eval로 선언해서 사용 가능
console.log(eval("7*3")); 
// 별도의 변환 없이 그냥 계산
