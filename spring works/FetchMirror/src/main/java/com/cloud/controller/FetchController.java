package com.cloud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.repository.CommentSet;
import com.cloud.service.CommentService;
import com.cloud.vo.CommentVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/fetch/*")
@Controller
public class FetchController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("test")
	public void fetchTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		log.info(request.getRequestURL());
		log.info(request.getHeaderNames());
		String text = request.getParameter("text");
		log.info(text);
		
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("{\"text\":\""+text+"\"}");
		//return "/test";
	}
	
	@GetMapping("/add")	
	public void addCommentGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		log.info(request.getRequestURL());
		log.info(request.getHeaderNames());
		String num = request.getParameter("postnum");
		String text = request.getParameter("text");
		int postnum = Integer.parseInt(num);
		log.info(postnum+text);
		
		if(!text.equals("") && !num.equals("")) {
			log.info(text);
			CommentVO commentVo = new CommentVO();
			commentVo.setPostnum(postnum);
			commentVo.setId("test");
			commentVo.setContents(text);
			commentService.addComment(commentVo);
		}
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String result = commentsToJSON(commentService, postnum);
		log.info(result);
		out.println(result);
	}
	
	@PostMapping("/add")	
	public String addCommentPost() {
		return "/test";
	}
	
	@GetMapping("/get")	
	public void getCommentGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		log.info(request.getRequestURL());
		log.info(request.getHeaderNames());
		String num = request.getParameter("postnum");
		int postnum = Integer.parseInt(num);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String result = commentsToJSON(commentService, postnum);
		log.info(result);
		out.println(result);
	}
	
	private String commentsToJSON(CommentService commentService, int postnum) {
		
		List<CommentVO> commentList = commentService.getCommentList(postnum);
		StringBuffer sb = new StringBuffer();
		boolean first = true;
		sb.append("{\"text\":[");
		for(CommentVO c:commentList) {
//			private int comment_num;
//			private int postnum;
//			private String contents;
//			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//			private Date writedate;
//			private String id;
			if(first) {
				first=false;
			}else {
				sb.append(",");
			}
			sb.append("[\"id\":\""+c.getId()+"\",\"contents\":\""+c.getContents()+"\",\"writedate\":\""+c.getWritedate()+"\"]");
			
		}
		sb.append("]}");
		log.info(sb.toString());
		return sb.toString();
	}
	
}
//public class FetchController {
//	
//	@Autowired
//	private CommentSet commentSet;
//	
//	@GetMapping("test")
//	public void fetchTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("utf-8");
//		log.info(request.getRequestURL());
//		log.info(request.getHeaderNames());
//		String text = request.getParameter("text");
//		log.info(text);
//		
//		
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("{\"text\":\""+text+"\"}");
//		//return "/test";
//	}
//	
//	@GetMapping("/add")	
//	public void addCommentGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("utf-8");
//		log.info(request.getRequestURL());
//		log.info(request.getHeaderNames());
//		String text = request.getParameter("text");
//		log.info(text);
//		
//		if(!text.equals("")) {
//			log.info(text);
//			commentSet.addComment(text);
//		}
//		
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		String result = "{\"text\":"+commentSet.getAllCommentToHTML()+"}";
//		log.info(result);
//		out.println(result);
//	}
//	
//	@PostMapping("/add")	
//	public String addCommentPost() {
//		return "/test";
//	}
//	
//	@GetMapping("/get")	
//	public void getCommentGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("utf-8");
//		log.info(request.getRequestURL());
//		log.info(request.getHeaderNames());
//		String text = request.getParameter("text");
//		log.info(text);
//		
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		String result = "{\"text\":"+commentSet.getAllCommentToHTML()+"}";
//		log.info(result);
//		out.println(result);
//	}
//	
//}
