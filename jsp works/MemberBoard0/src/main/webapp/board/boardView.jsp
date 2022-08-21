<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.7">
<title>게시글 상세 보기</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="../menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>게시글 상세 보기</h1>
			</div>
			<form action="" method="post" class="board_view" name="board_view">
				<input type="hidden" name="bNum" value="${board.bNum}">
				<table>
					<colgroup>
						<col/>
						<col/>
						<col/>
						<col/>
					</colgroup>
					<tr>
						<td>제목</td>
						<td> <input type="text" name="title" value= "${board.title}" <c:if test="${!writer}">readonly</c:if>> </td>
						<td>조회수</td>
						<td><c:out value="${board.views}"/></td>
					</tr>
					<tr>
						<td>글쓴이</td>
						<td> <input type="text" value= "${name}" readonly> </td>
						<td>추천수</td>
						<td><c:out value="${board.recommend}"/></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3"> <textarea name="content" <c:if test="${!writer}">readonly</c:if>>${board.content}</textarea> </td>
					</tr>
					<tr>
						<td colspan="4">
						<c:if test="${writer}">
							<input type="button" value="수정" onclick="if(confirm('수?정')){board_view.action='/updateBoard';board_view.submit();}">
						</c:if>
						<c:if test="${writer}">
							<input type="button" value="삭제" onclick="if(confirm('삭?제')){board_view.action='/deleteBoard';board_view.submit();}">
						</c:if>
							<input type="button" value="목록" onclick="location.href='/boardList'">
							<input type="button" value="개추" onclick="board_view.action='/recommend';board_view.submit();">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>