<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 폼 페이지에서 전달받을 글자 인코딩 설정
	request.setCharacterEncoding("UTF-8");
	//이름 필드에 입력된값 가져오기
	String name = request.getParameter("name");
%>
<p>이름: <%= name %> </p>