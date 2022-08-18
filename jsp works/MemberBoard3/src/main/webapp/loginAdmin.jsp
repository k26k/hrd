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
<title>관리자 로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
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
		<form action="j_security_check" class="form-horizontal" method="post">
			<div class="form-group row my-2">
				<label class="col-sm-2" for="j_username">아이디</label>
				<div class="col-sm-3">
					<input type="text" id="j_username" name="j_username" class="form-control">
				</div>
			</div>
			<div class="form-group row my-2">
				<label class="col-sm-2" for="j_password">비밀번호</label>
				<div class="col-sm-3">
					<input type="text" id="j_password" name="j_password" class="form-control">
				</div>
			</div>
			<div class="form-group row my-2">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn c-bg-mint c-c-white" value="로그인">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>