<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 리스트</title>
<style type="text/css">
	.list {width: 80%; padding: 0 10px 10px 10px; margin: 0 auto;}
	.list li {list-style: none; border-bottom: 1px solid #ccc; line-height: 120px; position: relative;}
	.list .title {line-height: 80px}
	.list li span {margin-left: 340px; color: blue; font-size: 14px;}
	.list a {margin-left: 340px; text-decoration: none;}
	.list img {float: left; margin: 10px; position: absolute;}
	.list .title {border}
	
</style>
</head>
<body>
	<ul class="list">
		<li class="title">
			<span style="margin-left: 50px;">이미지</span>
			<span>이미지 이름</span>
			<span>선택하기</span>
		</li>
		<c:forEach var="i" begin="1" end="5">
		<li>
			<a href="#" style="margin-left: 50px;">
				<img alt="" src="../resources/bear.jpg" width="100px" height="100px">
			</a>
			<a href="#">
				<strong>이름: 곰인형${i}</strong>
			</a>
			<a href="#">
				<input type="checkbox" name="chk${i}">
			</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>