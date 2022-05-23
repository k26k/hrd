let score = parseInt(prompt("점수를 입력해 주세요.", 100));
let grade = "";

if(90<=score){
    grade = "A";
}else if(80<=score){
    grade = "B";
}else if(70<=score){
    grade = "C";
}else if(60<=score){
    grade = "D";
}else{
    grade = "F";
}

grade = "<span class='accent'>" + grade + "</span>";

document.write("<h2>학점 계산 프로그램</h2><p>학점은 " + grade + "입니다.</p>");