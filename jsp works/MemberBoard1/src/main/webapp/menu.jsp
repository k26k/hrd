<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% Object loginID = session.getAttribute("loginID"); %>
<div class="main_menu">
	<nav>
		<ul>
			<li><a href="./index.jsp">Home</a></li>
			<li><a href="#">게시판</a></li>
			<c:choose>
				<c:when test="${!empty loginID}">
					<li><a href="./logout.jsp">로그아웃</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="./loginMemberForm.jsp">로그인</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="./memberForm.jsp">회원가입</a></li>
			<li><a href="./memberList.jsp">회원목록</a></li>
		</ul>
	</nav>
</div>