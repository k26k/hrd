<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.repository.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="com.repository.BoardDAO"></jsp:useBean>
<%!
	protected void check(PrintWriter out, Object object, int num) {
	int count = num;
	if(object == null) {
		out.println("<pre>"+"\t".repeat(count)+"null</pre>");
		
	}else if(object instanceof HttpServletRequest) {
		HttpServletRequest request = (HttpServletRequest)object;
		Enumeration<String> eStrP = request.getParameterNames();
		out.println("<pre>"+"\t".repeat(count++)+"getParameter</pre>");
		if(eStrP.hasMoreElements()) {
			while(eStrP.hasMoreElements()) {
				String str = eStrP.nextElement();
				out.println("<pre>"+"\t".repeat(count)+str+"</pre>");
				check(out, request.getParameter(str) , count+1);
			}
			//out.println("<pre> </pre>");
		}else {
			out.println("<pre>"+"\t".repeat(count)+"null</pre>");
		}
		count--;
		
		Enumeration<String> eStrA = request.getAttributeNames();
		out.println("<pre>"+"\t".repeat(count++)+"getAttribute</pre>");
		if(eStrA.hasMoreElements()) {
			while(eStrA.hasMoreElements()) {
				String str = eStrA.nextElement();
				out.println("<pre>"+"\t".repeat(count)+str+"</pre>");
				check(out, request.getAttribute(str) , count+1);
			}
			//out.println("<pre> </pre>");
		}else {
			out.println("<pre>"+"\t".repeat(count)+"null</pre>");
		}
		count--;
		
	}else if(object instanceof String) {
		out.println("<pre>"+"\t".repeat(count)+(String)object+"</pre>");
		
	}else if(object instanceof String[]) {
		out.println("<pre>"+"\t".repeat(count)+"String[]</pre>");
		for(Object object2:(String[])object) {
			check(out,object2,count+1);
		}
		
	}else if(object instanceof ArrayList<?>) {
		out.println("<pre>"+"\t".repeat(count)+"ArrayList<?></pre>");
		for(Object object2:(ArrayList<?>)object) {
			check(out,object2,count+1);
		}
		
	}else {
		out.println("<pre>"+"\t".repeat(count)+"can not cast "+object.getClass()+"</pre>");
	}
	//out.println("<pre> </pre>");
	}
%>
<%
	request.setCharacterEncoding("utf-8");
	
	//check(response.getWriter(), request, 0);

	Board board = new Board();
	board.setbNum(Integer.parseInt((String)request.getParameter("bNum")));
	board.setTitle((String)request.getParameter("title"));
	board.setContent((String)request.getParameter("content"));
	
	boolean check = boardDAO.update(board);
	
	if(check){
		out.println("<script>alert('업데이트 성공');location.href='./boardView.jsp?num="+board.getbNum()+"';</script>");
	}

	out.println("<script>alert('업데이트 실패');histroy.go(-1);</script>");

%>