<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String realFolder = "C:\\dev\\hrd\\jsp works\\jweb5\\src\\main\\webapp\\upload";
	
	// (request객체, 저장폴더, 최대크기, 형식, 파일명 변경방식)
	MultipartRequest multi = new MultipartRequest(request, realFolder, 
				5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	ArrayList<String[]> names = new ArrayList<>();
	ArrayList<String[]> titles = new ArrayList<>();
	ArrayList<String[]> fileNames = new ArrayList<>();
	
	String namePattern = "name";
	String titlePattern = "title";
	String fileNamePattern = "fileName";
	
	// 요청 파라미터 name(fileName은 제외) 속성 가져오기
	Enumeration<String> params = multi.getParameterNames();
	
	while(params.hasMoreElements()){
		String name = params.nextElement(); 
		String value = multi.getParameter(name);
		
		if(name.indexOf(namePattern)!=-1){
			//out.println(name+" "+value+"<br>");
			names.add(new String[]{name, value});
		}else if(name.indexOf(titlePattern)!=-1){
			//out.println(name+" "+value+"<br>");
			titles.add(new String[]{name, value});
		}else{
			out.println("not "+name+" : "+value+"<br>");
		}
	}
	
	
	// 요청 파라미터중 fileName 속성만 가져옴
	Enumeration<String> files = multi.getFileNames();
	while(files.hasMoreElements()){ 
		String name = files.nextElement(); 
		String fileName = multi.getFilesystemName(name); 
		String original = multi.getOriginalFileName(name); 
		String type = multi.getContentType(name); 
		File file = multi.getFile(name); 
		
		if(name.indexOf(fileNamePattern)!=-1){
			out.println(name+" : "+original+"<br>");
			fileNames.add(new String[]{name, original, fileName});
		}else{
			out.println("not "+name+" : "+original+"<br>");
		}
	}
	
	ArrayList<String[]> trs = new ArrayList<>();
	
	//String[][] trtds = String[][]
	
	int count = 0;
	
	while(true){
		if(	names.size()<=count
			&& titles.size()<=count
			&& fileNames.size()<=count){
			break;
		}
		
		String[] tds = new String[4];
		//tds.
		//if()
		
		count++;
	}
	
%>

<%-- <table>
	<tr>
		<th>이름</th>
		<th>제목</th>
		<th>파일</th>
	</tr>
<%
	
%>
	<tr>
		<td></td>
		<td></td>
		<td></td>
	</tr>
<%
	}
%>

</table> --%>
