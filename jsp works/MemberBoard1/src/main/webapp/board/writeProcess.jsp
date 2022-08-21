<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="boardDAO" class="com.repository.BoardDAO" />
<jsp:useBean id="board" class="com.repository.Board" />
<jsp:setProperty property="title" name="board"/>
<jsp:setProperty property="content" name="board"/>
<%
	if(session.getAttribute("loginID")==null){
		response.sendRedirect("./boardList.jsp");
		return;
	}
	if(board.getTitle()==null || board.getContent()==null){
		response.sendRedirect("./writeForm.jsp");
		return;
	}
	
	boolean check = boardDAO.addBoard((String)session.getAttribute("loginID"), board);
	
	if(check){
		out.println("<script>alert('작성성공');location.href='./boardList.jsp';</script>");
	}else{
		out.println("<script>alert('작성실패');location.href='./writeForm.jsp';</script>");
	}
		
%>