<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 상세 보기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/colorSet.css">
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5 c-bg-mint">
		<div class="container">
			<h1 class="c-c-white">게시글 상세 보기</h1>
		</div>
	</div>
	<div class="container">
		<form action="" method="post" class="board_view" name="board_view">
			<input type="hidden" name="bNum" value="${board.bNum}">
			<div class="form-group row my-2 col-sm-">
				<label class="col-sm-2" for="title">제목</label>
				<div class="col-sm-3">
					<input type="text" id="title" name="title" class="form-control" value= "${board.title}" <c:if test="${!writer}">readonly</c:if>>
				</div>
			</div>
			<div class="form-group row my-2">
				<label class="col-sm-2" for="name">글쓴이</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control" value= "${name}" <c:if test="${!writer}">readonly</c:if>>
				</div>
			</div>
			<div class="form-group row my-2">
				<div>조회수</div>
				<div><c:out value="${board.views}"/></div>
			</div>
			<div class="form-group row my-2">
				<div>추천수</div>
				<div><c:out value="${board.recommend}"/></div>
			</div>
			<div class="form-group row my-2">
				<label class="col-sm-2" for="name">글쓴이</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control" value= "${name}" <c:if test="${!writer}">readonly</c:if>>
				</div>
			</div>
			<div class="form-group row my-2">
			<c:if test="${writer}">
				<input type="button" value="수정" onclick="if(confirm('수?정')){board_view.action='/updateBoard';board_view.submit();}">
			</c:if>
			<c:if test="${writer}">
				<input type="button" value="삭제" onclick="if(confirm('삭?제')){board_view.action='/deleteBoard';board_view.submit();}">
			</c:if>
				<input type="button" value="목록" onclick="location.href='/boardList'">
				<input type="button" value="개추" onclick="board_view.action='/recommend';board_view.submit();">
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>