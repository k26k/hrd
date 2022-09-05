<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="p"><security:authentication property="principal"/></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드리스트</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>글 목록</h1>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>
		<hr>
		<div class="max1000">
			<table>
				<thead>
					<tr class="gray">
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>가입일</th>
						<th>수정일</th>
						<th>권한</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="memberVO" items="${ memberList }" varStatus="status">
						<tr>
							<td><c:out value="${ status.count }"/></td>
							<td><c:out value="${ memberVO.userid }"/></td>
							<td><c:out value="${ memberVO.username }"/></td>
							<td><fmt:formatDate value="${ memberVO.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><fmt:formatDate value="${ memberVO.updateDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>
								<c:forEach var="memberAuthVO" items="${ memberVO.memberAuthVoList }" varStatus="status">
									<c:out value="[${memberAuthVO.auth}]"/>
								</c:forEach>
							</td>
							<td>
								<form action="/showMember" method="post">
									<input type="hidden" name="userid" value='<c:out value="${ memberVO.userid }"/>' >
									<input type="submit" value="수정">
									<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>