<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postList</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body style="background-color: var(--bs-gray-300);">
	<div style="background-color: var(--bs-gray-100);">
		<div>헤더</div>
	</div>
	<div class="container-lg " style="background-color: var(--bs-white);"> -->
		<!-- <div>메인</div> -->
		<div>
			<div class="row">
				<c:forEach var="post" items="${ postList }">
					<div class="col-sm-6 col-md-4 col-xl-3 p-2">
						<a href="/post/view?boardnum=${post.boardnum}&postnum=${post.postnum}" class="btn btn-secondary col-12 py-3">
							<c:out value="${ post.title }"/>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
<!-- 	</div>
	<div  style="background-color: var(--bs-gray-100);">
		<div>푸터</div>
	</div>
</body>
</html> -->