<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div style="width: auto;">
	<nav class="center clear">
		<security:authorize access="isAuthenticated()">
			<p><span style="color: #e94;"><security:authentication property="principal.memberVO.username"/></span>님 안녕하세요.</p>
			<ul class="menu">
				<li><a href="/customLogout">로그아웃</a></li>
				<li><a href="/showMember">회원정보</a></li>
				<li><a href="/">홈</a></li>
				<li><a href="/boardList">게시판</a></li>
				<li><a href="/memberList">회원목록</a></li>
			</ul>
		</security:authorize>
		<security:authorize access="isAnonymous()">
			<ul class="menu">
				<li><a href="/customLogin">로그인</a></li>
				<li><a href="/addMember">회원가입</a></li>
				<li><a href="/">홈</a></li>
				<li><a href="/boardList">게시판</a></li>
				<li><a href="/memberList">회원목록</a></li>
			</ul>
		</security:authorize>
	</nav>
</div>