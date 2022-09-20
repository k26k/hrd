<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.username" var="authName"/>
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
<script
  src="https://code.jquery.com/jquery-3.6.1.js"
  integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function () {
		refresh();
		
		$("#replyButton").click(function() {
			console.log($("#replyText").val());
			$.ajax({
				type:"post",
				url:"/ajax/addReply",
				dataType:"json",
				data:{
					"bno": "${param.num}",
					"reply": $("#replyText").val(),
					"${ _csrf.parameterName }": "${ _csrf.token }"
				},
				success:function(data){
					console.log(data);
					if(data.result){
						refresh();
					}else{
						alert("댓글 입력 실패!");
					}
					
				},
				error:function(error){
					console.error(error);
				}
			});
		});	
		
		function refresh() {
			$.ajax({
				type:"get",
				url:"/ajax/getReply",
				dataType:"text",
				data:{
					"bno": "${param.num}"
				},
				success:function(data){
					console.log(data);
					$("#replyBox").html(data);
				},
				error:function(error){
					console.error(error);
				}
			});
		}
	});
</script>
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
							<h4>댓글</h4>
							<div id="replyBox">
								<%-- <ol class="left">
									<c:forEach var="reply" items="${ replyList }">
										<li>
											<br>
											<p>
												작성자: <c:out value="${ reply.replyer }"/>
												&nbsp;&nbsp;
												(작성일: <fmt:formatDate value="${ reply.updateDate }" pattern="yyyy-MM-dd HH:mm:ss"/>)
											</p>
											<p><c:out value="${ reply.reply }"/></p>
										</li>	
									</c:forEach>
								</ol> --%>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<form method="post" id="replyForm">
								<ul>
									<security:authorize access="isAuthenticated()">
										<li>
											<label>작성자</label>
											<input type="text" value="<security:authentication property="principal.username"/>">
										</li>
										<li>
											<textarea rows="" cols="" id="replyText"></textarea>
											<input type="button" value="댓글 등록" id="replyButton">
										</li>
									</security:authorize>
									<security:authorize access="isAnonymous()">
										<li>댓글은 로그인 후에 사용할수 있습니다</li>
									</security:authorize>
								</ul>
								<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
							</form>
						</td>
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