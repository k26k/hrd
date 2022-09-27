package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.boot.domain.Board;
import com.boot.domain.Member;
import com.boot.service.BoardService;


@SessionAttributes("member")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute
	public Member setMember() {
		return new Member();
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/boardList")
	public String boardList(@RequestParam(defaultValue = "") String search,
							@RequestParam(defaultValue = "1")int page, 
							@RequestParam(defaultValue = "10")int size, 
							Model model) {
		Pageable paging = PageRequest.of(page-1, size, Sort.by(Sort.Direction.DESC, "seq"));
		model.addAttribute("boardList", boardService.getBoardListByKeywordAndPage(search, paging));
		return "board/boardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		return "board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		board.setMember(member);
		boardService.insertBoard(board);
		return "redirect:boardList";
	}
	
	@GetMapping("/boardView")
	public String boardView(Long seq ,Model model) {
		boardService.boardCntUp(seq);
		model.addAttribute("board", boardService.getBoard(seq));
		return "board/boardView";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Long seq) {
		boardService.deleteBoard(seq);
		return "redirect:boardList";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:boardView?seq="+board.getSeq();
	}
	
	
}
