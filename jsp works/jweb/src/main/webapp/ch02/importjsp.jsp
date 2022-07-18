<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 배열
		int[] arr = new int[]{10,20,30};
		for(int i=0; i<arr.length; i++){
			out.println(arr[i]);
		}
		
		out.println("<br>");
		
		int[] arr2 = new int[]{10,20,30};
		out.println(Arrays.toString(arr2));
		
		out.println("<br>");
		
		ArrayList<String> fruitsList = new ArrayList<>();
		fruitsList.add("사과");
		fruitsList.add("참외");
		fruitsList.add("수박");
		
		out.println(fruitsList.get(0));
		
		out.println("<br>");
		
		for(String fruit:fruitsList) out.println(fruit);
	%>

</body>
</html>