package com.boot.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dto.PageResultDto;
import com.boot.dto.ReplyDto;
import com.boot.entitiy.Reply;
import com.boot.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/replies/*")
@RestController
public class ReplyController {

	private final ReplyService replyService;
	
	@GetMapping(value = "/board/{bno}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PageResultDto<ReplyDto, Object[]> sendBoardReply(@PathVariable Long bno, @RequestParam(defaultValue = "1") int page){
		System.out.println(bno);
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by(Sort.Direction.ASC, "rno"));
		PageResultDto<ReplyDto, Object[]> pageResultDto = replyService.getReplyPage(bno, pageable);
		return pageResultDto;
	}
	
	@PostMapping(value = "/writeReply",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Long writeReply(ReplyDto replyDto) {
		return replyService.writeReply(replyDto);
	}
	
}
