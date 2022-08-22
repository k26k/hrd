<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mx-4">
	<nav class="navbar navbar-expand navbar-light justify-content-end">
		<div class="">
			<ul class="navbar-nav mr-auto">
			<c:choose>
			<c:when test="${!empty sessionScope.loginID}">
				<li class="nav-item"><a href="/index.jsp" class="nav-link">Home</a></li>
				<li class="nav-item"><a href="/boardList" class="nav-link">게시판</a></li>
				<li class="nav-item"><a href="/logout" class="nav-link">로그아웃</a></li>
				<li class="nav-item"><a href="/memberView" class="nav-link">나의 정보</a></li>
				<li class="nav-item"><a href="/memberList" class="nav-link">회원목록</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item"><a href="/home" class="nav-link">Home</a></li>
				<li class="nav-item"><a href="/boardList" class="nav-link">게시판</a></li>
				<li class="nav-item"><a href="/login" class="nav-link">로그인</a></li>
				<li class="nav-item"><a href="/memberForm" class="nav-link">회원가입</a></li>
				<li class="nav-item"><a href="/memberList" class="nav-link">회원목록</a></li>
			</c:otherwise>
			</c:choose>
			</ul>
		</div>
	</nav>
</div>