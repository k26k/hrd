<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드리스트</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>글 목록</h1>
		<c:choose>
			<c:when test="${ empty sessionId }">
				<h4><a href="login" >Log-in</a></h4>
			</c:when>
			<c:otherwise>
				<h4><c:out value="${ sessionId }님 환영합니다."/><a href="logout">&nbsp;&nbsp;&nbsp;Log-out</a></h4>
			</c:otherwise>
		</c:choose>
		<hr>
		<div class="max1000">
			<div class="left">
				<a href="/boardWrite"><input type="button" value="글쓰기"></a>
			</div>
			<table>
				<thead>
					<tr class="gray">
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${ boardList }">
						<tr>
							<td><c:out value="${ board.bno }"/></td>
							<td><a href="/boardView?num=${ board.bno }"><c:out value="${ board.title }"/></a></td>
							<td><c:out value="${ board.writer }"/></td>
							<td><fmt:formatDate value="${ board.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><c:out value="${ board.cnt }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>