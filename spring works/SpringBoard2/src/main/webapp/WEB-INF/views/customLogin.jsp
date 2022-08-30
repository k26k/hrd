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
		<c:if test="${ !empty error }">
			<h4 class="error"><c:out value="${ error }"/></h4>
		</c:if>
		<c:if test="${ !empty logout }">
			<h4 class="error"><c:out value="${ logout }"/></h4>
		</c:if>
		<div class="max600">
			<div class="left">
				<a href="/boardList"><input type="button" value="목록"></a>
			</div>
			<form action="/login" method="post">
				<table>
					<tr>
						<td class="gray"><label for="username">아이디</label></td>
						<td><input type="text" class="max" id="username" name="username" value="<c:out value="${ board.title }"/>"></td>
					</tr>
					<tr>
						<td class="gray"><label for="password">패스워드</label></td>
						<td><input type="text" class="max" id="password" name="password" value="<c:out value="${ board.title }"/>"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인">
							<input type="reset" value="취소">
							<a href="/register"><input type="button" value="회원가입"></a>
						</td>
					</tr>
				</table>
				
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>