$(document).ready( function() {
	function goHide(){
		for(let i=1; i<5; i++){
			$(".gnb_depth2_"+i).fadeOut("slow");	
		}
	}

	let mainMenuClass = "gnb";
	let subMenuClass = "gnb_depth";
	let navA1s = $("."+mainMenuClass).children().children("a");
	let navDivs = $("."+mainMenuClass).children().children("."+subMenuClass);
	let navA2s = $(navDivs).find("a");
	let openSpeed = 250;
	let waitTime = 500;
	let closeSpeed = 500;
	console.log(navA1s, navDivs, navA2s);

	function checkOpacity(){
		let ar = [];
		$(navDivs).each(function(){
			if($(this).css("display")==="none"){
				ar.push("0");
			}else{
				ar.push($(this).css("opacity"));
			}
			
		})
		// console.log(ar);
		ar.sort().reverse();
		// console.log(ar[0]);
		return (ar[0]);

	}

	$("."+mainMenuClass).children("li").each(function(index){
		// console.log($(this));
		let navA1 = $(this).children("a");
		let navDiv = $(this).children("."+subMenuClass);
		let navA2 = $(navDiv).find("a");
		console.log(navA1, navDiv, navA2);

		$(navA1).on({
			"mouseover":function(){
				if(800<parseInt($("header").css("width"))){
					if($(navDivs).hasClass("on"))
					$(navDivs).removeClass("on");
					$(navDiv).addClass("on");
					let value = checkOpacity();
					// console.log(value);
					if(value == "0"){
						$(navDivs).stop(true, false).fadeOut(0);
						$(navDiv).stop(true, false).fadeIn(openSpeed);
					}else if(value == "1"){
						$(navDivs).stop(true, false).fadeOut(0);
						$(navDiv).stop(true, false).fadeIn(0);
					}else{
						let speed = openSpeed *(1 - parseFloat(value));
						// console.log(speed, parseFloat(value))
						$(navDivs).stop(true, false).fadeOut(speed);
						$(navDiv).stop(true, false).fadeIn(speed);
					}
				}
			},"focus":function(){
				if(800<parseInt($("header").css("width"))){
					if($(navDivs).hasClass("on"))
					$(navDivs).removeClass("on");
					$(navDiv).addClass("on");
					let value = checkOpacity();
					// console.log(value);
					if(value == "0"){
						$(navDivs).stop(true, false).fadeOut(0);
						$(navDiv).stop(true, false).fadeIn(openSpeed);
					}else if(value == "1"){
						$(navDivs).stop(true, false).fadeOut(0);
						$(navDiv).stop(true, false).fadeIn(0);
					}else{
						let speed = openSpeed *(1 - parseFloat(value));
						// console.log(speed, parseFloat(value))
						$(navDivs).stop(true, false).fadeOut(speed);
						$(navDiv).stop(true, false).fadeIn(speed);
					}
				}
			},"mouseleave":function(){
				$(navDivs).removeClass("on");
				setTimeout(function(){
					if(!$(navDiv).hasClass("on")){
						$(navDiv).stop(true, false).fadeOut(closeSpeed);
					}
				},waitTime);
			},"blur":function(){
				$(navDivs).removeClass("on");
				setTimeout(function(){
					if(!$(navDiv).hasClass("on")){
						$(navDiv).stop(true, false).fadeOut(closeSpeed);
					}
				},waitTime);
			}
		});
		$(navDiv).add($(navA2)).on({
			"mouseover":function(){
				$(navDivs).removeClass("on");
				$(navDiv).addClass("on");
				if(800<parseInt($("header").css("width"))){
					$(navDiv).stop(true, false).fadeIn(openSpeed);
				}
			},"focus":function(){
				$(navDivs).removeClass("on");
				$(navDiv).addClass("on");
				if(800<parseInt($("header").css("width"))){
					$(navDiv).stop(true, false).fadeIn(openSpeed);
				}
			},"mouseleave":function(){
				if($(navDiv).hasClass("on")){
					$(navDivs).removeClass("on").removeClass("last");
					$(navDiv).addClass("last");
					setTimeout(function(){
						if(!$(navDiv).hasClass("on")){
							$(navDiv).stop(true, false).fadeOut(closeSpeed);
						}		
					},waitTime);
				}
			},"blur":function(){
				if($(navDiv).hasClass("on")){
					$(navDivs).removeClass("on").removeClass("last");
					$(navDiv).addClass("last");
					setTimeout(function(){
						if(!$(navDiv).hasClass("on")){
							$(navDiv).stop(true, false).fadeOut(closeSpeed);
						}		
					},waitTime);
				}
			}
		});
	});


	// console.log($(subnavs));
	// $(subnavs).each(function(index){
	// 	console.log($(this));
	// 	let subnav = $(this);
	// 	console.log($(subnav));
	// 	let navf = {
	// 		"mouseenter":function(){
	// 			if(800<parseInt($("header").css("width"))){
	// 				$(subnavs).removeClass("on");
	// 				$(subnav).addClass("on");
	// 				show(subnav, subnavs);
	// 			}
	// 		},"focus":function(){
	// 			if(800<parseInt($("header").css("width"))){
	// 				$(subnavs).removeClass("on");
	// 				$(subnav).addClass("on");
	// 				show(subnav, subnavs);	
	// 			}
	// 		},"mouseleave":function(){
	// 			$(subnavs).removeClass("on");
	// 			hide(subnav, subnavs);
	// 		},"blur":function(){
	// 			$(subnavs).removeClass("on");
	// 			hide(subnav, subnavs);
	// 		}
	// 	};
	// 	$(subnav).add($(subnav).siblings("a")).on(navf);
	// 	// $(subnav).on(navf);
	// });



	// top??? ???????????? ????????? ???????????? ??????(jQuery Smooth Scroll ??????????????? ??????)
	$('a.s_point').smoothScroll();

	// ??????????????? ???????????? top????????? ???????????? ???.
	if ( $(document).scrollTop() < 50) $('.to_top').addClass('hide');
	else $('.to_top').removeClass('hide');

	// ????????? ??? ????????? ?????????
	$(window).scroll( function() {
	  if ( $(document).scrollTop() < 50) $('.to_top').addClass('hide');
	  else $('.to_top').removeClass('hide');
	});

	//????????? ?????? ??????
	$('.openMOgnb').click(function(){
		$('header').addClass('on');
		$('header .header_cont').slideDown('fast');
		$('header .header_area .header_cont .closePop').show();			
		$("body").bind('touchmove', function(e){e.preventDefault()});
	});
	$('header .header_cont .closePop').click(function(){
        $('.header_cont').slideUp('fast');
        $('header').removeClass('on');
        $("body").unbind('touchmove');
	});
	
});


$(document).ready(function(){
    // PC?????????????????? ????????? ?????? ?????? ?????? ?????? ??? ???????????? ????????????.
    $(window).resize(function() {
        if ( parseInt($('header').css('width')) > 800 ) $('.header_cont').show();
    }); 
    
    // ???????????? ?????? - ?????????/?????? ??????
	$('.program_list li .btn_more a').click(function(){
		if ($(this).parent().parent().find('.subtxt').css('display') == 'none') {
			$(this).parent().parent().find('.subtxt').css('display','inline');
			$(this).text('??????');
		} else {
			$(this).parent().parent().find('.subtxt').css('display','none');
			$(this).text('?????????');
		}
	});
   
});
