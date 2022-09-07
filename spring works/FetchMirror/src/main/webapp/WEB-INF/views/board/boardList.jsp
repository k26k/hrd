<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body style="background-color: var(--bs-gray-300);">
	<div style="background-color: var(--bs-gray-100);">
		<div class="text-center p-3">헤더</div>
	</div>
	<div class="container-lg " style="background-color: var(--bs-white);">
		<div class="text-center p-3">메인</div>
		<div>
			<div class="row">
				<c:forEach var="board" items="${ boardList }">
					<div class="col-sm-6 col-md-4 col-xl-3 p-2">
						<a href="/board/view?boardnum=${ board.boardnum }" class="btn btn-secondary col-12">
							<c:out value="${ board.boardname }"/>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div  style="background-color: var(--bs-gray-100);">
		<div class="text-center p-3">푸터</div>
	</div>
</body>
</html>