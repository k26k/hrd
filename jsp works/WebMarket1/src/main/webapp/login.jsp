<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>login</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1>관리자 로그인</h1>
		</div>
	</div>
	<c:if test='${param.error eq "loginFail"}'>	
	<div class="container">
		<div class="text-center">
			<h3 class="alert alert-danger">로그인 실패</h3>
			<h5 class="alert">아이디와 비밀번호를 확인해 주세요</h5>
		</div>
	</div>
	</c:if>
	<div class="container">
		<div class="col-md-4">
			<form action="j_security_check" method="post">
				<div class="form-group">
					<label for="id" class="sr-only">USER ID</label>
					<input type="text" class="form-control" placeholder="ID" id="id" name="j_username" required autofocus>
				</div>
				<div class="form-group">
					<label for="pw" class="sr-only">PASSWARD</label>
					<input type="password" class="form-control" placeholder="PASSWARD" id="pw" name="j_passward" required>
				</div>
				<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
			</form>
		</div>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>