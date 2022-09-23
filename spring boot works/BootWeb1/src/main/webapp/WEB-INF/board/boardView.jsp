<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<div class="container-md pt-5">
		<h2 class="text-center">게시글 보기</h2>
		<hr>
		<div class="row justify-content-center">
			<div class="col-12 col-md-11 col-xl-10">
				<a href="/boardList" class="text-decoration-none">
					<input type="button" value="글 목록" class="btn btn-secondary">
				</a>
				<hr>
				<form action="/updateBoard" method="post" class="p-3 form-control" >
					<input type="hidden" name="seq" value="<c:out value="${ board.seq }"/>">
					<p>
						<div class="row">
							<div class="col-6 col-md-7 col-xl-8 text-center">
								<c:out value="${ board.seq }"/>번 글
							</div>
							<div class="col-6 col-md-5 col-xl-4 text-center">
								<div>
									조회수: <c:out value="${ board.cnt }"/>
								</div>
								<div>
									작성일: <fmt:formatDate value="${ board.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</div>
							</div>
						</div>
					</p>
					<p>
						<div class="row">
							<div class="col-4 col-md-3 col-xl-2 text-center">
								<label for="content" class="form-label p-2">제목</label>
							</div>
							<div class="col-8 col-md-9 col-xl-10">
								<input class="form-control" id="title" name="title" value='<c:out value="${ board.title }"/>'>
							</div>
						</div>
					</p>
					<p>
						<div class="row">
							<div class="col-4 col-md-3 col-xl-2 text-center">
								<label for="content" class="form-label p-2">작성자</label>
							</div>
							<div class="col-8 col-md-9 col-xl-10">
								<input class="form-control" id="writer" name="writer" value='<c:out value="${ board.writer }"/>'>
							</div>
						</div>
					<p>
					</p>
						<div class="row">
							<div class="col-4 col-md-3 col-xl-2 text-center">
								<label for="content" class="form-label p-2">내용</label>
							</div>
							<div class="col-8 col-md-9 col-xl-10">
								<textarea rows="6" class="form-control" id="content" name="content" style="resize: none;"><c:out value="${ board.content }"/></textarea>
							</div>
						</div>
					<p>
					</p>
						<div class="row justify-content-end">
							<div class="col-10 text-end">
								<input type="submit" class="btn btn-warning" value="수정하기">
								<input type="reset" class="btn btn-secondary" value="취소">
								<a href="/deleteBoard?seq=<c:out value="${ board.seq }"/>">
									<input type="button" class="btn btn-danger" value="삭제하기">
								</a>
							</div>
						</div>
					</p>
				</form>
			</div>
		</div>
	</div> 
</body>
</html>