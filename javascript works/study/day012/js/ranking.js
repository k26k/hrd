let ranking = 3;
switch(ranking){
    case 1:
        document.write("금메달 입니다.<br>")
        break;
    
    case 2:
        document.write("은메달 입니다.<br>")
        break;
    
    case 3:
        document.write("동메달 입니다.<br>")
        break;
    
    default:
        document.write("메달이 없습니다.<br>")
        break;
}

if(ranking == 1){
    document.write("금메달 입니다.<br>")
}else if(ranking == 2){
    document.write("은메달 입니다.<br>")
}else if(ranking == 3){
    document.write("동메달 입니다.<br>")
}else{
    document.write("메달이 없습니다.<br>")
}