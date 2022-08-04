<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
<script src="./resources/js/checkMember.js"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="./menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>회원 가입</h1>
			</div>
			<form action="/addMember" method="post" class="member_add_form">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="memberID"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" name="passwd"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="text" name="passwd_confirm"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>성별</td>
						<td>
							<select name="gender">
								<option>남</option>
								<option>녀</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" onclick="checkMember()" value="등록">
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