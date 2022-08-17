<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>로그인</title>
<script type="text/javascript">
	function checkLoginMember(){
		loginMember.submit();
	}
</script>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	<c:choose>
		<c:when test='${ param.error eq "error" }'>
			<div class="container">
				<h3 class="alert alert-danger center">error</h3>
			</div>
		</c:when>
		<c:when test='${ param.error eq "loginNone" }'>
			<div class="container">
				<h3 class="alert alert-danger center">아이디와 비밀번호가 일치하지않습니다.</h3>
			</div>
		</c:when>
	</c:choose>
	<div class="container">
		<form name="loginMember" action="/wm2/member/processLoginMember.jsp" class="form-horizontal" method="post">
			<div class="form-group row">
				<label class="col-sm-2" for="id">아이디</label>
				<div class="col-sm-3">
					<input type="text" id="id" name="id" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="password">비밀번호</label>
				<div class="col-sm-3">
					<input type="text" id="password" name="password" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-primary" value="가입" onclick="checkLoginMember()">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>