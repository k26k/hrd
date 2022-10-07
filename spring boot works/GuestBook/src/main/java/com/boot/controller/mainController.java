package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.dto.PageRequestDto;
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
	
}
