
 	var wnum=0;
	var wwslidingAuto=null;
	function play_w(directw) {	
			if(directw=="right"){
				wnum++;
				if(wnum>2)wnum=0;
			}else if(directw=="left"){
				wnum--;
				if(wnum<0)wnum=2;
			}else {
				wnum = directw;
			}
			
			// 각각의 버튼이 on에서 off로 이동
			$(".rollingbtn").find('li.seq a').each(function(){
				$(".rollingbtn li.seq a img").attr('src',$(".rollingbtn li.seq a img").attr('src').replace('_on.png','_off.png'));
			});
			$(".rollingbtn li.butt"+wnum+ " a img").attr('src',$(".rollingbtn li.butt"+wnum+ " a img").attr('src').replace('_off.png','_on.png'));

			if(wnum==0) {
				$(".viewImgList li.imglist1").animate({'opacity' : 0 },500);
				$(".viewImgList li.imglist2").animate({'opacity' : 0 },500);
				$(".viewImgList li.imglist0").animate({'opacity' : 1 },500);
			}else if (wnum==1){
				$(".viewImgList li.imglist0").animate({'opacity' : 0 },500);
				$(".viewImgList li.imglist2").animate({'opacity' : 0 },500);
				$(".viewImgList li.imglist1").animate({'opacity' : 1 },500);
			}else if (wnum==2){
				$(".viewImgList li.imglist0").animate({'opacity' : 0 },500);
				$(".viewImgList li.imglist1").animate({'opacity' : 0 },500);
				$(".viewImgList li.imglist2").animate({'opacity' : 1 },500);
			}

			if(wwslidingAuto)clearTimeout(wwslidingAuto);
			wwslidingAuto=setTimeout("play_w('right')",2000);
	}
	var wwslidingAuto=setTimeout("play_w('right')",2000);

$(document).ready(function(){

	// 정지버튼 클릭하면
	$(".rollstop a").click(function(){
		// 정지버튼 사라지고
		$(this).parent().hide();
		// 재생버튼이 생기고
		$(".rollplay").css('display','inline-block');
		// 슬라이딩 콜백함수가 클리어됨
		if(wwslidingAuto)clearTimeout(wwslidingAuto);	
	});

	// 재생버튼 클릭하면
	$(".rollplay a").click(function(){
		// 재생버튼 사라지고
		$(this).parent().hide();
		// 정지버튼 생기고
		$(".rollstop").css('display','inline-block');
		// 정순으로 재생 콜백 함수 시작
		play_w('right');
	});

	// 리스트 항목을 클릭하면 해당 항목이 켜지고 재생 시작함
	$(".rollingbtn li.seq a").each(function(index){
		$(this).click(function(){
			$(".rollplay").hide();
			$(".rollstop").css('display','inline-block');
			if(wwslidingAuto)clearTimeout(wwslidingAuto);	
			play_w(index);
		});
	});

});