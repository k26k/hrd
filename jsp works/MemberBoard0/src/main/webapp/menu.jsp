<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <% Object loginID = session.getAttribute("loginID"); %> --%>
<div class="main_menu">
	<p>session empty = ${empty session.loginID}</p>
	<nav>
		<ul>
		<c:choose>
		<%-- <c:when test="${!empty loginID}"> --%>
		<c:when test="${(!empty session.loginID) eq true}">
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