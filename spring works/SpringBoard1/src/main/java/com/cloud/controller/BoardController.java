package com.cloud.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.BoardVO;
import com.cloud.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService; 
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		ArrayList<BoardVO> boardList = boardService.getAllList();
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	@RequestMapping("/boardView")
	public String boardView(int num, Model model) {
		BoardVO boardVO = boardService.getBoard(num);
		model.addAttribute("board", boardVO);
		return "board/boardView";
	}
	
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/boardInsert", method = RequestMethod.POST)
	public String boardWrite(BoardVO board, HttpSession session) {
		board.setWriter((String)session.getAttribute("sessionId"));
		boardService.addBoard(board);
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO board) {
		boardService.updateBoard(board);
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardDelete", method = RequestMethod.POST)
	public String boardDelete(int bno) {
		boardService.deleteBoard(bno);
		return "redirect:boardList";
	}
	
	
}
