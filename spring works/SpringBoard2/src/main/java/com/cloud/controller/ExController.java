package com.cloud.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.domain.SampleVO;
import com.cloud.domain.Ticket;

import lombok.extern.log4j.Log4j;


@Log4j
@RequestMapping("/exam")
@RestController
public class ExController {

	@GetMapping("/getText")
	public String getText() {
		return "Hello~ w0rld!";
	}
	
	@GetMapping(value="/getTextKor", produces = "text/html; charset=UTF-8")
	public String getTextKor() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	@GetMapping(value="/getDefaultSampleVO", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getDefaultSampleVO() {
		log.info("MIME TYPE: " + MediaType.APPLICATION_JSON_VALUE);
		log.info("MIME TYPE: " + MediaType.APPLICATION_XML_VALUE);
		
		SampleVO sampleVO = new SampleVO(100, "fn", "ln");
		return sampleVO;
	}
	
	@GetMapping(value="/getCollection")
	public List<SampleVO> getCollection() {
		return IntStream.range(1,10).mapToObj(i -> new SampleVO(i, "f"+i, "l"+i)).collect(Collectors.toList());
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
		return new String[] {"category: "+cat,"productId: "+pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("ticket convert ... "+ticket);
		return ticket;
	}
	
	
}
