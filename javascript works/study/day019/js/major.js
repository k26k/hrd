// let selectMenu = document.testForm.major;

function displaySelect(){
    // select option 속성의 value로 선택 - archi
    // let selectText = document.getElementById("major").value;
    // alert(selectText);
    // value 값이 출력 됨

    // 태그의 text부분이 출력됨 - 건축학과
    let selectMenu = document.testForm.major;
    console.log(selectMenu);
    console.log(selectMenu.selectedIndex);
    let selectText = selectMenu.options[selectMenu.selectedIndex].innerText;
    alert(selectText);
    // option 태그 안의 text가 출력됨
}