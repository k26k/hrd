window.onload = function(){
    let check = document.querySelector("#shippingInfo");
    
    check.addEventListener("click", checkBox);

    function checkBox(){
        if(check.checked == true){
            console.log(true);
            shippingName.value = billingName.value;
            shippingTel.value = billingTel.value;
            shippingAddr.value = billingAddr.value;
        }else{
            console.log(false);
            shippingName.value = "";
            shippingTel.value = "";
            shippingAddr.value = "";
        }
    }
}


