<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript">
	window.onload=function(){logout.submit();};
</script>
</head>
<body>
	<div class="container">
		<h1>로그아웃</h1>
		<hr>
		<c:if test="${ !empty error }">
			<h4 class="error"><c:out value="${ error }"/></h4>
		</c:if>
		<c:if test="${ !empty logout }">
			<h4 class="error"><c:out value="${ logout }"/></h4>
		</c:if>
		<div class="max600">
			<div class="left">
				<a href="/boardList"><input type="button" value="목록"></a>
			</div>
			<form action="/custumLogout" method="post" name="logout">
				<table>
					<tr>
						<td>
							<input type="submit" value="로그아웃">
						</td>
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>