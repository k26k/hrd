let itemList = [];

let addBtn = document.getElementById("add");
// addBtn.onclick = addList;
addBtn.addEventListener("click", addList);
// addEventListener함수로 적용한것

// 아이템 목록 추가 함수
function addList(){
    let item = document.getElementById("item");
    if(item.value == "" ){
        alert("내용을 입력해 주세요");
    }else{
        itemList.push(item.value);
        console.log(itemList);
        item.value = "";
    }

    showList();
}

function showList(){
    let itemListId = document.getElementById("itemList")
    let list = "<ol>";
    for(let i in itemList){
        list += "<li>" +itemList[i] + "<span class='close' id=" + i + ">X</span></li>";
    }
    list += "</ol>";
    itemListId.innerHTML = list;

    let removeList = document.querySelectorAll(".close");
    console.log(removeList);
    for(let i=0; i<removeList.length; i++){
        console.log(removeList[i]);
        removeList[i].addEventListener("click", remove);
    }
}

function remove(){
    console.log(this);
    let id = this.getAttribute("id");
    console.log(id);
    itemList.splice(id,1);
    showList();
}