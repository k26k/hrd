$(document).ready(function(){
    $(".hdd").click(function(){
        if($(".topMenu").parent().css("display")==="none"){
            console.log("display == none");
            $(".topMenu").parent().slideDown("fast");
            $(".hdd").removeClass("fa-bars");	
            $(".hdd").addClass("fa-x");
        }else{
            console.log("display != none");
            $(".topMenu").parent().slideUp("fast");
            $(".hdd").removeClass("fa-x");
            $(".hdd").addClass("fa-bars");
        }
    });

    $(window).resize(function() {
        if (600<=parseInt($('header').css('width'))){
            console.log("down");
            $(".topMenu").parent().slideDown(0);
            $(".hdd").removeClass("fa-x");
            $(".hdd").addClass("fa-bars");
            $(".demo").remove()
        }else{
            if($(".hdd").hasClass("fa-bars")){
                console.log("up")
                $(".topMenu").parent().slideUp(0);
            }
        }
    }); 

    $(".content-image").each(function(index){
        let cdiv = $(this);
        console.log($(cdiv));
        $(cdiv).click(function(){
            console.log(index);
            if (parseInt($('header').css('width'))<=600){
                $(".container").append("<div class='demo'></div>");
                $(".demo").append("<div class='demo-img'></div><div class='demo-txt'></div>")
                $(".demo").css({
                    "background":"rgba(0,0,0,0.3)", "width":"100%", "height":"100%",
                    "position":"fixed", "top":"0", "left":"0"
                }).click(function(){
                    console.log("demo click");
                    $(".demo").remove();
                })

                $(".demo-img").css({
                    "width":"95%", "height":"auto",
                    "margin":"20% auto 20px auto"
                }).append($(cdiv).html());
                $(".demo-img img").css({
                    "width":"100%", "height":"auto", "display":"block", "border-radius":"20px" 
                });
                $(".demo-img p").remove();
                $(".demo-txt").css({
                    "background":"rgba(255,255,255,1)", "width":"95%", "height":"auto",
                    "margin":"20px auto 20px auto", "box-sizing":"border-box", "padding":"20px",
                    "border-radius":"20px", 
                }).append($(cdiv).siblings("div").html());
                $(".demo-txt div").css({
                    "width":"100%", "height":"auto",
                });
            }
        })
    });
})