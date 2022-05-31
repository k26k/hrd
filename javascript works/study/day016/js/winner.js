// 응모자 수
let member = parseInt(prompt("전체 응모자 수",50));
let winner = new Array(parseInt(prompt("당첨자 수",5)));
if(member < winner.length){
    member = winner.length;
}

console.log(winner);
// 추첨
for(let i = 0; i< winner.length ; i++){
    let pickOne = Math.floor(Math.random()*member)+1;
    console.log(winner, pickOne);
    let count = 0;
    for(let j = 0; j < i; j++){
        if(winner[j] == pickOne){
            i--;
            console.log("중복");
            count++;
            break;
        }
    }
    if(count<=0){
        winner[i] = pickOne;
    }
}
// 중복이 생김
console.log(winner);


// 발표
document.write("<p>전체 응모자수 : " + member + "명</p>");
document.write("<p>당첨자 : " + winner.join("번, ") + "번</p>");