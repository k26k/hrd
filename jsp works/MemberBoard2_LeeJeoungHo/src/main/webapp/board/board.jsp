<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <table class="table text-center align-middle">
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
</table> --%>
<div class="text-center align-middle">
	<div class="c-bg-mint c-c-white my-2">
		<div class="row m-0">
			<div class="row col-12 col-md-6 m-0">
				<div class="col-3 p-2">번호</div>
				<div class="col-3 p-2">작성자</div>
				<div class="col-6 p-2">제목</div>
			</div>
			<div class="row col-12 col-md-6 m-0">
				<div class="col-6 p-2">조회수</div>
				<div class="col-6 p-2">작성일</div>
			</div>
		</div>
	</div>
	<div class="my-2">
		<c:forEach var="board" items="${ boardList }">
			<div class="row border-bottom m-0">
				<div class="row col-12 col-md-6 m-0">
					<div class="col-3 p-2"><c:out value="${ board.bNum }"/></div>
					<div class="col-3 p-2"><c:out value="${ board.memberID }"/></div>
					<div class="col-6 p-2">
						<a href='/boardView?num=<c:out value="${ board.bNum }"/>' class="nav-link">
							<c:out value="${ board.title }"/>
						</a>
					</div>
				</div>
				<div class="row col-12 col-md-6 m-0">
					<div class="col-6 p-2"><c:out value="${ board.hit }"/></div>
					<div class="col-6 p-2"><c:out value="${ board.regDate }"/></div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>