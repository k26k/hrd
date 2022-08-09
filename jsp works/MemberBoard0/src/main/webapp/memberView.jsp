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
<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
</head>
<body>
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