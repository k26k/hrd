<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="memberDAO" class="com.repository.MemberDAO"></jsp:useBean>
<%
	String memberID = request.getParameter("memberID");
	String passwd = request.getParameter("passwd");
	boolean loginCheck = memberDAO.checkLogin(memberID, passwd);
	if(loginCheck){
		session.setAttribute("loginID", memberID);
		response.sendRedirect("./index.jsp");
	}else{
		response.sendRedirect("./loginMemberForm.jsp");
	}
%>