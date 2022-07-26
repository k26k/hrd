<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.5">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="./resources/addr.css">
</head>
<body>
	<div id="container">
		<h2>로그인</h2>
		<hr>
		<form action="./loginProcess.jsp" method="post">
			<table id="tbl_login">
				<tr>
					<td> <label for="email" >이메일</label> </td>
					<td> <input type="text" id="email" name="email" maxlength=20 size=20 required > </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" >
						<input type="reset" value="취소" >
					</td>
				</tr>
			</table>
		</form>
		<p><a href="./addrForm.jsp">[주소록 등록]</a></p>
		<p><a href="addrList.jsp">[목록 보기]</a></p>
	</div>
</body>
</html>