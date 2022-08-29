<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript">
	function checkForm() {
		for(let i of document.getElementsByTagName("form")[0].getElementsByTagName("tr")){
			let labels = i.getElementsByTagName("label")
			if(labels.length>0){
				if((i.getElementsByTagName("input").length>0 && !i.getElementsByTagName("input")[0].value)
						||(i.getElementsByTagName("textarea").length>0 && !i.getElementsByTagName("textarea")[0].value)){
					alert(labels[0].innerHTML+"을(를) 입력해주세요");
					return false
				}
			}
		}
	}
</script>
<!-- <script type="text/javascript">
	function checkForm() {
		if(!title.value){
			alert("제목을 입력해주세요");
			return false
		}
		if(!writer.value){
			alert("작성자를 입력해주세요");
			return false
		}
		if(!content.value){
			alert("내용을 입력해주세요");
			return false
		}
	}
</script> -->
</head>
<body>
	<div class="container">
		<h1>글 쓰기</h1>
		
		<c:choose>
			<c:when test="${ empty sessionId }">
				<h4><a href="login" >Log-in</a></h4>
			</c:when>
			<c:otherwise>
				<h4><a href="logout">Log-out</a></h4>
			</c:otherwise>
		</c:choose>
		<hr>
		<div class="max800">
			<div class="left">
				<a href="/boardList"><input type="button" value="목록"></a>
			</div>
			<form action=/boardInsert method="post" onsubmit="return checkForm()">
				<table>
					<tr>
						<td class="gray"><label for="title">제목</label></td>
						<td><input type="text" class="max" id="title" name="title" value="<c:out value="${ board.title }"/>"></td>
					</tr>
					<tr>
						<td class="gray"><label for="writer">작성자</label></td>
						<td><input type="text" class="max" id="writer" name="writer" value="<c:out value="${ board.title }"/>"></td>
					</tr>
					<tr>
						<td class="gray"><label for="content">내용</label></td>
						<td><textarea class="max" id="content" name="content" rows="7"><c:out value="${ board.content }"/></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
							<input type="reset" value="취소">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>