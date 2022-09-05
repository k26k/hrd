package com.cloud.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.domain.BoardVO;
import com.cloud.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	public String boardList(Authentication authentication, Model model) {
		if(authentication==null) {
			log.info(authentication);
		}else {
			log.info(authentication.getPrincipal());
		}
		model.addAttribute("boardList", boardService.getAllList());
		return "/board/boardList";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		return "/board/boardWrite";
	}
	

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/boardInsert", method = RequestMethod.POST)
	public String boardInsert(BoardVO boardVO, Authentication auth) throws IllegalAccessException, IOException{
		MultipartFile uploadFile = boardVO.getUploadFile();
		log.info(boardVO);
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			log.info(fileName);
			String filePath = "C:\\dev\\hrd\\spring works\\SpringBoard2\\src\\main\\webapp\\upload\\";
			File file = new File(filePath+fileName);
			log.info(file);
			uploadFile.transferTo(file);
		}
		boardVO.setWriter(auth.getName());
		boardService.addBoard(boardVO);
		return "redirect:/boardList";
	}
	
//	@PreAuthorize("isAuthenticated()")
//	@RequestMapping(value="/boardInsert", method = RequestMethod.POST)
//	public String boardInsert(BoardVO boardVO, Authentication auth) {
//		boardVO.setWriter(auth.getName());
//		boardService.addBoard(boardVO);
//		return "redirect:/boardList";
//	}
	
	@RequestMapping("/boardView")
	public String boardView(int num, Model model) {
		boardService.cntUp(num);
		model.addAttribute("board", boardService.getBoard(num));
		return "/board/boardView";
	}
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO, Authentication auth) {
		boardVO.setWriter(auth.getName());
		boardService.updateBoard(boardVO);
		return "redirect:/boardView?num="+boardVO.getBno();
	}
	
	@RequestMapping(value="/boardDelete", method = RequestMethod.POST)
	public String boardDelete(int bno, Model model) {
		boardService.deleteBoard(bno);
		return "redirect:/boardList";
	}
	

	
}
