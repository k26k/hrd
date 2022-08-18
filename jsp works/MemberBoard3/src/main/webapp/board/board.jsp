<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table text-center align-middle">
	<thead>
		<tr class="c-bg-mint c-c-white">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${ boardList }">
		<tr>
			<td><c:out value="${ board.bNum }"/></td>
			<td>
				<a href='/boardView?num=<c:out value="${ board.bNum }"/>' class="page-link">
					<c:out value="${ board.title }"/>
				</a>
			</td>
			<td><c:out value="${ board.memberID }"/></td>
			<td><c:out value="${ board.regDate }"/></td>
			<td><c:out value="${ board.views }"/></td>
			<td><c:out value="${ board.recommend }"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
