<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<% if(session.getAttribute("loginID")==null){response.sendRedirect("../loginMemberForm.jsp");} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="../menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>글쓰기</h1>
			</div>
			<form action="/mb1/board/writeProcess.jsp" method="post" class="write_form">
				<div>
					<input type="text" class="title" name="title">
				</div>
				<div>
					<textarea class="content" name="content"></textarea>
				</div>
				<div>
					<input type="submit" value="글쓰기">
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>