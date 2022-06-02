let massage = ["안녕하세요","감사합니다", "오늘도 좋은 하루!"];
let msfIdx= 0;

myGreating();

function myGreating(){
    let greeting = document.getElementById("demo");
    greeting.innerHTML = massage[msfIdx];
    msfIdx++;
    if(3 <= msfIdx){
        msfIdx = 0;
    }
    setTimeout(myGreating, 200);
    // 매개변수로 자기를 호출하는 콜백함수
}