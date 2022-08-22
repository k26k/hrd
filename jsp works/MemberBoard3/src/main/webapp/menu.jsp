<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
     		<ul class="navbar-nav ms-auto">
     			<li class="nav-item border-bottom mt-2"></li>
			<c:choose>
			<c:when test="${!empty sessionScope.loginID}">
				<li class="nav-item border-bottom"><a href="/home.do" class="nav-link">Home</a></li>
				<li class="nav-item border-bottom"><a href="/boardList.do" class="nav-link">게시판</a></li>
				<li class="nav-item border-bottom"><a href="/logout.do" class="nav-link">로그아웃</a></li>
				<li class="nav-item border-bottom"><a href="/memberView.do" class="nav-link">나의 정보</a></li>
				<li class="nav-item border-bottom"><a href="/memberList.do" class="nav-link">회원목록</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item border-bottom"><a href="/home.do" class="nav-link">Home</a></li>
				<li class="nav-item border-bottom"><a href="/boardList.do" class="nav-link">게시판</a></li>
				<li class="nav-item border-bottom"><a href="/loginMemberForm.jsp" class="nav-link">로그인</a></li>
				<li class="nav-item border-bottom"><a href="/memberForm.jsp" class="nav-link">회원가입</a></li>
				<li class="nav-item border-bottom"><a href="/memberList.do" class="nav-link">회원목록</a></li>
			</c:otherwise>
			</c:choose>
			</ul>
		</div>
	</div>
</nav>