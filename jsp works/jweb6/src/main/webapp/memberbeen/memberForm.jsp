<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 등록</title>
<link rel="stylesheet" type="text/css" href="css/member.css">
<script type="text/javascript">
	function sub01() {
		document.formm.action="./member01.jsp";
		formm.submit();
	}
	function sub01el() {
		document.formm.action="./member01el.jsp";
		formm.submit();
	}
	function sub02() {
		document.formm.action="./member02.jsp";
		formm.submit();
	}
	function sub02el() {
		document.formm.action="./member02el.jsp";
		formm.submit();
	}
</script>
</head>
<body>
	<div id="container">
		<h2>회원가입</h2>
		<hr>
		<form action="./member01.jsp" method="post" name="formm">
			<table id="tbl">
				<tr>
					<td> <label for="userid" >아이디</label> </td>
					<td> <input type="text" id="userid" name="userid" maxlength=20 size=20 required > </td>
				</tr>
				<tr>
					<td> <label for="userpw" >패스워드</label> </td>
					<td> <input type="text" id="userpw" name="userpw" maxlength=20 size=20 required > </td>
				</tr>
				<tr>
					<td> <label for="username" >이름</label> </td>
					<td> <input type="text" id="username" name="username" maxlength=20 size=20 required > </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" onclick="sub01()" value="sub01" >
						<input type="button" onclick="sub01el()" value="sub01el" >
						<input type="button" onclick="sub02()" value="sub02" >
						<input type="button" onclick="sub02el()" value="sub02el" >
						<input type="reset" value="취소" >
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>