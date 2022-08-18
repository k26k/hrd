<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>결과</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<c:choose>
		<c:when test='${ param.msg eq "addSuccess"}'>
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-3">회원가입</h1>
				</div>
			</div>
			<div class="container">
				<h3 class="alert alert-danger" >회원가입을 축하합니다.</h3>
			</div>
		</c:when>
		
		<c:when test='${ param.msg eq "loginSuccess"}'>
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-3">로그인</h1>
				</div>
			</div>
			<div class="container">
				<h3 class="alert alert-danger">로그인 성공</h3>
			</div>
		</c:when>
		
		<c:when test='${ param.msg eq "updateSuccess"}'>
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-3">회원정보</h1>
				</div>
			</div>
			<div class="container">
				<h3 class="alert alert-danger">수정 성공</h3>
			</div>
		</c:when>
		
		<c:when test='${ param.msg eq "deleteSuccess"}'>
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-3">회원삭제</h1>
				</div>
			</div>
			<div class="container">
				<h3 class="alert alert-danger">삭제 성공</h3>
			</div>
		</c:when>
		
		<c:otherwise>
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-3">error</h1>
				</div>
			</div>
			<div class="container">
				<h3 class="alert alert-danger" align="center">error</h3>
			</div>
		</c:otherwise>
	</c:choose>
	<%@ include file="/footer.jsp" %>
</body>

</html>