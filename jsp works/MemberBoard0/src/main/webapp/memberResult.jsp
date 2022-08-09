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
<title>home</title>
<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="./menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1><c:out value="${resultTexts[0]}"/></h1>
			</div>
			<div class="second_title">
				<h2><c:out value="${resultTexts[1]}"/></h2>
			</div>
			<div>
				<input type="button" value="${resultTexts[2]}" onclick="location.href='${resultTexts[3]}'" class="toButton" style="">
			</div>
		</div>
		<jsp:include page="./footer.jsp"/>
	</div>
</body>
</html>