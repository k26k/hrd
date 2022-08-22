<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>게시글</title>
<script type="text/javascript">
	function checkForm(){
		if(!subject.value){
			alert("제목을 입력해주세요");
			return false;
		}
		if(!content.value){
			alert("내용을 입력해주세요");
			return false;
		}
		return true;
	}
	
	function resize(obj){
		obj.style.height = obj.scrollHeight-20+"px";
	}
</script>
</head>
<body>
	
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1>게시글</h1>
		</div>
	</div>
	<div class="container">
		<form name="updateWrite" action="/wm2/boardUpdateAction.do" class="form-horizontal" method="post" onsubmit="return checkForm()">
			<input type="hidden" name="num" value="${ board.num }">
			<div class="form-group row">
				<label class="col-sm-2" for="name">성명</label>
				<div class="col-sm-7">
					<input type="text" id="name" name="name" class="form-control bg-light" value="${ board.name }" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="subject">제목</label>
				<div class="col-sm-7">
					<input type="text" id="subject" name="subject" class="form-control bg-light" value="${ board.subject }" <c:if test="${ sessionId ne board.id }">readonly</c:if>>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="content">내용</label>
				<div class="col-sm-7" >
					<textarea class="form-control bg-light pb-5" id="content" name="content" style="resize: none; min-height: 300px; height: 300px; overflow-y: hidden;" <c:choose><c:when test="${ sessionId ne board.id }">readonly</c:when> <c:otherwise>onkeydown='resize(this)' onkeyup='resize(this)'</c:otherwise></c:choose>><c:out value="${ board.content }"/></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<c:if test="${ sessionId eq board.id }">
						<input type="submit" class="btn btn-primary" value="수정">
						<input type="reset" class="btn btn-warning" value="취소">
					</c:if>
					<a href="/wm2/boardList.do"><input type="button" class="btn btn-secondary" value="목록"></a>
					<c:if test="${ sessionId eq board.id }">
						<a href="/wm2/boardDeleteAction.do?num=${ board.num }" onclick="return confirm('삭제?')" class="btn btn-danger" >삭제</a>
					</c:if>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/footer.jsp" %>
</body>
</html>