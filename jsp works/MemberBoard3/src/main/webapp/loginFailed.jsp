<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.7">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>login failed</title>
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5" style="background-color: #ddd">
		<div class="container">
			<h1>관리자 로그인</h1>
		</div>
	</div>
	<div class="container p-2">
		<a href="/home">
			<input type="button" class="btn btn-secondary" value="메인화면으로 가기">
		</a>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>