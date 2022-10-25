package com.boot.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.boot.dto.AjaxResultDto;
import com.boot.dto.ItemFormDto;
import com.boot.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ItemController {

	private final ItemService itemService;
	
	
	@GetMapping("/admin/item/new")
	public String newItemForm(Model model) {
		model.addAttribute("itemFormDto", new ItemFormDto());
		return "item/itemForm";
	}
	
	@ResponseBody
	@PostMapping("/admin/item/new")
	public AjaxResultDto newItemProcess(ItemFormDto itemFormDto
			, @RequestParam("itemImageFile") List<MultipartFile> itemImgFileList) throws IOException {
		
		Long itemId = itemService.saveItem(itemFormDto, itemImgFileList);
		if(itemId != null ) {
			AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
					.result(true)
					.message("상품 등록 성공!")
					.redirectLink("/admin/item/view/"+itemId)
					.build();

			return ajaxResultDto;
		}
		
		AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
				.result(false)
				.message("상품 등록 실패")
				.build();
		return ajaxResultDto;
	}
	
	
	@GetMapping("/admin/item/view/{itemId}")
	public String viewItemForm(@PathVariable(name = "itemId") Long itemId, Model model) {
		model.addAttribute("itemFormDto", itemService.getItemFormDtoById(itemId));
		return "item/itemForm";
	}
	
	@ResponseBody
	@PostMapping("/admin/item/update/{itemId}")
	public AjaxResultDto updateItem(@PathVariable(name = "itemId") Long itemId, ItemFormDto itemFormDto
			, @RequestParam("itemImageFile") List<MultipartFile> itemImgFileList, Model model) throws IOException {
//		model.addAttribute("itemFormDto", itemService.getItemFormDtoById(itemId));
		
		if(itemService.updateItem(itemFormDto, itemImgFileList)) {
			AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
					.result(true)
					.message("상품 수정 성공")
					.redirectLink("/admin/item/view/"+itemId)
					.build();
			return ajaxResultDto;
		}
		
		AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
				.result(false)
				.message("상품 수정 실패")
				.build();
		return ajaxResultDto;
	}
	
}
