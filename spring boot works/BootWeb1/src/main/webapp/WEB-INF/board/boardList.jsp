<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드리스트</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

<script type="text/javascript">
	function mirror(){
		let url="/";
		let data="{}";
		// POST 메서드 구현 예제
		const response = fetch(url, {
			method: 'POST', // *GET, POST, PUT, DELETE 등
			mode: 'cors', // no-cors, *cors, same-origin
			cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
			credentials: 'same-origin', // include, *same-origin, omit
			headers: {
				'Content-Type': 'application/text',
				// 'Content-Type': 'application/x-www-form-urlencoded',
			},
			redirect: 'follow', // manual, *follow, error
			referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
			body: JSON.stringify(data), // body의 데이터 유형은 반드시 "Content-Type" 헤더와 일치해야 함
		});
		
		console.log(response);
		return response.json(); // JSON 응답을 네이티브 JavaScript 객체로 파싱
	}	
		
		//postData('https://example.com/answer', { answer: 42 }).then((data) => {
		//	console.log(data); // JSON 데이터가 `data.json()` 호출에 의해 파싱됨
		//}); 
</script>

</head>
<body>
	<div class="container-md pt-5">
		<h2 class="text-center">게시글 목록</h2>
		<hr>
		<div class="row justify-content-center">
			<div class="col-11">
				<!-- <div class="row" style="background-color: var(--bs-gray-300)">
					<div class="col-12 col-xl-8">
						<div class="row">
							<div class="col-3 p-2 text-center">번호</div>
							<div class="col-6 p-2 text-center">제목</div>
							<div class="col-3 p-2 text-center">작성자</div>
						</div>
					</div>
					<div class="col-12 col-xl-4">
						<div class="row justify-content-end">
							<div class="col-3 col-md-2 col-xl-4 p-2 text-center">조회수</div>
							<div class="col-6 col-md-4 col-xl-8 p-2 text-center">등록일</div>
						</div>
					</div>
				</div>
				<hr> -->
				<a href="/insertBoard" class="text-decoration-none">
					<input type="button" value="글쓰기" class="btn btn-primary">
				</a>
				<input type="button" value="fetch( ) TEST" class="btn btn-secondary" onclick="mirror()">
				<hr>
				<c:forEach var="board" items="${ boardList }">
					<a href="/boardView?seq=<c:out value="${ board.seq }"/>" class="nav-link">
						<div class="row">
							<div class="col-4 col-md-3 col-xl-2 text-center" >
								<div class="py-4">
									<c:out value="${ board.seq }"/>번 글
								</div>
							</div>
							<div class="col-8 col-md-9 col-xl-10 text-center">
								<div class="row">
									<div class="col-7 p-2 text-center"><c:out value="${ board.title }"/></div>
									<div class="col-5 p-2 text-center">작성자: <c:out value="${ board.writer }"/></div>
									<div class="col-7 p-2 text-center">작성일: <fmt:formatDate value="${ board.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></div>
									<div class="col-5 p-2 text-center">조회수: <c:out value="${ board.cnt }"/></div>
								</div>
							</div>
						</div>
					</a>
					<hr>
					
					<%-- <div class="row">
						<div class="col-3 col-xxl-2 p-2 text-center"><c:out value="${ board.seq }"/></div>
						<div class="col-6 col-xxl-4 p-2 text-center"><c:out value="${ board.title }"/></div>
						<div class="col-3 col-xxl-2 p-2 text-center"><c:out value="${ board.writer }"/></div>
						<div class="col-0 col-xxl-2 "></div>
						<div class="col-6 col-xxl-2 p-2 text-center"><c:out value="${ board.createDate }"/></div>
						<div class="col-3 col-xxl-2 p-2 text-center"><c:out value="${ board.cnt }"/></div>
					</div> --%>
				</c:forEach>
			</div>
		</div>
	</div> 
</body>
</html>