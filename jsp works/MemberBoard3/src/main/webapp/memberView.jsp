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
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5" style="background-color: #ddd">
		<div class="container">
			<h1>로그인</h1>
		</div>
	</div>
	<div class="container p-2">
		<form name="newProduct" action="/loginProcess" class="form-horizontal" method="post">
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
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="로그인">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"/>
	
	<div class="container">
		<jsp:include page="./menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>회원 정보</h1>
			</div>
			<form action="/updateMember" method="post" class="member_add_form">
				<table class="table_input">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="memberID" value="${member.memberID}"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" name="passwd" value="${member.passwd}"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" value="${member.name}"></td>
					</tr>
					<tr>
						<td>성별</td>
						<td>
							<label for="male">남</label>
							<input type="radio" id="male" name="gender" value="남" <c:if test="${male}">checked</c:if>>
							<label for="female">녀</label>
							<input type="radio" id="female" name="gender" value="녀" <c:if test="${!male}">checked</c:if>>
						</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td><input type="text" name="joinDate" value="${member.joinDate}" readonly></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정">
							<input type="reset" value="취소">
						</td>
					</tr>
				</table>			
			</form>
		</div>
		<jsp:include page="./footer.jsp"/>
	</div>
</body>
</html>