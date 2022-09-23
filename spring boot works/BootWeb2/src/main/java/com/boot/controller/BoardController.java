package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.domain.Board;
import com.boot.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}

	@GetMapping("/hello")
	public String hello() {
		return "/hello";
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getAllBoardList());
		return "/boardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:/boardList";
	}
	
	@GetMapping("/boardView")
	public String boardView(Long seq ,Model model) {
		boardService.boardCntUp(seq);
		model.addAttribute("board", boardService.getBoard(seq));
		return "/boardView";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Long seq) {
		boardService.deleteBoard(seq);
		return "redirect:/boardList";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:/boardView?seq="+board.getSeq();
	}
	
	
}
