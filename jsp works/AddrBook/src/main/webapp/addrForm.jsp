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
		<h2>주소록 등록</h2>
		<hr>
		<%@ include file="./loginStatus.jsp" %>
		<form action="./addrAdd.jsp" method="post">
			<table id="tbl">
				<tr>
					<td> <label for="username" >이름</label> </td>
					<td> <input type="text" id="username" name="username" maxlength=20 size=20 required > </td>
				</tr>
				<tr>
					<td> <label for="tel" >전화번호</label> </td>
					<td> <input type="text" id="tel" name="tel" maxlength=20 size=20 required > </td>
				</tr>
				<tr>
					<td> <label for="email" >이메일</label> </td>
					<td> <input type="text" id="email" name="email" maxlength=20 size=20 required > </td>
				</tr>
				<tr>
					<td> <label for="gender" >성별</label> </td>
					<td>
						<select id="gender" name="gender" required >
							<option value="남자" selected="selected" >남</option>
							<option value="여자" >여</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="확인" >
						<input type="reset" value="취소" >
					</td>
				</tr>
			</table>
		</form>
		<p><a href="addrList.jsp">목록 보기</a></p>
	</div>
</body>
</html>