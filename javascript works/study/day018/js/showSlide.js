window.onload = function(){
    let img = document.querySelector("#container img")
    let imgArray = ["blue", "gray", "pink"];
    let imgSrcArray = new Array(imgArray.length);

    let imgStart = img.src.substring(0,img.src.indexOf("coffee-")+7);
    let imgEnd = ".jpg";
    console.log(img.src);
    console.log(imgStart);
    console.log(imgStart + imgArray[0] + imgEnd);
    console.log(imgSrcArray);
    for(let i in imgArray){
        imgSrcArray[i] = (imgStart + imgArray[i] + imgEnd);
        console.log(i);
        // console.log(imgSrcArray);
    }
    console.log(imgSrcArray);

    showSlide(img, 0, imgSrcArray);

    function showSlide(img, num, srcArray){
        img.src = srcArray[num];
        num++;
        if(srcArray.length <=num){
            num = 0;
        }
        // console.log(num);

        setTimeout(function(){showSlide(img, num, srcArray);}, 2000);
    }
}