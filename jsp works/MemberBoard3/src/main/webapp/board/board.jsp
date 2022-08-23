<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
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
						<a href='/boardView.do?num=<c:out value="${ board.bNum }"/>' class="nav-link" style="font-weight: bold;">
							<c:out value="${ board.title }"/>
						</a>
					</div>
				</div>
				<div class="row col-12 col-md-6 m-0">
					<div class="col-6 p-2"><c:out value="${ board.hit }"/></div>
					<div class="col-6 p-2"><fmt:formatDate value="${ board.regDate }" pattern="yyyy-MM-dd hh:mm:ss"/></div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>