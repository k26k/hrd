<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 처리</title>
</head>
<body>
	<c:set var="score" value="${param.score}" />
	<h2>학점: ${score}점</h2>
	<c:choose>
		<c:when test="${score>=90}">
			<h3>A학점</h3>
		</c:when>
		<c:when test="${score>=80}">
			<h3>B학점</h3>
		</c:when>
		<c:when test="${score>=70}">
			<h3>C학점</h3>
		</c:when>
		<c:when test="${score>=60}">
			<h3>D학점</h3>
		</c:when>
		<c:otherwise>
			<h3>F학점</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>