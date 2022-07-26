<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="addrDAO" class="com.dao.AddrBookDAO" scope="application" />
<%
	request.setCharacterEncoding("utf-8");
	int num = Integer.parseInt(request.getParameter("num"));
	
	if(!addrDAO.delete(num)){
		
	}else{
		%>
		<script type="text/javascript">
			alert("삭제 성공");
		</script>
		<%
	}
	
	try{
		//addrDAO.deleteAddr(Integer.parseInt(indexRequest));

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