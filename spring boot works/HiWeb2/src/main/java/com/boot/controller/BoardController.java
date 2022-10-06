package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.domain.Search;
import com.boot.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(@RequestParam(defaultValue = "1") int page, Model model) {
		Pageable pageable = PageRequest.of(page-1, 10,Sort.by(Sort.Direction.DESC, "seq"));
		model.addAttribute("boardPage", boardService.getBoardPage(pageable));
		model.addAttribute("boardLink", "/board/getBoardList");
		return "board/boardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoardList(Long seq, Model model) {
		boardService.cntUp(seq);
		model.addAttribute("board", boardService.getBoard(seq));
		return "board/boardView";
	}
	
	@GetMapping("/searchBoardList")
	public String searchBoardList(	@RequestParam(defaultValue = "1") int page, 
									Search search, 
									Model model) {
		Pageable pageable = PageRequest.of(page-1, 10,Sort.by(Sort.Direction.DESC, "seq"));
		model.addAttribute("boardPage", boardService.searchBoardPage(search, pageable));
		model.addAttribute("boardLink", boardService.getSearchLink(search));
		return "board/boardList";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoard() {
		return "board/writeBoard";
	}
}
