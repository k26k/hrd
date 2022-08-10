<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String greeting = "웹 쇼핑몰에 오신 것을 환영합니다.";
	String tagline = "Welcome to Web Market!";
	Date day = new Date();
	String am_pm;
	int hour = day.getHours();
	int minute = day.getMinutes();
	int second = day.getSeconds();
	
	if(hour/12==0){
		am_pm="AM";
	}else{
		am_pm="PM";
		hour-=12;
	}
	String nowTime = "현재 접속 시간: "+hour+":"+minute+":"+second+" "+am_pm;
	response.setIntHeader("Refresh", 1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>WebMarket main</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1><%= greeting %></h1>
		</div>
	</div>
	<div class="container">
		<div class="text-center">
			<h3><%= tagline %></h3>
			<P><%= nowTime %></P>
		</div>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>