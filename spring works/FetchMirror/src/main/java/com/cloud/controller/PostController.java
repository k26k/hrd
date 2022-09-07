package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.service.PostService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/post/*")
@Controller
public class PostController {

	private PostService postService;
	
	@GetMapping("view")
	private String postViewGet(@RequestParam("boardnum") String boardnum, @RequestParam("postnum") String postnum, Model model) {
		if(postnum == null) {
			if(boardnum == null) {
				return "redirect:/board/list";
			}
			return "redirect:/board/view?boardnum="+boardnum;
		}
		
		int num = Integer.parseInt(postnum);
		model.addAttribute("post", postService.getPost(num));
		
		return "post/postView";
	}
	
}
