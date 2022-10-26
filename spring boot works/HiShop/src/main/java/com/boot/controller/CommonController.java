package com.boot.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.dto.ItemSearchDto;
import com.boot.dto.ItemViewDto;
import com.boot.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommonController {

	private final ItemService itemService;
	
	@GetMapping("/")
	public String index(ItemSearchDto itemSearchDto, Model model) {
		Pageable pageable = PageRequest.of(0, 5);
		Page<ItemViewDto> page = itemService.getItemViewDto(itemSearchDto, pageable);
		page.getContent().forEach(item->{
			System.out.println(item.toString());
		});
		System.out.println(page.getNumberOfElements());
		model.addAttribute("itemPage", page);
		return "index";
	}
	
}
