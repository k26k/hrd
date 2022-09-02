<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accessError</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="container">
		<section class="main">
			<h1>accessError</h1>
			<hr>
			<h4><c:out value="${ msg }"/></h4>
			<p>
				<a href="/">
					<input type="button" value="홈으로">
				</a>
			</p>
		</section>
	</div>
</body>
</html>