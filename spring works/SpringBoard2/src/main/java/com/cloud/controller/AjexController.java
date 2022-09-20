package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.domain.ReplyVO;
import com.cloud.security.CustomUser;
import com.cloud.service.MemberService;
import com.cloud.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/ajax/*")
@Controller
public class AjexController {

	private MemberService memberService;
	private ReplyService replyService;
	
	@RequestMapping("/calc")
	public String calc() {
		return "/ajax/calc";
	}
	
	@RequestMapping("/sayhello")
	public void returnHello() {
		
	}
	
	@ResponseBody
	@RequestMapping(value="/doPlus", produces="application/text; charset=UTF-8")
	public String doPlus(int num1, int num2) {
		log.info(num1);
		log.info(num2);
		String result = "{\"result\":"+(num1+num2)+",\"result_msg\":\"AJAX 계산 성공\"}";
		log.info(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/usernameCheck", produces="application/text; charset=UTF-8")
	public String usernameCheck(String name) {
		String result = null;
		if(name==null) {
			log.info("name: null");
		}else {
			log.info("name: notNull "+name);
		}
		if(memberService.checkMemberUserid(name)!=null) {
			result = "{\"result\":true}";
		}else {
			result = "{\"result\":false}";
		}
		log.info(result);
		return result;
	}
	
	@ResponseBody
	@PostMapping("/addReply")
	public String addReply(
							@RequestParam("bno") int bno,
							@RequestParam("reply") String reply, 
							Authentication auth) {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBno(bno);
		replyVO.setReplyer(((CustomUser)auth.getPrincipal()).getUsername());
		replyVO.setReply(reply);
		log.info(replyVO);
		
		int check = replyService.addReply(replyVO);
		if(check > 0) {
			return "{\"result\":true}";
		}else {
			return "{\"result\":false}";
		}
	}
	
	@GetMapping("/getReply")
	public String getReply(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("replyList", replyService.getReplyList(bno));
		return "board/boardReply";
	}
	
}
