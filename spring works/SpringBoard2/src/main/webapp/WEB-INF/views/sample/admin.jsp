<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<section class="main">
			<h1>admin</h1>
			<hr>
			<h4>admin</h4>
			<br>
			<p>principal: <security:authentication property="principal"/></p>
			<br>
			<p>아이디: <security:authentication property="principal.username"/></p>
			<p>패스워드: <security:authentication property="principal.password"/></p>
			<br>
			<p>MemberVO: <security:authentication property="principal.memberVO"/></p>
			<br>
			<p>사용자 아이디: <security:authentication property="principal.memberVO.userid"/></p>
			<p>사용자 패스워드: <security:authentication property="principal.memberVO.userpw"/></p>
			<p>사용자 이름: <security:authentication property="principal.memberVO.username"/></p>
			<p>사용자 활성화: <security:authentication property="principal.memberVO.enabled"/></p>
<%-- 			<p>가입일: <fmt:parseDate pattern="yyyy-MM-dd HH:mm:ss" value='<security:authentication property="principal.memberVO.regDate"/>' /></p> --%>
			<p>가입일: <security:authentication property="principal.memberVO.regDate"/></p>
			<p>수정일: <security:authentication property="principal.memberVO.updateDate"/></p>
			<p>사용자 권한 리스트: <security:authentication property="principal.memberVO.memberAuthVoList"/></p>
			<br>
			<p>
				<a href="<c:out value="/"/>">
					<input type="button" value="홈">
				</a>
				<a href="<c:out value="/customLogout"/>">
					<input type="button" value="로그아웃">
				</a>
			</p>
		</section>
	</div>
</body>
</html>