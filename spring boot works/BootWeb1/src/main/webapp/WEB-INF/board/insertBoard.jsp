<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<div class="container-md pt-5">
		<h2 class="text-center">게시글 추가</h2>
		<hr>
		<div class="row justify-content-center">
			<div class="col-12 col-md-11 col-xl-10">
				<br>
				<form action="/insertBoard" method="post" class="p-3 form-control" >
					<p>
						<div class="row">
							<div class="col-4 col-md-3 col-xl-2 text-center">
								<label for="content" class="form-label p-2">제목</label>
							</div>
							<div class="col-8 col-md-9 col-xl-10">
								<input class="form-control" id="title" name="title">
							</div>
						</div>
					</p>
					<p>
						<div class="row">
							<div class="col-4 col-md-3 col-xl-2 text-center">
								<label for="content" class="form-label p-2">작성자</label>
							</div>
							<div class="col-8 col-md-9 col-xl-10">
								<input class="form-control" id="writer" name="writer">
							</div>
						</div>
					<p>
					</p>
						<div class="row">
							<div class="col-4 col-md-3 col-xl-2 text-center">
								<label for="content" class="form-label p-2">내용</label>
							</div>
							<div class="col-8 col-md-9 col-xl-10">
								<textarea rows="6" class="form-control" id="content" name="content" style="resize: none;"></textarea>
							</div>
						</div>
					<p>
					</p>
						<div class="row justify-content-end">
							<div class="col-10 text-end">
								<input type="submit" class="btn btn-primary" value="글쓰기">
							</div>
						</div>
					</p>
				</form>
			</div>
		</div>
	</div> 
</body>
</html>