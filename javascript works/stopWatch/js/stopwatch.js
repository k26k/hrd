let time = 0;
let sw = true;

$(document).ready(function(){
    
    stopWatch();
});

function init(){
    document.getElementById("time").innerHTML="00:00:00";
}

function stopWatch(){
    let hour=0, min=0, sec=0;
    let timer;

    $("#startbtn").click(function(){
        if(sw){
            sw=false;
            $(".fa").css("color", "#f60");
            this.style.color = "#555";

            if(time==0){
                init();
            }

            timer = setInterval(function(){
                time++;

                sec = Math.floor(time/100);
                min = Math.floor(sec/60);
                hour = Math.floor(min/60);
                sec = sec%60;
                min = min%60

                
                let th = hour;
                let tm = min;
                let ts = sec;
                if(th < 10){
                    th = "0"+th;
                }
                if(tm < 10){
                    tm = "0"+tm;
                }
                if(ts < 10){
                    ts = "0"+ts;
                }
                let dot="";
                if(time%100<50){
                    dot=":"
                }else{
                    dot="<span style='color: #f60'>:</span>"
                }
                document.getElementById("time").innerHTML=th+dot+tm+dot+ts;
            },10);
        }
    });
    $("#pausebtn").click(function(){
        if(time!=0){
            $(".fa").css("color", "#f60");
            this.style.color = "#555";
            clearInterval(timer);
            sw=true;
        }
    });
    $("#stopbtn").click(function(){
        if(time!=0){
            $(".fa").css("color", "#555");
            $(".fa-play").css("color", "#f60");
            clearInterval(timer);
            sw=true;
            time = 0;
            init();
        }
    });
}