package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.BoardDAO;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardDAO boardDAO;
	
	public void init(ServletConfig config) throws ServletException {
		boardDAO = new BoardDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri: "+uri);
		String command = uri.substring(uri.lastIndexOf("/"));
		System.out.println("command: "+command);
		
		String nextPage = null;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(command.equals("/boardList.do")) {
			request.setAttribute("boardList", boardDAO.getAllList());
			nextPage = "/board/boardList.jsp";
		}
		
		if(nextPage==null) {response.sendRedirect("/wm2/"); return;}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
