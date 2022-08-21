package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BoardDAO;
import com.dao.MemberDAO;
import com.vo.Board;
import com.vo.Member;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardDAO boardDAO;
	MemberDAO memberDAO;
	
	public void init(ServletConfig config) throws ServletException {
		boardDAO = BoardDAO.getInstance();
		memberDAO = MemberDAO.getInstance();
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
		
		
		else if(command.equals("/boardWriteForm.do")) {
			request.setAttribute("boardList", boardDAO.getAllList());
			String name = memberDAO.getMember((String)session.getAttribute("sessionId")).getName();
			request.setAttribute("name", name);
			nextPage = "/board/boardWriteForm.jsp";
		}
		
		
		else if(command.equals("/boardview.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			boardDAO.viewUp(num);
			request.setAttribute("board", boardDAO.getBoard(num));
			nextPage = "/board/boardView.jsp";
		}
		
		
		else if(command.equals("/boardWriteAction.do")) {
			Member member = memberDAO.getMember((String)session.getAttribute("sessionId"));
			Board board = new Board();
			board.setName(member.getName());
			board.setSubject(request.getParameter("subject"));
			board.setContent(request.getParameter("content"));
			board.setId(member.getId());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date now = new Date();
			String date = dateFormat.format(now);
			board.setwriteDate(date);
			boardDAO.add(board);
			response.sendRedirect("/wm2/boardList.do");
			return;
		}

		
		else if(command.equals("/boardUpdateAction.do")) {
			Board board = boardDAO.getBoard(Integer.parseInt(request.getParameter("num")));
			if(((String)session.getAttribute("sessionId")).equals(board.getId())) {
				board.setSubject(request.getParameter("subject"));
				board.setContent(request.getParameter("content"));
				boardDAO.update(board);
			}
			response.sendRedirect("/wm2/boardList.do");
			return;
		}
		
		
		else if(command.equals("/boardDeleteAction.do")) {
			Board board = boardDAO.getBoard(Integer.parseInt(request.getParameter("num")));
			if(((String)session.getAttribute("sessionId")).equals(board.getId())) {
				boardDAO.delete(board.getNum());
			}
			response.sendRedirect("/wm2/boardList.do");
			return;
		}

		
		
		if(nextPage==null) {response.sendRedirect("/wm2/"); return;}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
