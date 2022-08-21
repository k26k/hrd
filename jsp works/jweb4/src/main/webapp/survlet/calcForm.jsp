<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h2>계산기</h2>
		<hr>
		<form action="/jweb4/calc" method="post">
			<input type="text"	name="num1" >
			<select name="op">
				<option>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</select>
			<input type="text"	name="num2" >
			<input type="submit" value="계산">
			<input type="reset"	value="다시 입력">
		</form>
	</div>
</body>
</html>