function showText(){
    let text = document.getElementById("detail");
    text.style.display = "block";

    let button = document.getElementById("show");
    button.style.display = "none";
}
function hideText(){
    let text = document.getElementById("detail");
    text.style.display = "none";

    let button = document.getElementById("show");
    button.style.display = "block";
}