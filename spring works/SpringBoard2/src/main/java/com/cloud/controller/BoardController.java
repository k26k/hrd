package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.domain.BoardVO;
import com.cloud.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getAllList());
		return "/board/boardList";
	}
	
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		return "/board/boardWrite";
	}
	
	@RequestMapping(value="/boardInsert", method = RequestMethod.POST)
	public String boardInsert(BoardVO boardVO) {
		boardService.addBoard(boardVO);
		return "redirect:/boardList";
	}
	
	@RequestMapping("/boardView")
	public String boardView(int num, Model model) {
		boardService.cntUp(num);
		model.addAttribute("board", boardService.getBoard(num));
		return "/board/boardView";
	}
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO, Model model) {
		boardService.updateBoard(boardVO);
		return "redirect:/boardView?num="+boardVO.getBno();
	}
	
	@RequestMapping(value="/boardDelete", method = RequestMethod.POST)
	public String boardDelete(int bno, Model model) {
		boardService.deleteBoard(bno);
		return "redirect:/boardList";
	}
	

	
}
