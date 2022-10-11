package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.dto.GuestBookDto;
import com.boot.dto.PageRequestDto;
import com.boot.entity.GuestBook;
import com.boot.service.GuestBoardSurvice;

@Controller
public class mainController {

	@Autowired
	private GuestBoardSurvice guestBoardSurvice;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/board/getBoardList")
	public String boardList(PageRequestDto pageRequestDto ,Model model) {
		model.addAttribute("boardRequest", pageRequestDto);
		model.addAttribute("boardPage", guestBoardSurvice.getList(pageRequestDto));
		return "board/boardList";
	}
	
	@GetMapping("/board/writeBoard")
	public String writeBoard() {
		return "board/writeBoard";
	}
	
	@PostMapping("/board/writeBoard")
	public String writeBoardP(GuestBookDto guestBookDto, RedirectAttributes redirectAttributes) {
		Long gno = guestBoardSurvice.register(guestBookDto);
		redirectAttributes.addAttribute("msg", gno+"번 게시글 작성 완료");
		return "redirect:/board/getBoardList";
	}
	
	@GetMapping("/board/getBoard")
	public String boardList(Long gno ,Model model) {
		model.addAttribute("board", guestBoardSurvice.getGuestBookDto(gno));
		return "board/boardView";
	}
	
}
