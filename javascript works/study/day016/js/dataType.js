window.onload = function(){
    // window.onload = 웹이 전부 로드되고 실행됨
    // function(){실행할 내용}

    // number
    let num1 = 10;
    let num2 = 10.2;
    let num3 = 1e+2;
    // le = 10의 제곱, e = 지수
    // le+2 = 10의 2승 = 100
    console.log(num1, num2, num3)

    // string
    let str1 = "문자";
    let str2 = "문자는 '문자'";
    let str3 = '문자는 "문자"';
    let str4 = 'you\'re too smart...';
    // \백(역)슬래쉬 뒤에 사용한 '은 문자열이 닫히지 않음
    console.log(str1, str2, str3, str4);

    //boolean
    let com1 = (5 > 4);
    let com2 = (5 < 4);
    console.log(com1, com2);

    // undifined , 값이 정의되지 않음
    let storage;
    console.log(storage);

    // null , 
    let gnb1 = document.getElementById("gnb1");
    let gnb2 = document.getElementById("gnb2");
    console.log(gnb1);
    console.log(gnb2);

    // typeof
    let type1 = 10;
    let type2 = "문자";
    let type3 = true;
    console.log(typeof type1, typeof type2, typeof type3, typeof storage, typeof gnb1, typeof gnb2);
}