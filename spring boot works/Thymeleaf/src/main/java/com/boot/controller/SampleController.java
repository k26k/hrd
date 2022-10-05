package com.boot.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.dto.ItemDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	@GetMapping("/ex1")
	public void ex1() {
		log.info("ex1 .......");
	}
	
	@GetMapping("/ex2")
	public void ex2(Model model) {
		log.info("ex2 .......");
		
		ItemDto itemDto = new ItemDto();
		itemDto.setId(1L);
		itemDto.setItemNm("상품1");
		itemDto.setItemDetail("상품1 상세설명");
		itemDto.setPrice(20000);
		itemDto.setRegDate(LocalDateTime.now());
		model.addAttribute("itemDto", itemDto);
	}
	
	@GetMapping("/ex3")
	public void ex3(Model model) {
		log.info("ex3 .......");
		
		List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
		for(int i=1; i<=10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setId((long)i);
			itemDto.setItemNm("상품"+i);
			itemDto.setItemDetail("상품"+i+" 상세설명");
			itemDto.setPrice(1000 * i);
			itemDto.setRegDate(LocalDateTime.now());
			itemDtoList.add(itemDto);
		}
		model.addAttribute("itemDtoList", itemDtoList);
	}
	
	@GetMapping("/ex4")
	public void ex4() {
		log.info("ex4 .......");
	}
	
	@GetMapping("/ex5")
	public void ex5() {
		log.info("ex5 .......");
	}
	
	@GetMapping("/exLayout1")
	public void exLayout1() {
		log.info("exLayout1 .......");
	}
	
	@GetMapping("/exTemplate")
	public void exTemplate() {
		log.info("exTemplate .......");
	}
	
}
