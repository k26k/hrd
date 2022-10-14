package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.dto.PageRequestDto;
import com.boot.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(PageRequestDto pageRequestDto, Model model) {
		System.out.println(boardService.getBoardPage(pageRequestDto).toString());
		model.addAttribute("boardPage", boardService.getBoardPage(pageRequestDto));
		return "board/boardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Long seq, Model model) {
		boardService.cntUp(seq);
		model.addAttribute("board", boardService.getBoard(seq));
//		System.out.println("file: "+boardService.getBoard(seq).getFileDtoList().get(0).toString());
		return "board/boardView";
	}
	
	@GetMapping("/searchBoardList")
	public String searchBoardList(@ModelAttribute("pageRequest") PageRequestDto pageRequestDto, Model model) {
		System.out.println(boardService.getBoardPage(pageRequestDto).toString());
		model.addAttribute("boardPage", boardService.getBoardPage(pageRequestDto));
		return "board/boardList";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoard() {
		return "board/writeBoard";
	}
}
