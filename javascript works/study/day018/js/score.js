// 시험 점수 관리

// 시험 점수 이중 배열 선언
let score = [
    [80, 70], 
    [90, 60], 
    [70, 70], 
    [100, 90], 
    [83, 35]
];

// 과목별 점수 합계 변수 선언
// let korSum = 0;
// let mathSum = 0;
let korSum = 0 , mathSum = 0;
let korAvg = 0 , mathAvg = 0;

// 과목별 점수 합계
for(let i in score){
    korSum += score[i][0];
    mathSum += score[i][1];
}
korAvg = korSum/score.length;
mathAvg = mathSum/score.length;
// 합계 확인
document.write("국어 합계: " + korSum + "점<br>");
document.write("수학 합계: " + mathSum + "점<br>");
document.write("<br>");
document.write("국어 평균: " + korAvg + "점<br>");
document.write("수학 평균: " + mathAvg + "점<br>");