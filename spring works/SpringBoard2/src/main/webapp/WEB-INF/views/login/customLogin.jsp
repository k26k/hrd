<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1><spring:message code="message.user.login.title"/></h1>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>
		<hr>
		<c:if test="${ !empty error }">
			<h4 class="error"><c:out value="${ error }"/></h4>
		</c:if>
		<c:if test="${ !empty logout }">
			<h4 class="result"><c:out value="${ logout }"/></h4>
		</c:if>
		<c:if test="${ result eq 1 }">
			<h4 class="result">회원정보 수정 성공. 다시 로그인 해주세요</h4>
		</c:if>
		<div class="max600">
			<div class="right">
			
				<a href="?language=ko"><input type="button" value='<spring:message code="message.user.login.ko"/>'></a>
				<a href="?language=en"><input type="button" value='<spring:message code="message.user.login.en"/>'></a>
			</div>
			<form action="/login" method="post">
				<table>
					<tr>
						<td class="gray"><label for="username"><spring:message code="message.user.login.id"/></label></td>
						<td><input type="text" class="max" id="username" name="username" ></td>
					</tr>
					<tr>
						<td class="gray"><label for="password"><spring:message code="message.user.login.password"/></label></td>
						<td><input type="text" class="max" id="password" name="password" ></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value='<spring:message code="message.user.login.loginbtn"/>' >
							<input type="reset" value='<spring:message code="message.user.login.resetbtn"/>' >
						</td>
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>