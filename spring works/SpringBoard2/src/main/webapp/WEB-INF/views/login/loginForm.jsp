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
		<hr>
		<c:if test="${ param.error == 1 }">
			<h4 class="error">아이디나 비밀번호를 확인해 주세요</h4>
		</c:if>
		<div class="max600">
			<div class="left">
				<a href="/boardList"><input type="button" value="목록"></a>
			</div>
			<form action="/loginProcess" method="post">
				<table>
					<tr>
						<td class="gray"><label for="id">아이디</label></td>
						<td><input type="text" class="max" id="id" name="id" value="<c:out value="${ board.title }"/>"></td>
					</tr>
					<tr>
						<td class="gray"><label for="passwd">패스워드</label></td>
						<td><input type="text" class="max" id="passwd" name="passwd" value="<c:out value="${ board.title }"/>"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인">
							<input type="reset" value="취소">
							<a href="/register"><input type="button" value="회원가입"></a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>