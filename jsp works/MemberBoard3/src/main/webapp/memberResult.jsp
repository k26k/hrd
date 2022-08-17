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
<title>result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="pt-5 pb-2" style="background-color: #ddd">
		<div class="container">
			<h1><c:out value="${resultTexts[0]}"/></h1>
			
		</div>
		<div class="container mt-5 p-3 rounded" style="background-color: #faa;">
			<h2><c:out value="${resultTexts[1]}"/></h2>
		</div>
	</div>
	<div class="py-3 bg " style="background-color: #ddd">
		
	</div>
	<div class="container p-2">
		
		<a href="${resultTexts[3]}">
			<input type="button" value="${resultTexts[2]}" class="btn btn-primary">
		</a>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>