<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트 search() 함수</title>
</head>
<body>
	<h2>The search() Method</h2>
	<p>search()는 정확히 일치하는 문자열의 위치(index)를 반환한다.</p>
	<p id="demo"></p>
	
	<script type="text/javascript">
		let text = "Mr. Blue has a blue house."; 
		let position1 = text.search(/blue/);
		let position2 = text.search(/blue/i);
		
		document.getElementById("demo").innerHTML +=
			"대소문자 구분한 index"+position1+
			"<br>대소문자 구분없는 index"+position2;
	</script>
</body>
</html>