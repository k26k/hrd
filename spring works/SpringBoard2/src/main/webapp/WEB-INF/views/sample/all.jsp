<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<section class="main">
			<h1>all</h1>
			<hr>
			<h4>all</h4>
			<br>
			<p>principal: <security:authentication property="principal"/></p>
			<br>
			<p>
				<a href="<c:out value="/"/>">
					<input type="button" value="홈">
				</a>
				<a href="<c:out value="/customLogout"/>">
					<input type="button" value="로그아웃">
				</a>
			</p>
		</section>
	</div>
</body>
</html>