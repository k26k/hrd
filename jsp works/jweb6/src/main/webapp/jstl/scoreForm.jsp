<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		let form = document.scoreForm;
		let value = form.score.value;
		if(value===""){
			alert("점수를 입력해 주세요.");
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<h2>점수를 입력해 주세요.</h2>
	<form action="./scoreTest.jsp" name="scoreForm">
		<p>
			점수: <input type="number" name="score">
			<input type="button" value="전송" onclick="check()" >
		</p>
	</form>
</body>
</html>