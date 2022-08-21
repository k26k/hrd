<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload by MultipartRequest</title>
</head>
<body>
	<!-- 파일 업로드시 form에 enctype="multipart/form-data" 명시 필수 -->
	<form action="fileuploadprocess.jsp" method="post" enctype="multipart/form-data" >
		<p>이름: <input type="text" name="name"> </p>
		<p>제목: <input type="text" name="title"> </p>
		<p>파일이름: <input type="file" name="fileName"> </p>
		<p> <input type="submit" value="파일 올리기"> </p>
	</form>
</body>
</html>