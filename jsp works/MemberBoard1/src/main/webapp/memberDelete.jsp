<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="memberDAO" class="com.repository.MemberDAO" scope="application" />
<% 
	String deleteID = request.getParameter("deleteID");
	if(memberDAO.delete(deleteID)){
		response.sendRedirect("./memberList.jsp");
	}
%>
<h1 style="margin: 100px 0 0 0; text-align: center;">삭제 실패</h1>
<h2 style="margin: 30px 0 0 0; text-align: center;">
	<a href="./memberList.jsp" >리스트로 가기</a>
</h2>