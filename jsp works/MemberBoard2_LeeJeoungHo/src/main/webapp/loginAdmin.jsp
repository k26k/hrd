<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/colorSet.css">
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5 c-bg-mint">
		<div class="container">
			<h1 class="c-c-white">관리자 로그인</h1>
		</div>
	</div>
	<div class="container p-2">
		<form action="j_security_check" class="col-12 col-sm-11 col-md-9 col-lg-7 col-xl-6 col-xxl-5" method="post">
			<div class="row mx-0 my-2">
				<label class="col-form-label col-12 col-sm-4 my-2" for="j_username">아이디</label>
				<div class="col-12 col-sm-8 my-2">
					<input type="text" id="j_username" name="j_username" class="form-control">
				</div>
			</div>
			<div class="row mx-0 my-2">
				<label class="col-form-label col-12 col-sm-4 my-2" for="j_password">비밀번호</label>
				<div class="col-12 col-sm-8 my-2">
					<input type="text" id="j_password" name="j_password" class="form-control">
				</div>
			</div>
			<div class="row mx-0 mt-4">
				<div class="col-12 text-center">
					<input type="submit" class="btn c-bg-mint c-c-white" value="로그인">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>