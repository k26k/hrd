setInterval(watch, 1000);
function watch(){
    const date = new Date();
    let now = date.toLocaleTimeString();
    document.getElementById("display").innerHTML = now;
}