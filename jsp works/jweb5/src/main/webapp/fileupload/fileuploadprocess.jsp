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
	
	// 요청 파라미터 name(fileName은 제외) 속성 가져오기
	Enumeration<String> params = multi.getParameterNames(); // 이름 객체 생성
	while(params.hasMoreElements()){ // 요청 파라미터중 파일이 있다면 반복
		String name = params.nextElement(); // 파일 가져오기
		String value = multi.getParameter(name); // 이름으로 값 가져오기
		out.println(name+" = "+value+"<br>");
	}
	
	out.println("===================================<br>");
	
	// 요청 파라미터중 fileName 속성만 가져옴
	Enumeration<String> files = multi.getFileNames();
	while(files.hasMoreElements()){ // 파일이 있다면 반복
		String name = files.nextElement(); // 파일의 이름 가져오기
		String fileName = multi.getFilesystemName(name); // 서버에 업로드된 파일의 이름
		String original = multi.getOriginalFileName(name); // 파일의 원본 이름 가져오기
		String type = multi.getContentType(name); // 파일 콘텐츠 유형
		File file = multi.getFile(name); // 전송된 파일의 정보나 경로
		
		out.println("요청 파라미터 이름 = "+name+"<br>");
		out.println("저장 파일 이름 = "+fileName+"<br>");
		out.println("실제 파일 이름 = "+original+"<br>");
		out.println("파일 컨텐츠 유형 = "+type+"<br>");
		
		if(file != null){
			out.println("파일 크기 = "+file.length()+"<br>");
		}
%>
<p>이미지 보기</p>
<p><%= fileName %></p>
<p><img src="../upload/<%= fileName %>" ></p>
<%
	}
%>

