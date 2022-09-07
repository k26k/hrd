package com.cloud.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.service.BoardCategoryService;
import com.cloud.service.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {

	private BoardCategoryService boardCategoryService;
	private PostService postService;
	
	@GetMapping("/list")	
	public String boardListGet(Model model) { 
		model.addAttribute("boardList", boardCategoryService.getAllBoardList());
		return "/board/boardList";
	}
	
	@GetMapping("/view")	
	public String boardViewGet(@RequestParam("boardnum") String boardnum, Model model) { 
		if(boardnum == null) {
			return "redirect:/board/list";
		}
		int num = Integer.parseInt(boardnum);
		log.info(model.addAttribute("board", boardCategoryService.getBoard(num)));
		log.info(model.addAttribute("postList", postService.getPostList(num)));
		return "/board/boardView";
	}
	
}
