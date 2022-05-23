// window.addEventListener("resize", containerHcontrol());
function setup(){
    containerHcontrol();
}
// setTimeout(containerHcontrol(), 100);
// setInterval(containerHcontrol(), 100);
// window.addEventListener('load', containerHcontrol());
// body onload="somecode();"
function containerHcontrol(containerE){
    // document.write("load");
    // console.log(document.getElementById("container"));
    // console.log(window.innerHeight);
    // document.getElementById("container").style.height(window.innerHeight + "px");
    // console.log(containerE);
    // console.log(window.innerHeight);
    // console.log(window.innerHeight.toString());
    // console.log(document.querySelector("body #container"));
    // containerE.style.height = window.innerHeight + "px";
    document.getElementById("container").style.height = window.innerHeight + "px";
}
/*
function main(){
    function modeChange(0);
}
function start(){
    function modeChange(1);
}
function score(){
    function modeChange(int = 2);
}


function modeChange(mode){
    if(mode == 0){

    }
}
*/