<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<c:choose>
			<c:when test="${ empty sessionId }">
				<h4><a href="" >Log-in</a></h4>
			</c:when>
			<c:otherwise>
				<h4><a href="">Log-out</a></h4>
			</c:otherwise>
		</c:choose>
		<div class="left">
			<a href="/boardList"><input type="button" value="목록"></a>
		</div>
		<form action="/loginCheck" method="post">
			<table>
				<tr>
					<td class="gray"><label for="title">아이디</label></td>
					<td><input type="text" class="max" id="title" name="title" value="<c:out value="${ board.title }"/>"></td>
				</tr>
				<tr>
					<td class="gray"><label for="title">패스워드</label></td>
					<td><input type="text" class="max" id="title" name="title" value="<c:out value="${ board.title }"/>"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>