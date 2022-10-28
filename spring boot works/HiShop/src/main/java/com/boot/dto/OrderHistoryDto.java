package com.boot.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.boot.entity.OrderItem;
import com.boot.entity.Orders;

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
public class OrderHistoryDto {

	private Long orderId;
	
	private List<OrderItemDto> orderItemList;
	
	private LocalDateTime buyDate;
	
	private Integer totalPrice;
	
	public static OrderHistoryDto crateDto(Orders orders) {
		OrderHistoryDto dto = OrderHistoryDto.builder()
				.orderId(orders.getId())
				.orderItemList(orders.getOrderItemList().stream().map(orderItem->{return OrderItemDto.creat(orderItem);}).collect(Collectors.toList()))
				.buyDate(orders.getOrderDate())
				.totalPrice((int)orders.getOrderItemList().stream().map(item->{
					return item.getTotalPrice();
				}).reduce(0, Integer::sum))
				.build();
		return dto;
	}
}
