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
<title>게시판</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1>게시글 목록</h1>
		</div>
	</div>
	<div class="container">
		<div align="right">
			<a href="/wm2/boardWriteForm.do" class="btn btn-success mb-3">글쓰기</a>
		</div>
		<div>
			<table class="table table-hover">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>추천</th>
				</tr>
				<c:forEach var="board" items="${ boardList }">
					<tr>
						<td><c:out value="${ board.num }"/></td>
						<td>
							<a href="/wm2/boardview.do?num=<c:out value="${ board.num }"/>">
								<c:out value="${ board.subject }"/>
							</a>
						</td>
						<td><c:out value="${ board.name }"/></td>
						<td><c:out value="${ board.writeDate }"/></td>
						<td><c:out value="${ board.hit }"/></td>
						<td><c:out value="${ board.recommend }"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>