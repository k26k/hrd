<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ title }"/></title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript">${ script }</script>
</head>
<body>
	<div class="container">
		<section class="main">
			<h1><c:out value="${ title }"/></h1>
			<hr>
			<h4><c:out value="${ text }"/></h4>
			<p>
				<a href="<c:out value="${ link }"/>">
					<input type="button" value="<c:out value="${ button }"/>">
				</a>
				<a href="/">
					<input type="button" value="홈">
				</a>
			</p>
		</section>
	</div>
</body>
</html>