<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="checkboxProcess.jsp" method="post">
		<p>
			<label for="fruit">좋아하는 과일 선택</label><br>
			<label for="orange">오렌지</label> <input type="checkbox" id="orange" name="fruit" value="Orange"> <br>
			<label for="Apple">사과</label> <input type="checkbox" id="Apple" name="fruit" value="Apple"> <br>
			<label for="Banana">바나나</label> <input type="checkbox" id="Banana" name="fruit" value="Banana"> <br>
			<input type="submit" value="선택"> <br>
		</p>
	</form>
</body>
</html>