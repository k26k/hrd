// 놀이공원 입장료 계산 프로그램
// 미취학 1000, 초등학생 2000, 중.고등 2500, 성인 3000
var age = 17;
var charge = 0;
let strH2 = "";
let strP1 = "";
let strP2 = "";

if(age <= 7){
    // document.write("미취학 아동 입니다.");
    strP1 = "<p>미취학 아동 입니다.</p>";
    charge = 1000;
}else if(age <= 13){
    // document.write("초등학생 입니다.");
    strP1 = "<p>초등학생 입니다.</p>";
    charge = 2000;
}else if(age <= 19){
    // document.write("중.고등학생 입니다.");
    strP1 = "<p>중.고등학생 입니다.</p>";
    charge = 2500;
}else{
    // document.write("성인 입니다.");
    strP1 = "<p>성인 입니다.</p>";
    charge = 3000;
}
strH2 = "<h2>놀이공원 입장료 계산</h2>";
// strP1 = "<p></p>";
strP2 = "<p>입장료는 <span class='accent'>" + charge + "원</span> 입니다.</p>";
// document.write("<span style='text-align: center'>" + strH2 + strP1 + strP2 + "</span>");
document.write(strH2 + strP1 + strP2);