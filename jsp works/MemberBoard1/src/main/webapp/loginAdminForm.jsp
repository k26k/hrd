<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="./menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>관리자 로그인</h1>
			</div>
			<form action="j_security_check" method="post">
				<table class="table_input">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="j_username"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="j_password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인">
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