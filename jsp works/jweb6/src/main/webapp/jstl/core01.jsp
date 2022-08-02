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
	<c:set var="num" value="10" /> <!-- 변수 선언 -->
	<c:if test="${num%2==0}">
		<%-- ${num}은 짝수 입니다. --%>
		<c:out value="${num}은 짝수 입니다"/>
	</c:if>
	<c:if test="${num%2==1}">
		<%-- ${num}은 홀수 입니다. --%>
		<c:out value="${num}은 홀수 입니다"/>
	</c:if>
</body>
</html>