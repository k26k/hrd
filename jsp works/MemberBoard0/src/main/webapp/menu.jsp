<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main_menu">
	<nav>
		<ul>
		<c:choose>
		<c:when test="${!empty sessionScope.loginID}">
			<li><a href="/index.jsp">Home</a></li>
			<li><a href="/boardList">게시판</a></li>
			<li><a href="/logout">로그아웃</a></li>
			<li><a href="/memberView">나의 정보</a></li>
			<li><a href="/memberList">회원목록</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/home">Home</a></li>
			<li><a href="/boardList">게시판</a></li>
			<li><a href="/login">로그인</a></li>
			<li><a href="/memberForm">회원가입</a></li>
			<li><a href="/memberList">회원목록</a></li>
		</c:otherwise>
		</c:choose>
		</ul>
	</nav>
</div>