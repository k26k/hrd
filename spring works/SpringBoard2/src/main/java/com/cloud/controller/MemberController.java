package com.cloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.domain.MemberAuthVO;
import com.cloud.domain.MemberVO;
import com.cloud.security.CustomUser;
import com.cloud.security.CustomUserDetailsService;
import com.cloud.service.MemberAuthService;
import com.cloud.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Controller
public class MemberController {

	private MemberService memberService;
	private MemberAuthService memberAuthService;
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/addMember")
	public String addMember() {
		return "/member/addMemberForm";
	}
	
	@PostMapping("/addMemberProcess")
	public String addMemberProcess(MemberVO memberVO) {
		String memberVOPwE = passwordEncoder.encode(memberVO.getUserpw());
		memberVO.setUserpw(memberVOPwE);
		MemberAuthVO memberAuthVO = new MemberAuthVO();
		memberAuthVO.setUserid(memberVO.getUserid());
		memberAuthVO.setAuth("ROLE_USER");
		int check = 0;
		check += memberService.addMember(memberVO);
		check += memberAuthService.addMemberAuth(memberAuthVO);
		if(check > 0) {
			return "redirect:/customLogin";
		}else {
			return "redirect:/customLogin?error=1;";
		}
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/showMember")
	public String showMember(Authentication auth, Model model) {
		log.info(((CustomUser)auth.getPrincipal()).getMemberVO());
		//model.addAttribute("memberVO", auth.getPrincipal());
		return "/member/showMember";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/showMember")
	public String showMemberAdmin() {
		return "/member/showMember";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/updateMemberProcess")
	public String updateMemberProcess(Authentication auth, MemberVO memberVO, String oldid, String[] authList, HttpSession session) {
		List<MemberAuthVO> memberAuthVOList = new ArrayList<MemberAuthVO>();
		for(String mAuth:authList) {
			MemberAuthVO memberAuthVO = new MemberAuthVO();
			memberAuthVO.setUserid(memberVO.getUserid());
			memberAuthVO.setAuth(mAuth);
			memberAuthVOList.add(memberAuthVO);
		}
		String memberVOPwE = passwordEncoder.encode(memberVO.getUserpw());
		memberVO.setUserpw(memberVOPwE);
		Map<String, Object> map = new HashMap<>();
		map.put("m", memberVO);
		map.put("oldid", oldid);
		log.info(map);
		
		int check = 0;
		memberAuthService.deleteMemberAuth(oldid);
		check+=memberService.updateMember(map);
		for(MemberAuthVO memberAuthVO:memberAuthVOList) {
			memberAuthService.addMemberAuth(memberAuthVO);
		}
		
		if(check<1) {
			return "redirect:/showMember?error=1";
		}else if(auth.getAuthorities().contains("ROLE_ADMIN")) {
			return "redirect:/memberList";
		}else {
			session.invalidate();
			return "redirect:/customLogin?result=1";
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/memberList")
	public String memberList(Model model) {
		model.addAttribute("memberList",memberService.getMemberList());
		return "/member/memberList";
	}
	
	
}
