<%@page import="java.util.ArrayList"%>
<%@ page import="com.repository.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="/menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>글쓰기</h1>
			</div>
			<form action="/write">
				<div>
					<input type="text" value="title">
					<hr>
					<input type="text" size="500" value="content">
				</div>
				<div>
					<input type="button" value="글쓰기">
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
		<jsp:include page="/footer.jsp"/>
	</div>
</body>
</html>