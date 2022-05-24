// let people = parseInt(prompt("입장객은 몇 명인가요?", 43));
let people = 43;
// let seat = parseInt(prompt("한 줄에 몇 명씩 앉나요?", 5));
let seat = 5;
let containerId = document.getElementById("container");
// let containerId = document.getElementById("container").innerHTML;
// document.write(containerId);
containerId.innerHTML += "<table>";
for(let i = 0; i < 5; i++){
    containerId.innerHTML += "<tr>";
    for(let j = 0; j < 5; j++){
        // containerId.innerHTML += ("<td>"+ i + j+ "</td>");
        containerId.innerHTML += ("<td>d</td>");
    }
    containerId.innerHTML += "</tr>";
}
containerId.innerHTML += "</table>";