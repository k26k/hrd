package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.repository.BoardDAO;
import com.repository.Member;
import com.repository.MemberDAO;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	MemberDAO memberDAO;
	BoardDAO boardDAO;

	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
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
		
		String nextPage = "";
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(command.equals("/home")) {
			nextPage = "/main.jsp";
			
		}else if(command.equals("/memberList")) {
			ArrayList<Member> memberList = memberDAO.getAllList();
			request.setAttribute("memberList", memberList);
			nextPage = "/memberList.jsp";
			
		}else if(command.equals("/memberForm")) {
			nextPage = "/memberForm.jsp";
			
		}else if(command.equals("/addMember")) {
			Member member = new Member();
			member.setMemberID(request.getParameter("memberID"));
			member.setPasswd(request.getParameter("passwd"));
			member.setName(request.getParameter("name"));
			member.setGender(request.getParameter("gender"));
			boolean check = memberDAO.addMember(member);
			if(check) {
				nextPage = "/login";
			}else {
				nextPage = "/addMember";
			}
			
		}else if(command.equals("/login")) {
			nextPage = "/loginMemberForm.jsp";
			
		}else if(command.equals("/loginProcess")) {
			Boolean check = memberDAO.checkLogin(request.getParameter("memberID"), request.getParameter("passwd"));
			if(check) {
				session.setAttribute("loginID",request.getParameter("memberID"));
				nextPage = "/index.jsp";
			}else {
				out.println("<script type=\"text/javascript\">alert('아이디와 비밀번호가 일치하지 않습니다.');location.href='/login';</script>");
				return;
			}
			
		}else if(command.equals("/logout")) {
			session.invalidate();
			response.sendRedirect("/home");
			return;
			
		}else if(command.equals("/memberView")) {
			if(session.getAttribute("loginID")==null){
				response.sendRedirect("/login");
				return;
			}
			Member member = memberDAO.getMember((String)session.getAttribute("loginID"));
			if(member.getMemberID() == null){
				session.invalidate();
				response.sendRedirect("/login");
				return;
			}
			request.setAttribute("member", member);
			nextPage = "/memberView.jsp";
		
		}else if(command.equals("/boardList")) {
			request.setAttribute("boardList", boardDAO.getAllList());
			nextPage = "/board/boardList.jsp";
			
		}else if(command.equals("/write")) {
			request.setAttribute("boardList", boardDAO.getAllList());
			nextPage = "/board/writeForm.jsp";
		}
		
		
		
//		포워딩(페이지 이동)
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
