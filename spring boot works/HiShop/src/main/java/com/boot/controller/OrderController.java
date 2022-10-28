package com.boot.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dto.OrderDto;
import com.boot.dto.OrderHistoryDto;
import com.boot.entity.Orders;
import com.boot.service.MemberService;
import com.boot.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {

	private final OrderService orderService;
	
	@ResponseBody
	@PostMapping("/order")
	public ResponseEntity<?> order(@Valid OrderDto orderDto, BindingResult bindingResult, Authentication authentication) {
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for(FieldError error : bindingResult.getFieldErrors()) {
				sb.append(error.getDefaultMessage());
			}
			return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		String email = authentication.getName();
		Long orderId = orderService.order(orderDto, email);
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}
	
	@GetMapping("/order/history")
	public String orderHistory(Authentication authentication, Model model) {
		String email = authentication.getName();
		Pageable pageable = PageRequest.of(0, 30);
		Page<OrderHistoryDto> page = orderService.getOrderList(email, pageable);
		model.addAttribute("orderPage", page);
		return "order/orderHistory";
	}
	
	@GetMapping("/order/cancle/{id}")
	public String orderCancle(@PathVariable(name = "id") Long id, Authentication authentication, Model model) {
		String email = authentication.getName();
		orderService.cancleOrder(email, id);
		return "redirect:/order/history";
	}
}
