<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.7">
<title>회원 가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="./resources/js/checkMember.js"></script>
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5" style="background-color: #ddd">
		<div class="container">
			<h1>회원 가입</h1>
		</div>
	</div>
	<div class="container p-2">
		<form action="/addMember" class="form-horizontal member_add_form" method="post">
			<div class="form-group row my-2">
				<label class="col-sm-2" for="memberID">아이디</label>
				<div class="col-sm-3">
					<input type="text" id="memberID" name="memberID" class="form-control">
				</div>
			</div>
			<div class="form-group row my-2">
				<label class="col-sm-2" for="passwd">비밀번호</label>
				<div class="col-sm-3">
					<input type="text" id="passwd" name="passwd" class="form-control">
				</div>
			</div>
			<div class="form-group row my-2">
				<label class="col-sm-2" for="passwd_confirm">비밀번호 확인</label>
				<div class="col-sm-3">
					<input type="text" id="passwd_confirm" name="passwd_confirm" class="form-control">
				</div>
			</div>
			<div class="form-group row my-2">
				<label class="col-sm-2" for="name">이름</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control">
				</div>
			</div>
			<div class="form-group row my-2">
				<label class="col-sm-2" for="gender">성별</label>
				<div class="col-sm-2">
					<select name="gender" class="form-control text-center">
						<option>남</option>
						<option>녀</option>
					</select>
				</div>
			</div>
			<div class="form-group row my-2">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" onclick="checkMember()" class="btn btn-primary" value="회원가입">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>