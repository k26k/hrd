package com.boot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.boot.dto.ItemSearchDto;
import com.boot.dto.OrderDto;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ItemService itemService;
	
	@Test
	public void createOrder() {
		String email = "test@test.com";
		ItemSearchDto itemSearchDto = new ItemSearchDto();
		Pageable pageable = PageRequest.of(0, 1);
		
		Long itemId = itemService.getItemViewDto(itemSearchDto, pageable).getContent().get(0).getId();
		OrderDto orderDto = OrderDto.builder()
				.itemId(itemId)
				.count(1)
				.build();
		Long orderId = orderService.order(orderDto, email);
		System.out.println(orderId);
	}
	
}
