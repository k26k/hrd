package com.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.boot.domain.Role;
import com.boot.dto.BoardDto;
import com.boot.dto.MemberDto;
import com.boot.entity.Member;
import com.boot.service.BoardService;
import com.boot.service.BoardFileService;
import com.boot.service.MemberService;

@RequestMapping("/ajax/*")
@Controller
public class AjaxController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardFileService fileDtoService;
	
	@ResponseBody
	@GetMapping("/signInSuccess")
	public String signInSuccess() {
		return "{\"result\": true}";
	}
	
	@ResponseBody
	@GetMapping("/signInFail")
	public String signInFail() {
		return "{\"result\": false}";
	}
	
	@ResponseBody
	@PostMapping("/checkId")
	public String checkId(String userId) {
		System.out.println("checkId userId: "+userId);
		if(memberService.checkId(userId)) {
			return "{\"result\": true}";
		}else {
			return "{\"result\": false}";
		}
	}
	
//	@ResponseBody
//	@PostMapping("/signUp")
//	public String checkId(MemberDto memberDto) {
//		System.out.println("signUp member: "+member.toString());
//		if(memberService.insertMember(member)) {
//			return "{\"result\": true}";
//		}else {
//			return "{\"result\": false}";
//		}
//	}
	
	@ResponseBody
	@PostMapping("/updateMemberSelf")
	public String updateMemberSelf(Authentication authentication, MemberDto memberDto) {
//		String userId = authentication.getName();
//		System.out.println("updateMemberSelf userId: "+userId);
//		System.out.println("updateMemberSelf member: "+member.toString());
//		if(memberService.updateMember(userId, member)) {
//			
//			return "{\"result\": true}";
//		}
			
		return "{\"result\": false}";
	}
	
	@ResponseBody
	@PostMapping("/updateMemberAdmin")
	public String updateMemberAdmin(Authentication authentication, String adminId, String oldId, MemberDto memberDto) {
//		System.out.println("updateMemberAdmin oldId: "+oldId);
//		System.out.println("updateMemberAdmin member: "+member.toString());
//		if(memberService.updateMemberAdmin(oldId, member)) {
//			return "{\"result\": true}";
//		}
		
		return "{\"result\": false}";
	}
	
	@ResponseBody
	@PostMapping("/writeBoard")
	public String writeBoard(Authentication authentication, BoardDto boardDto, @RequestParam("file") MultipartFile[] multipartFiles) throws IllegalStateException, IOException {
//		String userId = authentication.getName();
//		System.out.println("writeBoard name: "+userId);
//		System.out.println("writeBoard board: "+board.toString());
//		
//		if(boardService.insertBoard(userId, board)) {
//			if(fileDtoService.saveFiles(board, multipartFiles)) {
//				return "{\"result\": true}";
//			}
//		}
		
		return "{\"result\": false}";
	}
	
	@ResponseBody
	@PostMapping("/updateBoard")
	public String updateBoard(Authentication authentication, BoardDto boardDto) {
//		String userId = authentication.getName();
//		System.out.println("writeBoard name: "+userId);
//		System.out.println("writeBoard board: "+board.toString());
//		if(boardService.updateBoard(userId, board)) {
//			return "{\"result\": true}";
//		}
		
		return "{\"result\": false}";
	}
	
}
