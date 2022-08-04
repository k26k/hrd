package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repository.Member;
import com.repository.MemberDAO;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	MemberDAO memberDAO;

	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		String nextPage = "";
		
		if(uri.equals("/home")) {
			nextPage = "/main.jsp";
			
		}else if(uri.equals("/memberList")) {
			ArrayList<Member> memberList = memberDAO.getAllList();
			request.setAttribute("memberList", memberList);
			nextPage = "/memberList.jsp";
			
		}else if(uri.equals("/memberForm")) {
			nextPage = "/memberForm.jsp";
			
		}else if(uri.equals("/addMember")) {
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
			
		}else if(uri.equals("/login")) {
			nextPage = "/loginMemberForm.jsp";
		}
		
//		포워딩(페이지 이동)
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
