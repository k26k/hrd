<%@page import="java.util.ArrayList"%>
<%@ page import="com.repository.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/colorSet.css">
</head>
<body>
	<jsp:include page="/menu.jsp"/>
	<div class="py-5 c-bg-mint">
		<div class="container">
			<h1 class="c-c-white">회원 목록</h1>
		</div>
	</div>
	<div class="container p-0">
		<a href="/logout"> <input type="button" class="btn btn-warning mt-4 ms-2" value="로그아웃"> </a>
		<div class="text-center align-middle">
			<div class="c-bg-mint c-c-white my-2">
				<div class="row m-0">
					<div class="row col-12 col-lg-6 m-0">
						<div class="col-4 p-2">아이디</div>
						<div class="col-4 p-2">비밀번호</div>
						<div class="col-4 p-2">이름</div>
					</div>
					<div class="row col-12 col-lg-6 m-0">
						<div class="col-4 p-2">성별</div>
						<div class="col-4 p-2">가입일</div>
						<div class="col-4 p-2">삭제</div>
					</div>
				</div>
			</div>
			<div class="my-2">
				<c:forEach var="member" items="${ memberList }">
					<div class="row border-bottom m-0">
						<div class="row col-12 col-lg-6 m-0">
							<div class="col-4 p-2"><c:out value="${ member.memberID }"/></div>
							<div class="col-4 p-2"><c:out value="${ member.passwd }"/></div>
							<div class="col-4 p-2"><c:out value="${ member.name }"/></div>
						</div>
						<div class="row col-12 col-lg-6 m-0">
							<div class="col-4 p-2"><c:out value="${ member.gender }"/></div>
							<div class="col-4 p-2"><c:out value="${ member.joinDate }"/></div>
							<div class="col-4 p-2">
								<form action="/deleteMember" method="post">
									<input type="hidden" name="deleteID" value="${member.memberID}">
									<input type="submit" class="btn btn-danger" value="delete">
								</form>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<%-- <table class="table mt-4 text-center align-middle">
			<thead>
				<tr class="c-bg-mint c-c-white">
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>성별</th>
					<th>가입일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${ memberList }">
				<tr>
					<td><c:out value="${member.memberID}"/></td>
					<td><c:out value="${member.passwd}"/></td>
					<td><c:out value="${member.name}"/></td>
					<td><c:out value="${member.gender}"/></td>
					<td><c:out value="${member.joinDate}"/></td>
					<td>
						<form action="/deleteMember" method="post">
							<input type="hidden" name="deleteID" value="${member.memberID}">
							<input type="submit" class="btn btn-danger" value="delete">
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table> --%>
	</div>
	<jsp:include page="/footer.jsp"/>
</body>
</html>