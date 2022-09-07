<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board view</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<script type="text/javascript">

	function sendComment(text) {
		fetch("http://112.222.187.243/fetch/add?postnum=<c:out value="${post.postnum}"/>&text"+text).then(resp => {
			const respJson = resp.json();
			console.log("resp", resp, respJson);
			return respJson;
		}).then(data => {
			console.log("data",data);
			jsonCommentToHTML(data);
			//document.getElementById("comments").innerHTML=data.text;
		})
	} 
	
	function refreshComment() {
		fetch("http://112.222.187.243/fetch/add?postnum=<c:out value="${post.postnum}"/>&text"+text).then(resp => {
			const respJson = resp.json();
			console.log("resp", resp, respJson);
			return respJson;
		}).then(data => {
			console.log("data",data);
			jsonCommentToHTML(data);
			//document.getElementById("comments").innerHTML=data.text;
		})
	} 
	
	function jsonCommentToHTML( json ){
		let commentsHTML="";
		console.log(json.comments);
		for(let count in json.comments){
			let comment=json.comments[count];
			console.log(comment);
			commentsHTML+="<div class=\'input-group-text my-2\'>"+comment+"</div>";
		}
		document.getElementById("comments").innerHTML=commentsHTML;
	}
	
	window.onload = function(){
		refreshComment();
	};
	
</script>

</head>
<body style="background-color: var(--bs-gray-300);">
	<div style="background-color: var(--bs-gray-100);">
		<div class="text-center p-3">헤더</div>
	</div>
	<div class="container-lg " style="background-color: var(--bs-white);">
		<div class="text-center p-3">메인</div>
		
		<!-- ================ -->
		
		<div id="post" class="my-3 p-3">
			<div class="col-4 col-md-3 com-xl-2 m-3">
				<a href="/board/view?boardnum=${ post.boardnum }" class="btn btn-secondary p-2">목록으로</a>
			</div>
			<div class="row text-center " style="background-color: var(--bs-gray-200);">
				<div class="col-6 p-2">
					<c:out value="${ post.postnum }"/>번 게시글
				</div>
				<div class="col-6 p-2">
					<c:out value="${ post.boardnum }"/>번 게시판
				</div>
				<div class="col-12 p-2">
					제목: <c:out value="${ post.title }"/>
				</div>
				<div class="col-6 p-2">
					작성자: <c:out value="${ post.id }번"/>
				</div>
				<div class="col-6 p-2">
					<c:out value="조회수: ${ post.hitcount }"/>
				</div>
				<div class="col-12 p-2">
					작성일: <fmt:formatDate value="${ post.writedate }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</div>
				
			</div>
			<div class="row p-3" >
				<div class="col-12 mb-2 text-center">내용</div>
				<div class="col-12 text-left"><c:out value="${ post.content }"/></div>
			</div>
		</div>

		<!-- ================ -->

		<div id="comments" class="my-3 p-3" style="background-color: var(--bs-gray-100);">
		</div>

		<!-- ================ -->

		<div>
			<div class="row">
				<div class="col-md-6 col-xl-8 p-2 ">
					<input type="text" class="col-12 input-group-text" id="textbox" name="textbox">
				</div>
				<div class="col-6 col-md-3 col-xl-2 p-2 ">
					<input type="button" value="전송" class="btn btn-primary col-12" onclick="sendComment(textbox.value)">
				</div>
				<div class="col-6 col-md-3 col-xl-2 p-2">
					<input type="button" value="새로고침" class="btn btn-primary col-12" onclick="refreshComment()">
				</div>
			</div>
		</div>
	</div>
	<div  style="background-color: var(--bs-gray-100);">
		<div class="text-center p-3">푸터</div>
	</div>
</body>
</html>