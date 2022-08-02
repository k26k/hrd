<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Java Server Page</h2>
	<p>
		<a href="?language=ko">한</a> | <a href="?language=en">en</a>
	</p>
	<c:choose>
	<c:when test="${param.language eq 'ko'}">
	<p>
		--- 기본 로케일 ---
		<fmt:setLocale value="ko"/>
		<fmt:setBundle basename="com.bundle.message"/>
	</p>
	</c:when>
	<c:when test="${param.language eq 'en'}">
	<p>
		--- 영문 로케일 ---
		<fmt:setLocale value="en"/>
		<fmt:setBundle basename="com.bundle.message_en"/>
	</p>
	</c:when>
	<c:otherwise>
	<p>
		--- 기본 로케일 ---
		<fmt:setLocale value="ko"/>
		<fmt:setBundle basename="com.bundle.message"/>
	</p>
	</c:otherwise>
	</c:choose>	
	<p>제목: <fmt:message key="title"/></p>
	<p>이름: <fmt:message key="username"/></p>
</body>
</html>