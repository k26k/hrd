package com.boot.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dto.AjaxResultDto;
import com.boot.dto.MemberFormDto;
import com.boot.entity.Member;
import com.boot.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/s/*")
@Controller
public class SystemController {

	private final MemberService memberService;
	
	@GetMapping("/in")
	public String signInForm() {
		return "system/signIn";
	}
	
	@GetMapping("/up")
	public String signUpForm() {
		return "system/signUp";
	}
	
//	@Valid
	@ResponseBody
	@PostMapping("/up")
	public Object signUpProcess(@Valid MemberFormDto memberFormDto, BindingResult bindingResult) {
		AjaxResultDto ajaxResultDto;
		if(bindingResult.hasErrors()) {
			System.out.println("/s/up hasError");
			String errors = bindingResult.getAllErrors().toString();
			System.out.println(errors);
			ajaxResultDto = AjaxResultDto.builder()
					.result(false)
					.message(errors)
					.build();
		}
		
		if(memberService.addMember(memberFormDto)) {
			ajaxResultDto = AjaxResultDto.builder()
					.result(true)
					.message("회원가입 성공! 로그인해 주세요.")
					.redirectLink("/s/in")
					.build();	
		}else {
			ajaxResultDto = AjaxResultDto.builder()
					.result(false)
					.message("회원가입 실패. 다시 시도해 주세요.")
					.build();	
		}
		
		return ajaxResultDto;
	}
	
	@ResponseBody
	@PostMapping("/duplicate")
	public Object checkEmailDuplicate(Member member) {
		memberService.validateDuplicateMember(member);
		
		AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
				.result(false)
				.message("사용 가능한 이메일입니다.")
				.build();
		return ajaxResultDto;
	}
	
	@ResponseBody
	@GetMapping("/signInFail")
	public Object signInFail() {
		AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
				.result(false)
				.message("로그인 실패! 아이디나 비밀번호를 확인해주세요!")
				.build();
		return ajaxResultDto;
	}
	
	
	
}
