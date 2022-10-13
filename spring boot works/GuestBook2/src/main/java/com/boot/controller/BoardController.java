package com.boot.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.dto.BoardDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.dto.ReplyDto;
import com.boot.entitiy.Board;
import com.boot.entitiy.Member;
import com.boot.service.BoardService;
import com.boot.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	private final BoardService boardService;
	private final ReplyService replyService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(PageRequestDto pageRequestDto, Model model) {
		
		PageResultDto<BoardDto, Object[]> pageResultDto = boardService.getBoardPage(pageRequestDto);
		
		model.addAttribute("boardRequest", pageRequestDto);
		model.addAttribute("boardPage", pageResultDto);
		
		return "board/boardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("boardRequest") PageRequestDto pageRequestDto, Long bno, Model model) {
		
		BoardDto boardDto = boardService.getBoard(bno);
//		PageResultDto<ReplyDto, Object[]> pageResultDto = replyService.getReplyPage(bno);
		model.addAttribute("board", boardDto);
//		model.addAttribute("replyPage", pageResultDto);
		
		return "board/boardView";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoard() {
		return "board/writeBoard";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoardProcess(BoardDto boardDto, RedirectAttributes redirectAttributes) {
		Long bno = boardService.register(boardDto);
		redirectAttributes.addAttribute("msg", bno+"번 게시글 작성 성공");
		return "redirect:/board/getBoardList";
	}
	
}
