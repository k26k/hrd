package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.check.Check;
import com.repository.Board;
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
		
		String numPattern = "^[0-9]*$";
		
		//================================================
		//================================================
		
		if(command.equals("/home")) {
			nextPage = "/main.jsp";
			
			
		//================================================
		//================================================
			
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
				String[] resultTexts = null;
				resultTexts = new String[]{"회원 등록", "등록 실패", "회원 등록으로 이동", "/memberForm"};
				request.setAttribute("resultTexts", resultTexts);
				nextPage = "/memberResult.jsp";
			}
			
			
			
		}else if(command.equals("/deleteMember")) {
			String[] resultTexts = null;
			if(memberDAO.delete(request.getParameter("deleteID"))) {
				resultTexts = new String[]{"회원 삭제", "삭제 성공", "회원 목록으로 이동", "/memberList"};
			}else {
				resultTexts = new String[]{"회원 삭제", "삭제 실패", "회원 목록으로 이동", "/memberList"};
			}
			request.setAttribute("resultTexts", resultTexts);
			nextPage = "/memberResult.jsp";
			
			
			
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
			request.setAttribute("male", member.getGender().equals("남"));
			nextPage = "/memberView.jsp";
		
			
			
		}else if(command.equals("/updateMember")) {
			String[] resultTexts = null;
			if(session.getAttribute("loginID")==null){
				resultTexts = new String[]{"회원 정보 수정", "로그인 필수", "로그인 하러가기", "/login"};
			}
			Member member = memberDAO.getMember((String)session.getAttribute("loginID"));
			if(member.getMemberID() == null){
				session.invalidate();
				resultTexts = new String[]{"회원 정보 수정", "없는 회원", "로그인 하러가기", "/login"};
			}
			member.setMemberID(request.getParameter("memberID"));
			member.setPasswd(request.getParameter("passwd"));
			member.setName(request.getParameter("name"));
			member.setGender(request.getParameter("gender"));
			boolean check = memberDAO.updateMember(member, (String)session.getAttribute("loginID"));
			
			if(check) {
				session.invalidate();
				resultTexts = new String[]{"회원 정보 수정", "수정 성공", "로그인 하러가기", "/login"};
			}else {
				resultTexts = new String[]{"회원 정보 수정", "수정 실패", "회원 정보 수정하기", "/memberView"};
			}
			request.setAttribute("resultTexts", resultTexts);
			nextPage = "/memberResult.jsp";
			
		
		//================================================
		//================================================
			
		}else if(command.equals("/login")) {
			nextPage = "/loginMemberForm.jsp";
			
			
		}else if(command.equals("/loginProcess")) {
			boolean check = memberDAO.checkLogin(request.getParameter("memberID"), request.getParameter("passwd"));
			String[] resultTexts = null;
			if(check) {
				session.setAttribute("loginID",request.getParameter("memberID"));
				resultTexts = new String[]{"로그인", "로그인 성공", "home으로 이동하기", "/home"};
			}else {
				//out.println("<script type=\"text/javascript\">alert('아이디와 비밀번호가 일치하지 않습니다.');location.href='/login';</script>");
				//return;
				resultTexts = new String[]{"로그인", "로그인 실패", "로그인 하러가기", "/login"};
			}
			request.setAttribute("resultTexts", resultTexts);
			nextPage = "/memberResult.jsp";
			
			
			
		}else if(command.equals("/logout")) {
			session.invalidate();
			response.sendRedirect("/home");
			return;
		
			
		//================================================
		//================================================
			
		}else if(command.equals("/boardList")) {
			request.setAttribute("boardList", boardDAO.getAllList());
			nextPage = "/board/boardList.jsp";
			
			
			
		}else if(command.equals("/writeForm")) {
			String[] resultTexts = null;
			if(session.getAttribute("loginID") == null) {
				resultTexts = new String[] {"게시글 작성", "로그인후 가능합니다", "로그인 하기", "/login"};
				request.setAttribute("resultTexts", resultTexts);
				nextPage = "/memberResult.jsp";
			}else if(memberDAO.getMember((String)session.getAttribute("loginID")).getName()==null){
				session.invalidate();
				resultTexts = new String[] {"게시글 작성", "로그인후 가능합니다", "로그인 하기", "/login"};
				request.setAttribute("resultTexts", resultTexts);
				nextPage = "/memberResult.jsp";
			}else {
				nextPage = "/board/writeForm.jsp";
			}
			
			
			
		}else if(command.equals("/write")) {
			String[] resultTexts = null;
			if(session.getAttribute("loginID") == null) {
				resultTexts = new String[] {"게시글 작성", "로그인후 가능합니다", "로그인 하기", "/login"};
			}else if(memberDAO.getMember((String)session.getAttribute("loginID")).getName()==null){
				session.invalidate();
				resultTexts = new String[] {"게시글 작성", "로그인후 가능합니다", "로그인 하기", "/login"};
			}else {
				Board board = new Board();
				board.setTitle(request.getParameter("title"));
				board.setContent(request.getParameter("content"));
				if(boardDAO.addBoard((String)session.getAttribute("loginID"), board)) {
					ArrayList<Board> boardList = boardDAO.getAllList();
					board = boardList.get(0);
					resultTexts = new String[] {"게시글 작성", "작성 성공", "작성한 게시글 보기", "/boardView?num="+board.getbNum()};
				}else {
					resultTexts = new String[] {"게시글 작성", "작성 실패", "게시판 보기", "/boardList"};
				}
			}
			
			request.setAttribute("resultTexts", resultTexts);
			nextPage = "/memberResult.jsp";
			
			
			
		}else if(command.equals("/boardView")) {
			Object num = request.getParameter("num");
			if(num==null || !Pattern.matches(numPattern, (String)num)) {
				response.sendRedirect("/boardList");
				return;
			}
			Board board = boardDAO.getBoard(Integer.parseInt((String)num));
			if(board.getbNum()==0) {
				response.sendRedirect("/boardList");
				return;
			}
			boardDAO.viewsUp(board.getbNum());
			board.setViews(board.getViews()+1);
			request.setAttribute("board", board);
			Member member = memberDAO.getMember(board.getMemberID());
			request.setAttribute("name", member.getName());
			if(session.getAttribute("loginID")!=null && ((String)session.getAttribute("loginID")).equals(member.getMemberID())) {
				request.setAttribute("writer", true);
			}
			nextPage = "/board/boardView.jsp";
			
			
			
		}else if(command.equals("/deleteBoard")) {
			Object num = request.getParameter("bNum");
			String[] resultTexts = null;
			Board board = null;
			if(num==null || !Pattern.matches(numPattern, (String)num)) {
				resultTexts = new String[]{"게시글 삭제", "잘못된 번호입니다", "게시글 보러가기", "/boardList"};
			}else if(session.getAttribute("loginID")==null) {
				resultTexts = new String[]{"게시글 삭제", "로그인후 가능합니다", "로그인 하기", "/login"};
			}else {
				board = boardDAO.getBoard(Integer.parseInt((String)num));
				if(board.getbNum()==0) {
					resultTexts = new String[]{"게시글 삭제", "해당 게시글이 없습니다", "게시글 보러가기", "/boardList"};
				}else if(!((String)session.getAttribute("loginID")).equals(board.getMemberID())) {
					resultTexts = new String[]{"게시글 삭제", "본인의 글만 삭제할 수 있습니다", "로그인 하기", "/login"};
				}
			}
			if(resultTexts == null) {
				if(boardDAO.delete(Integer.parseInt((String)num))) {
					resultTexts = new String[]{"게시글 삭제", "삭제 성공", "게시판 보러가기", "/boardList"};
				}else{
					resultTexts = new String[]{"게시글 삭제", "삭제 실패", "게시글 보러가기", "/boardView?num="+(String)num};
				}
			}
			request.setAttribute("resultTexts", resultTexts);
			nextPage = "/memberResult.jsp";
			
			
			
		}else if(command.equals("/updateBoard")) {
			Object num = request.getParameter("bNum");
			String[] resultTexts = null;
			Board board = null;
			if(num==null || !Pattern.matches(numPattern, (String)num)) {
				resultTexts = new String[]{"게시글 업데이트", "잘못된 번호입니다", "게시글 보러가기", "/boardList"};
			}else if(session.getAttribute("loginID")==null) {
				resultTexts = new String[]{"게시글 업데이트", "로그인후 가능합니다", "로그인 하기", "/login"};
			}else {
				board = boardDAO.getBoard(Integer.parseInt((String)num));
				if(board.getbNum()==0) {
					resultTexts = new String[]{"게시글 업데이트", "해당 게시글이 없습니다", "게시글 보러가기", "/boardList"};
				}else if(!((String)session.getAttribute("loginID")).equals(board.getMemberID())) {
					resultTexts = new String[]{"게시글 업데이트", "본인의 글만 수정할 수 있습니다", "로그인 하기", "/login"};
				}
			}
			if(resultTexts == null) {
				board = new Board();
				board.setbNum(Integer.parseInt((String)num));
				board.setTitle((String)request.getParameter("title"));
				board.setContent((String)request.getParameter("content"));
				if(boardDAO.update(board)) {
					resultTexts = new String[]{"게시글 업데이트", "업데이트 성공", "게시글 보러가기", "/boardView?num="+(String)num};
				}else{
					resultTexts = new String[]{"게시글 업데이트", "업데이트 실패", "게시판 보러가기", "/boardList"};
				}
			}
			request.setAttribute("resultTexts", resultTexts);
			nextPage = "/memberResult.jsp";
			
			
			
		}else if(command.equals("/recommend")) {
			Object num = request.getParameter("bNum");
			String[] resultTexts = null;
			Board board = null;
			if(num==null || !Pattern.matches(numPattern, (String)num)) {
				resultTexts = new String[]{"게시글 추천", "잘못된 번호입니다", "게시판 보러가기", "/boardList"};
			}else {
				board = boardDAO.getBoard(Integer.parseInt((String)num));
				if(board.getbNum()==0) {
					resultTexts = new String[]{"게시글 추천", "해당 게시글이 없습니다", "게시판 보러가기", "/boardList"};
				}
			}
			if(resultTexts == null) {
				int bNum = board.getbNum();
				int resultMode = 0;
				Cookie[] cookies = request.getCookies();
				Cookie recommendCookie = null;
				for(Cookie cookie:cookies) {
					if(cookie.getName().equals("recommend")) {
						recommendCookie = cookie;
					}
				}
				if(recommendCookie == null) {
					if(boardDAO.recommendUp(board.getbNum())) {
						resultMode = 1;
						recommendCookie = new Cookie("recommend", Integer.toString(bNum));
						response.addCookie(recommendCookie);
						recommendCookie.setMaxAge(259200);
					}
				}else {
					String recommendCookieValue = recommendCookie.getValue();
					String[] recommendCookieValues = recommendCookieValue.split("//");
					for(String recommendValue:recommendCookieValues) {
						if(recommendValue.equals(Integer.toString(bNum))) {
							resultMode = 2;
							break;
						}
					}
					if(resultMode==0) {
						if(boardDAO.recommendUp(bNum)) {
							resultMode=1;
							recommendCookie.setValue(recommendCookieValue+"//"+Integer.toString(bNum));
							recommendCookie.setMaxAge(259200);
							response.addCookie(recommendCookie);
						}
					}
				}
				switch (resultMode) {
				case 1:
					resultTexts = new String[]{"게시글 추천", "개추 성공", "게시글 보러가기", "/boardView?num="+bNum};
					break;
				case 2:
					resultTexts = new String[]{"게시글 추천", "이미 개추한 게시글 입니다", "게시글 보러가기", "/boardView?num="+bNum};
					break;
				default:
					resultTexts = new String[]{"게시글 추천", "개추 실패", "게시글 보러가기", "/boardView?num="+bNum};
					break;
				}
			}
				
			request.setAttribute("resultTexts", resultTexts);
			nextPage = "/memberResult.jsp";
		}
		
		
		
//		포워딩(페이지 이동)
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	

}
