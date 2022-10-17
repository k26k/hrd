package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.dto.PageRequestDto;
import com.boot.service.BoardFileService;
import com.boot.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {

	private final BoardService boardService;
	private final BoardFileService boardFileService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(PageRequestDto pageRequestDto, Model model) {
		System.out.println(boardService.getBoardPage(pageRequestDto).toString());
		model.addAttribute("boardPage", boardService.getBoardPage(pageRequestDto));
		model.addAttribute("search", false);
		return "board/boardList";
	}
	
	@GetMapping("/searchBoardList")
	public String searchBoardList(@ModelAttribute("pageRequest") PageRequestDto pageRequestDto, Model model) {
		System.out.println("searchBoardList pageRequest: "+pageRequestDto.toString());
		System.out.println(boardService.searchBoardPage(pageRequestDto).toString());
		model.addAttribute("boardPage", boardService.searchBoardPage(pageRequestDto));
		model.addAttribute("search", true);
		return "board/boardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Long bno, Model model) {
		boardService.cntUp(bno);
		model.addAttribute("board", boardService.getBoard(bno));
		model.addAttribute("fileDtoList", boardFileService.getBoardFileDtoList(bno));
//		System.out.println("file: "+boardService.getBoard(seq).getFileDtoList().get(0).toString());
		return "board/boardView";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoard() {
		return "board/writeBoard";
	}
}
