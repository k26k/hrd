<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간이란... </title>
<style type="text/css">
	#content{width: 800px; margin: 0 auto; text-align: center;}
</style>
<script type="text/javascript">
	setInterval(function(){
		// let date = new Date();
		// let now = date.toLocaleString();
		// document.getElementById("watch").innerHTML = now;
		document.getElementById("watch").innerHTML = new Date().toLocaleString();
	}, 1000);
</script>
</head>
<body>
	<div id="content">
		<h2>시간이란... </h2>
		<p>내일 죽을 것처럼 오늘을 살고<br>
		   영원히 살 것처럼 내일을 꿈꾸어라</p>
		<img alt="손시계" src="./resources/images/time.jpg">
		<p id="watch"></p>
	</div>
</body>
</html>