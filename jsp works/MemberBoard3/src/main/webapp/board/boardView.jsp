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
<script type="text/javascript">
	window.onload=function(){resize(content);}
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
			<h1 class="c-c-white">게시글 상세 보기</h1>
		</div>
	</div>
	<div class="container mt-4">
		<form action="" method="post" class="board_view col-12 col-md-10 col-xl-8 col-xxl-7 text-center" name="board_view">
			<input type="hidden" name="bNum" value="${board.bNum}">
			<div class="row mx-0">
				<label class="col-4 col-lg-2 my-2 col-form-label" for="title">제목</label>
				<div class="col-8 col-lg-10 my-2">
					<input type="text" id="title" name="title" class="form-control text-center" value= "${board.title}" <c:if test="${!writer}">readonly</c:if>>
				</div>
			</div>
			<div class="row mx-0">
				<div class="row mx-0 col-lg-6 p-0">
					<label class="col-4 my-2 col-form-label" for="name">글쓴이</label>
					<div class="col-8 my-2">
						<input type="text" id="name" name="name" class="form-control text-center" value= "${name}" <c:if test="${!writer}">readonly</c:if>>
					</div>
				</div>
				<div class="row mx-0 col-lg-6 p-0 ">
					<div class="col-4 my-2 col-form-label">조회수</div>
					<div class="col-8 my-2"><c:out value="${board.hit}"/></div>
				</div>
			</div>
			<div class="row mx-0 mt-4">
				<label class="col-12 col-lg-2 my-2 pt-2" for="content">내용</label>
				<div class="col-12 col-lg-10 my-2" >
					<textarea class="form-control" id="content" name="content" style="resize: none; min-height: 250px; height: 298px;" <c:choose><c:when test="${!writer}">readonly</c:when> <c:otherwise>onkeydown='resize(this)' onkeyup='resize(this)'</c:otherwise></c:choose>><c:out value="${ board.content }"/></textarea>
				</div>
			</div>
			<div class="my-4 text-center">
			<c:choose>
			<c:when test="${writer}">
				<input type="button" value="수정" class="btn btn-warning" onclick="if(confirm('수정?')){board_view.action='/updateBoard.do';board_view.submit();}">
				<input type="button" value="삭제" class="btn btn-danger" onclick="if(confirm('삭제?')){board_view.action='/deleteBoard.do';board_view.submit();}">
				<input type="button" value="목록" class="btn btn-secondary" onclick="location.href='/boardList.do'">
			</c:when>
			<c:otherwise>
				<input type="button" value="목록" class="btn btn-secondary" onclick="location.href='/boardList.do'">
			</c:otherwise>
			</c:choose>
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>