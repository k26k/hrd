<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="com.repository.BoardDAO" />
<%
	if(request.getParameter("bNum")==null){
		response.sendRedirect("./boardList.jsp");
		return;
	}

	int bNum = Integer.parseInt((String)request.getParameter("bNum"));
	boolean check = boardDAO.delete(bNum);
	
	if(check){
		out.println("<script>alert('"+bNum+"번 삭제성공');");
	}else{
		out.println("<script>alert('"+bNum+"번 삭제실패');");
	}
	out.println("location.href='./boardList.jsp';</script>");
%>