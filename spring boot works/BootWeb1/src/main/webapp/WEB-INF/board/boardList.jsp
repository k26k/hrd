<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드리스트</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<div class="container-md pt-5">
		<h2 class="text-center">게시글 목록</h2>
		<hr>
		<div class="row justify-content-center">
			<div class="col-11">
				<div class="row" style="background-color: var(--bs-gray-300)">
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
				<hr>
				<c:forEach var="board" items="${ boardList }">
					<div class="row">
						<div class="col-3 col-xxl-2 p-2 text-center"><c:out value="${ board.seq }"/></div>
						<div class="col-6 col-xxl-4 p-2 text-center"><c:out value="${ board.title }"/></div>
						<div class="col-3 col-xxl-2 p-2 text-center"><c:out value="${ board.writer }"/></div>
						<div class="col-0 col-xxl-2 "></div>
						<div class="col-6 col-xxl-2 p-2 text-center"><c:out value="${ board.createDate }"/></div>
						<div class="col-3 col-xxl-2 p-2 text-center"><c:out value="${ board.cnt }"/></div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div> 
</body>
</html>