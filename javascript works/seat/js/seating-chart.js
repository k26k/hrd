let people = parseInt(prompt("입장객은 몇 명인가요?", 43));
// let people = 43;
let seat = parseInt(prompt("한 줄에 몇 명씩 앉나요?", 5));
// let seat = 5;
let seatCol=0;
if(people % seat == 0){
    seatCol = parseInt(people/seat);
}else{
    seatCol = parseInt(people/seat)+1;
}


let containerId = document.getElementById("container");
let tableSource = "";

tableSource += "<table>";
for(let i = 0; i < seatCol; i++){
    tableSource += "<tr>";
    console.log("i start");
    for(let j = 1; j <= seat; j++){
        // console.log(i * seat + j);
        tableSource += ("<td>좌석"+ (i * seat + j) + "</td>");
        if (people <= i * seat + j ){
            tableSource += "</tr>";
            console.log("BREAK");
            break;
        }
    }
    tableSource += "</tr>";
    console.log("i end");
}
tableSource += "</table>";
containerId.innerHTML += tableSource;

containerId.innerHTML += "<br>"; // ==================================

tableSource = "";

tableSource += "<table><tr>";
for(let i = 1; i <= people; i++){
    tableSource += ("<td>좌석"+ i + "</td>");
    if (i%seat==0){
        if(i<people){
            tableSource += "</tr><tr>";
        }
    }
}
tableSource += "</tr></table>";
containerId.innerHTML += tableSource;

// 두가지 방법