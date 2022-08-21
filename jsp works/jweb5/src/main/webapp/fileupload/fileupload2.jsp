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
	<form action="fileuploadprocess2.jsp" method="post" enctype="multipart/form-data" >
		<p>	이름: <input type="text" name="name1">
			제목: <input type="text" name="title1">
			파일이름: <input type="file" name="fileName1">
		</p>
		<p>	이름: <input type="text" name="name2">
			제목: <input type="text" name="title2">
			파일이름: <input type="file" name="fileName2">
		</p>
		<p>	이름: <input type="text" name="name3">
			제목: <input type="text" name="title3">
			파일이름: <input type="file" name="fileName3">
		</p>
		<p> <input type="submit" value="파일 올리기"> </p>
	</form>
</body>
</html>