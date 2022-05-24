// window.addEventListener("resize", containerHcontrol());
// function setup(){
//     containerHcontrol();
// }
// setTimeout(function(){containerHcontrol();}, 50);
setTimeout(function(){modeChange(1);}, 500);
setTimeout(function(){modeChange(2);}, 1000);
setTimeout(function(){modeChange(0);}, 1500);
// setTimeout(function() {
//     console.log('Works!');
//   }, 3000);

// window.addEventListener('load', containerHcontrol());
// body onload="somecode();"
// function containerHcontrol(containerE){
//     // document.write("load");
//     // console.log(document.getElementById("container"));
//     // console.log(window.innerHeight);
//     // document.getElementById("container").style.height(window.innerHeight + "px");
//     // console.log(containerE);
//     // console.log(window.innerHeight);
//     // console.log(window.innerHeight.toString());
//     // console.log(document.querySelector("body #container"));
//     // containerE.style.height = window.innerHeight + "px";
//     document.getElementById("container").style.height = (window.innerHeight-1) + "px";
//     // console.log('setup success');
// }
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
*/

function modeChange(mode){
    console.log('mode change to ' + mode);
    document.getElementById("firstScreen").style.display = "none";
    document.getElementById("gameScreen").style.display = "none";
    document.getElementById("endScreen").style.display = "none";
    if(mode == 0){
        document.getElementById("firstScreen").style.display = "block";
    }else if(mode == 1){
        document.getElementById("gameScreen").style.display = "block";
    }else if(mode == 2){
        document.getElementById("endScreen").style.display = "block";
    }else{
        console.log('mode not changed');
    }
    
}

setTimeout(function(){containerFit(window.innerHeight, document.getElementById("container"));}, 100);
function containerFit(containerTargetHeight,containerEId){
    // containerTargetHeight = window.innerHeight;
    // containerEId = document.getElementById("container")
    if(window.innerHeight < containerTargetHeight-1 || containerTargetHeight+1 < window.innerHeight){
        containerTargetHeight = window.innerHeight;
        containerEId.style.height = (containerTargetHeight-2) + "px";
        
    }
    setTimeout(function(){containerFit(containerTargetHeight, containerEId);}, 5);
}
// setInterval(function(){containerHcontrol();}, 10);