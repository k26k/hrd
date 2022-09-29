package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.domain.Board;
import com.boot.repository.BoardRepository;
import com.boot.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(@RequestParam(defaultValue = "") String search,
							@RequestParam(defaultValue = "1") int page, 
							Model model) {
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by(Sort.Direction.DESC, "seq"));
		Page<Board> boardPage = boardService.getBoardPage(search, pageable);
		System.out.println("boardPage: "+boardPage.toString());
		System.out.println("boardPage: "+boardPage.getContent());
		
		if(boardPage != null) {
			model.addAttribute("boardPage", boardPage);
		}
		
		return "board/boardList";
	}
	
	@GetMapping("/getBoardView")
	public String getBoardView(long seq, Model model) {
		Board board = boardService.getBoardBySeq(seq);
		model.addAttribute("board", board);
		
		return "board/boardView";
	}
	
}
