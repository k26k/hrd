package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dto.CartItemDto;
import com.boot.service.CartService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CartController {

	private final CartService cartService;
	
	@ResponseBody
	@PostMapping("/cart/add")
	public ResponseEntity<?> addCart(@Valid CartItemDto cartItemDto, BindingResult bindingResult, Authentication authentication){
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for(FieldError error : bindingResult.getFieldErrors()) {
				sb.append(error.getDefaultMessage());
			}
			return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		String email = authentication.getName();
		Long cartItemId = cartService.addCart(cartItemDto, email);
		return new ResponseEntity<>(cartItemId, HttpStatus.OK);
	}
	
	@GetMapping("/cart/list")
	public String getCart(Authentication authentication, Model model) {
		String email = authentication.getName();
		model.addAttribute("cartList", cartService.getCart(email));
		return "cart/cartList";
	}
	
	@GetMapping("/cart/update/{item}/{count}")
	public String updateCart(@PathVariable(name = "item") Long itemId, @PathVariable(name = "count") int count,Authentication authentication) {
		cartService.updateCart(itemId, count, authentication.getName());
		return "redirect:/cart/list";
	}
	
	@GetMapping("/cart/delete/{item}")
	public String deleteCart(@PathVariable(name = "item") Long itemId, Authentication authentication) {
		cartService.deleteCart(itemId, authentication.getName());
		return "redirect:/cart/list";
	}
	
	@GetMapping("/cart/deleteAll")
	public String deleteCartAll(Authentication authentication) {
		cartService.deleteCartAll(authentication.getName());
		return "redirect:/cart/list";
	}
	
	@ResponseBody
	@PostMapping("/cart/order")
	public ResponseEntity<?> orderCart( List<Long> data, Authentication authentication) {
		System.out.println(data.toString());
		return new ResponseEntity<>("", HttpStatus.OK);
	}
}
