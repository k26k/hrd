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
<title>게시글 작성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/colorSet.css">
<script type="text/javascript">
	function resize(obj){
		obj.style.height = "1px";
		obj.style.height = (50 + obj.scrollHeight)+"px";
	}
</script>
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5 c-bg-mint">
		<div class="container">
			<h1 class="c-c-white">게시글 작성</h1>
		</div>
	</div>
	<div class="container mt-4">
		<form action="/write" method="post" class="col-12 col-md-10 col-xl-8 col-xxl-7">
			<div class="row mx-0 mt-4">
				<label class="col-form-label col-12 col-lg-2 my-2 text-center" for="title">제목</label>
				<div class="col-12 col-lg-10 my-2">
					<input type="text" id="title" name="title" class="form-control" >
				</div>
			</div>
			<div class="row mx-0 mt-4">
				<label class="col-12 col-lg-2 my-2 pt-2 text-center" for="content">내용</label>
				<div class="col-12 col-lg-10 my-2" >
					<textarea class="form-control" id="content" name="content" style="resize: none; min-height: 250px; height: 298px;" onkeydown='resize(this)' onkeyup='resize(this)'><c:out value="${ board.content }"/></textarea>
				</div>
			</div>
			<div class="my-4 text-center">
				<input type="submit" value="글쓰기" class="btn c-c-white c-bg-mint">
				<input type="reset" value="취소" class="btn btn-secondary">
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>
