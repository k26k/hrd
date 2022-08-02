<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Enumeration<String> valueNames = request.getAttributeNames();
	while(valueNames.hasMoreElements()){
		String valueName = valueNames.nextElement();
		//out.println(valueName+": ");
		if(!valueName.substring(0,5).equals("javax")){
			out.println(valueName+": ");
			Object valueObj = request.getAttribute(valueName);
			out.println(toS(valueObj));
			out.println("<br>");
		}
	}
%>
<%! 
	public StringBuffer toS(Object values){
		StringBuffer str = new StringBuffer("");
		if(values instanceof String){
			str.append(values);
			str.append(" ");
			return str;
		}else if(values instanceof String[]){
			for(String value:(String[])values){
				str.append(value);
				str.append(" ");
			}
			return str;
			
		}else if(values instanceof ArrayList){
			for(Object value:(ArrayList)values){
				/* if(value instanceof Integer){
					value = (Integer)value;
				}
				out.println(value+" "); */
				str.append(value);
				str.append(" ");
			}
			return str;
		}
		str.append(" none ");
		return str;
	}
%>
	<hr>
	<c:forEach var="name" items="${names}">
		${name}<span> </span>
	</c:forEach>
</body>
</html>