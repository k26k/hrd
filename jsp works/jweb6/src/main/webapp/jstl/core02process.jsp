<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num" value="${param.number}"/>
	<c:out value="입력값: ${num}"/><br>
	<c:if test="${num%2==0}">
		<c:out value="${num}은 짝수"/>
	</c:if>
	<c:if test="${num%2==1}">
		<c:out value="${num}은 홀수"/>
	</c:if>
</body>
</html>