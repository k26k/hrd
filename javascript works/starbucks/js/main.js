let title = document.querySelector("section h1");

window.addEventListener("scroll",function(){
    let value = this.window.scrollY;
    console.log(document.styleSheets[0].cssRules[4].cssText);
    document.styleSheets[0].cssRules[4].cssText="1";
    // let moveX = 1000;
    let moveS = 1000;
    let titleRect = title.getBoundingClientRect()
    let nowX = titleRect.left;
    // let nowX = title.getAttribute("style");
    let willX = 0;
    // 해당 객체의 스크롤 y값 즉 수직으로 스크롤한 값을 가져옴
    // console.log(value);
    // console.log(moveX);
    // console.log(nowX);
    // console.log(willX);

    // if(200<value){
    //     // title.style.animation = "slideIn 1s ";
    // }else{
    //     title.style.animation = "slideOut 1s ";
    // }
    // title.style.animation= "@keyframes {"+"} 1s"

    
    if(nowX != willX){
        if(100<value){
            willX = 400;
            console.log(willX);
        }else{
            willX = -600;
            console.log(willX);
        }
        let ani = "@keyframes {0%{left:" + nowX + "px}100%{left:" + willX + "px}} "+ "1ms";
        console.log(ani);
        title.style.animation= ani;
    }


});