<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="container">
		<section class="main">
			<h1>메인 페이지 입니다.</h1>
			<hr>
			<img src="/resources/images/activity.jpg">
			<jsp:include page="/WEB-INF/views/menu.jsp"/>
			<br>
			<h4><a href="/all">ALL</a></h4>
			<h4><a href="/member">MEMBER</a></h4>
			<h4><a href="/admin">ADMIN</a></h4>
			<h4><a href="/annoMember">ANNO MEMBER</a></h4>
			<h4><a href="/annoAdmin">ANNO ADMIN</a></h4>
		</section>
	</div>
</body>
</html>