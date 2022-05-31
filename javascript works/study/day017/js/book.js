// 생성자 함수로 북 객체 만들기
function Book(title, author, price){
    this.title = title;
    this.author = author;
    this.price = price;
}

// Book객체 생성 생성시 heap(힙)메모리에 올라감
let web = new Book("반응형 웹", "조혜경", 30000);
console.log(web);
let java = new Book("혼자 공부하는 Java", "신자바", 25000);
console.log(java);
let spring = new Book("스프링 프레임워크", "spring", 30000);
console.log(spring);

// 객체 배열로 관리
let bookList = [web, java, spring];
console.log(bookList[0]);
console.log(bookList[1]);
console.log(bookList[2]);

// 자료 수정
bookList[1].author = "신용권";
console.log(bookList[1]);

// 목록, 모든 title 조회
for(let i in bookList){
    console.log(bookList[i].title);
}

// title:author list 출력
document.write("<h1>책 제목으로 살펴보기</h1>");
for(let i in bookList){
    document.write("<p>" + bookList[i].title + " : " + bookList[i].author + "</p>");
}