<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="addrDAO" class="dao.AddrBookDAO" scope="application" />
<%
	request.setCharacterEncoding("utf-8");
	String indexRequest = (String)request.getParameter("userIndex");
	
	try{
		addrDAO.deleteAddr(Integer.parseInt(indexRequest));
		%>
		<script type="text/javascript">
			alert("삭제 성공");
		</script>
		<%
	}catch(Exception e){
		%>
		<script type="text/javascript">
			alert("삭제 실패");
		</script>
		<%
	}
%>
<script type="text/javascript">
	location.href="addrList.jsp";
</script>