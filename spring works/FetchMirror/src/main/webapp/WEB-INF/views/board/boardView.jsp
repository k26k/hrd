<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body style="background-color: var(--bs-gray-300);">
	<div style="background-color: var(--bs-gray-100);">
		<div class="text-center p-3">헤더</div>
	</div>
	<div class="container-lg " style="background-color: var(--bs-white);">
		<div class="text-center p-3">메인</div>
		<a href="/board/list" class="col-12 btn btn-secondary">
			<div class="row text-center">
				<div class="col-sm-12 col-md-4 p-2" >
					<c:out value="${ board.boardnum }"></c:out>
				</div>
				<div class="col-sm-6 col-md-4 p-2" >
					<c:out value="${ board.boardname }"></c:out>
				</div>
				<div class="col-sm-6 col-md-4 p-2" >
					<c:out value="${ board.category }"></c:out>
				</div>
			</div>
		</a>
		<hr>
		<jsp:include page="/WEB-INF/views/post/postList.jsp" ></jsp:include>
	</div>
	<div  style="background-color: var(--bs-gray-100);">
		<div class="text-center p-3">푸터</div>
	</div>
</body>
</html>