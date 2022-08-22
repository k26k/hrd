<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/colorSet.css">
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5 c-bg-mint">
		<div class="container">
			<h1 class="c-c-white">게시판</h1>
		</div>
	</div>
	<div class="container p-0 my-3">
		<input type="button" value="글쓰기" onclick="location.href='/writeForm.do'" class="btn c-bg-mint c-c-white my-4 ms-2" >
		<jsp:include page="/board/board.jsp"/>
		<div class="text-center align-middle">
			<div class="my-2">
				<c:choose>
					<c:when test="${ page eq 1 }">
						<a class="btn btn-secondary m-1" >&lt;&lt;</a>
					</c:when>
					<c:otherwise>
						<a class="btn c-c-white c-bg-mint m-1" href=/boardList.do?page=<c:out value="${ 1 }"/>>&lt;&lt;</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ page eq 1 }">
						<a class="btn btn-secondary m-1" >previous</a>
					</c:when>
					<c:otherwise>
						<a class="btn c-c-white c-bg-mint m-1" href=/boardList.do?page=<c:out value="${ page-1 }"/>>previous</a>
					</c:otherwise>
				</c:choose>
				<c:forEach var="num" begin="1" end="${ size }">
					<c:choose>
						<c:when test="${ page eq num }">
							<a class="btn btn-secondary m-1"><c:out value="${ num }"/></a>
						</c:when>
						<c:otherwise>
							<a class="btn c-c-white c-bg-mint m-1" href=/boardList.do?page=<c:out value="${ num }"/>><c:out value="${ num }"/></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${ page eq size }">
						<a class="btn btn-secondary m-1" >next</a>
					</c:when>
					<c:otherwise>
						<a class="btn c-c-white c-bg-mint m-1" href=/boardList.do?page=<c:out value="${ page+1 }"/>>next</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ page eq size }">
						<a class="btn btn-secondary m-1" >&gt;&gt;</a>
					</c:when>
					<c:otherwise>
						<a class="btn c-c-white c-bg-mint m-1" href=/boardList.do?page=<c:out value="${ size }"/>>&gt;&gt;</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>