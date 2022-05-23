// window.addEventListener("resize", containerHcontrol());

// setTimeout(containerHcontrol(), 100);
setInterval(containerHcontrol(), 100);
// window.addEventListener('load', containerHcontrol());
// body onload="somecode();"
function containerHcontrol(containerE){
    // document.write("load");
    console.log(document.getElementById("container"));
    // console.log(window.innerHeight);
    // document.getElementById("container").style.height(window.innerHeight + "px");
    console.log(containerE);
    console.log(window.innerHeight);
    console.log(window.innerHeight.toString());
    console.log(document.querySelector("body #container"));
    // containerE.style.height = window.innerHeight + "px";
    document.getElementById("container").style.height = window.innerHeight + "px";
}