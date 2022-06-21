$(document).ready(function(){
    
    let divSlide = $(".banner .slide")
    let slideItem = $(divSlide).children("div").children("div");
    setTimeout(slideMove,3000);
    function slideMove(){
        
        if(0 < slideItem.length){
            console.log("slide on")
            if(parseInt(parseFloat($(divSlide).css("width"))/parseFloat($(slideItem[0]).css("width"))) < slideItem.length){
                console.log("slide start")
            }
        }else{
            console.log("slide none")
        }
        // setTimeout(slideMove,3000);
    }
});