package com.boot.dto;

import com.boot.entity.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class OrderItemDto {
	
	private Long id;
	
	private String name;
	
	private int price;
	
	private int count;

	private int totalPrice;

	public static OrderItemDto creat(OrderItem orderItem) {
		OrderItemDto orderItemDto = OrderItemDto.builder()
				.id(orderItem.getId())
				.name(orderItem.getItem().getItemName())
				.price(orderItem.getOrderPrice())
				.count(orderItem.getCount())
				.totalPrice(orderItem.getTotalPrice())
				.build();
		return orderItemDto;
	}
	
}
