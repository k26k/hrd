let classification = prompt("아동, 청소년, 성인 중 선택 입력", "성인");
switch(classification){
    case "아동":
        classification += " 입장료 무료.";
        break;
    case "청소년":
        classification += " 입장료 2,000원.";
        break;
    case "성인":
        classification += " 입장료 5,000원.";
        break;
    case null:
        classification = "입력하지 않으셨습니다. 입력해주세요.";
        break;
    default:
        classification = "\"" + classification + "\"으로 입력하셨습니다. 확인 후 다시 입력해 주세요.";
        break;
}
document.write(classification);