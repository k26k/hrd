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
<title>회원 목록</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="/menu.jsp"/>
		<div class="contents">
			<div style="margin: 30px 0 30px 10%;"><input type="button" value="글쓰기" onclick="location.href='/writeForm'" ></div>
			<table class="table_list">
				<tr>
					<th>bNum</th>
					<th>title</th>
					<th>date</th>
					<th>memberID</th>
					<!-- <th>delete</th> -->
				</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td><c:out value="${board.bNum}"/></td>
					<td><a href="/boardView?num=${board.bNum}"><c:out value="${board.title}"/></a></td>
					<td><c:out value="${board.regDate}"/></td>
					<td><c:out value="${board.memberID}"/></td>
					<%-- <td>
						<form action="./memberDelete.jsp" method="post">
							<input type="hidden" name="deleteID" value="${board.bNum}">
							<input type="submit" value="delete">
						</form>
					</td> --%>
				</tr>
			</c:forEach>
			</table>
		</div>
		<jsp:include page="/footer.jsp"/>
	</div>
</body>
</html>