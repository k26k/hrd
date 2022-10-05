package com.boot.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boot.config.SecurityUser;
import com.boot.domain.Board;
import com.boot.domain.Role;
import com.boot.domain.Search;
import com.boot.service.BoardService;
import com.boot.service.FileDtoService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private FileDtoService fileDtoService;
	
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
		boardService.cntUp(seq);
		Board board = boardService.getBoardBySeq(seq);
		model.addAttribute("board", board);
		
		return "board/boardView";
	}
	
	@GetMapping("/searchBoardList")
	public String searchBoardList(	@RequestParam(name = "search", defaultValue = "") String searchKeyword,
									@RequestParam(name = "condition", defaultValue = "") String searchCondition,
									@RequestParam(defaultValue = "1") int page, 
									Model model) {
		Search search = new Search();
		search.setSearchKeyword(searchKeyword);
		search.setSearchCondition(searchCondition);
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by(Sort.Direction.DESC, "seq"));
		
		Page<Board> boardPage = boardService.getBoardSearch(search, pageable);
		System.out.println("boardPage: "+boardPage.toString());
		System.out.println("boardPage: "+boardPage.getContent());
		
		if(boardPage != null) {
			model.addAttribute("boardPage", boardPage);
		}
		
		return "board/boardList";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoardForm() {
		return "board/writeBoard";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoardProcess(Board board, 
									@RequestParam("file") MultipartFile[] multipartFiles, 
									Authentication auth) throws IllegalStateException, IOException {
		
//		파일 업로드
//		for(MultipartFile multipartFile:multipartFiles) {
//			if(!multipartFile.isEmpty()) {
//				FileDto fileDto = new FileDto(	UUID.randomUUID().toString(), 
//												multipartFile.getOriginalFilename(),
//												multipartFile.getContentType());
//				File file = new File(fileDto.getUuid()+"_"+fileDto.getFileName());
//				multipartFile.transferTo(file);
//			}
//		}
		fileDtoService.saveFiles(multipartFiles);
		
		board.setMember(((SecurityUser)auth.getPrincipal()).getMember());
		boardService.addBoard(board);
		return "redirect:/board/getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoardProcess(Board board, Authentication auth) {
		if(auth == null) {
			return "redirect:/system/login";
		}
		Board originBoard = boardService.getBoardBySeq(board.getSeq());
		if(!originBoard.getMember().getId().equals(auth.getName())) {
			String authority = ((List<?>)auth.getAuthorities()).get(0).toString();
			if(!authority.equals(Role.ROLE_ADMIN)) {
				return "redirect:/system/accessDenied";
			}
		}
		originBoard.setTitle(board.getTitle());
		originBoard.setContent(board.getContent());
		boardService.updateBoard(originBoard);
		return "redirect:/board/getBoardView?seq="+originBoard.getSeq();
	}
	
	@PostMapping("/deleteBoard")
	public String deleteBoardProcess(Long seq, Authentication auth) {
		if(auth == null) {
			return "redirect:/system/login";
		}
		Board originBoard = boardService.getBoardBySeq(seq);
		if(!originBoard.getMember().getId().equals(auth.getName())) {
			String authority = ((List<?>)auth.getAuthorities()).get(0).toString();
			if(!authority.equals(Role.ROLE_ADMIN)) {
				return "redirect:/system/accessDenied";
			}
		}
		boardService.deleteBoard(seq);
		return "redirect:/board/getBoardList";
	}
	
	
	
	
}
