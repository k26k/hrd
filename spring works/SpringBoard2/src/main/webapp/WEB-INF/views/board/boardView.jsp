<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.Username" var="authName"/>
	<c:if test="${ authName eq board.writer }">
		<c:set var="writer" value="true"/>
	</c:if>
</security:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>글 상세 보기</h1>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>
		<hr>
		<div class="max800">
			<div class="left">
				<a href="/boardWrite"><input type="button" value="글쓰기"></a>
			</div>
			<form action="" method="post" name="boardForm">
				<input type="hidden" name="bno" value="${ board.bno }">
				<table>
					<colgroup>
						<col width="100px">
						<col>
					</colgroup>
					<tr>
						<td class="gray"><label for="title">제목</label></td>
						<td><input type="text" class="max" id="title" name="title" value="<c:out value="${ board.title }"/>" <c:if test="${ !writer }"> readonly </c:if> ></td>
					</tr>
					<tr>
						<td class="gray"><label>작성자</label></td>
						<td><input type="text" class="max" id="writer" name="writer" value="<c:out value="${ board.writer }"/>" disabled ></td>
					</tr>
					<tr>
						<td class="gray"><label for="content">내용</label></td>
						<td><textarea class="max" id="content" name="content" rows="7"  <c:if test="${ !writer }"> readonly </c:if> ><c:out value="${ board.content }"/></textarea></td>
					</tr>
					<tr>
						<td class="gray"><label>등록일</label></td>
						<td><input type="text" class="max" value="<fmt:formatDate value="${ board.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled></td>
					</tr>
					<tr>
						<td class="gray"><label>조회수</label></td>
						<td><input type="text" class="max" value="<c:out value="${ board.cnt }"/>" disabled></td>
					</tr>
					<tr>
						<td colspan="2">
							<c:if test="${ writer }">
								<input type="button" value="수정" onclick="if(confirm('수정?')){boardForm.action='/boardUpdate';boardForm.submit();}">
								<input type="button" value="삭제" onclick="if(confirm('삭제?')){boardForm.action='/boardDelete';boardForm.submit();}">
							</c:if>
							<a href="/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>