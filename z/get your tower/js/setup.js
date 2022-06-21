$(document).ready(function(){
    $(".startButton").click(function(){
        modeChange(1);
    });
    
    function modeChange(mode){
        if(mode == 0){
            $(".firstScreen").css("display", "block");
            $(".gameScreen").css("display", "none");
            $(".endScreen").css("display", "none");
        }else if(mode == 1){
            $(".firstScreen").css("display", "none");
            $(".gameScreen").css("display", "block");
            $(".endScreen").css("display", "none");
        }else if(mode == 2){
            $(".firstScreen").css("display", "none");
            $(".gameScreen").css("display", "none");
            $(".endScreen").css("display", "block");
        }
    }

    $(".controler button:eq(0)").click(function(){
        $(".display").append("<div class='block' value='10'></div>")
        physicsEngine($(".display"));
        console.log("btn0");
    });
    $(".controler button:eq(1)").click(function(){
        // physicsEngine();
        $(".display").html("");
        console.log("btn1");
    });
    

    function physicsEngine(){
        let 
    }

})