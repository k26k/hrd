window.onload = function(){
    let imgBig = document.querySelector("#content .big-img");
    let imgSmall = document.querySelectorAll("#content .small-img");
    // console.log(imgSmall);

    for(let i in imgSmall){
        imgSmall[i].onclick = showBig;
    }

    function showBig(){
        // 여기서 this는 이벤트를 실행하는 해당 대상을 뜻함
        imgBig.setAttribute("src", this.getAttribute("src"));
    }
}