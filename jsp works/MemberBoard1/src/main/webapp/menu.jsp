<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% Object loginID = session.getAttribute("loginID"); %>
<div class="main_menu">
	<nav>
		<ul>
		<c:choose>
		<c:when test="${!empty loginID}">
			<li><a href="/mb1/index.jsp">Home</a></li>
			<li><a href="/mb1/board/boardList.jsp">게시판</a></li>
			<li><a href="/mb1/logout.jsp">로그아웃</a></li>
			<li><a href="/mb1/memberView.jsp">나의 정보</a></li>
			<li><a href="/mb1/memberList.jsp">회원목록</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/mb1/index.jsp">Home</a></li>
			<li><a href="/mb1/board/boardList.jsp">게시판</a></li>
			<li><a href="/mb1/loginMemberForm.jsp">로그인</a></li>
			<li><a href="/mb1/memberForm.jsp">회원가입</a></li>
			<li><a href="/mb1/memberList.jsp">회원목록</a></li>
		</c:otherwise>
		</c:choose>
		</ul>
	</nav>
</div>