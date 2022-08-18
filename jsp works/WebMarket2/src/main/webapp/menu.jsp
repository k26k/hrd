<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/wm2/index.jsp">home</a>
		</div>
		<div class="row">
			<ul class="navbar-nav mr-auto">
			<c:choose>
			<c:when test="${ empty sessionId }">
				<li class="nav-item"><a href="/wm2/member/loginMember.jsp" class="nav-link">로그인</a></li>
				<li class="nav-item"><a href="/wm2/member/addMember.jsp" class="nav-link">회원 가입</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item"><a class="nav-link text-light"><c:out value="[${ sessionId } 님]"/></a></li>
				<li class="nav-item"><a href="/wm2/member/logoutMember.jsp" class="nav-link">로그아웃</a></li>
				<li class="nav-item"><a href="/wm2/member/updateMember.jsp" class="nav-link">회원 수정</a></li>
			</c:otherwise>
			</c:choose>
				<li class="nav-item"><a href="/wm2/products.jsp" class="nav-link">상품 목록</a></li>
				<li class="nav-item"><a href="/wm2/addProduct.jsp" class="nav-link">상품 등록</a></li>
				<li class="nav-item"><a href="/wm2/editProduct.jsp?edit=update" class="nav-link">상품 수정</a></li>
				<li class="nav-item"><a href="/wm2/editProduct.jsp?edit=delete" class="nav-link">상품 삭제</a></li>
				<li class="nav-item"><a href="/wm2/boardList.do" class="nav-link">게시글 보기</a></li>
			</ul>
		</div>
	</div>
</nav>