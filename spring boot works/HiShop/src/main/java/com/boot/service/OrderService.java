package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.boot.dto.OrderDto;
import com.boot.entity.Item;
import com.boot.entity.Member;
import com.boot.entity.OrderItem;
import com.boot.entity.Orders;
import com.boot.repository.ItemRepository;
import com.boot.repository.MemberRepository;
import com.boot.repository.OrdersRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderService {

	private final OrdersRepository ordersRepository;
	private final ItemRepository itemRepository;
	private final MemberRepository memberRepository;
	
	public Long order(OrderDto orderDto, String email) {
		Item item = itemRepository.findById(orderDto.getItemId())
				.orElseThrow(EntityNotFoundException::new);
		
		Member member = memberRepository.findByEmail(email).get();
		
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
		orderItemList.add(orderItem);
		
		Orders order = Orders.createOrder(member, orderItemList);
		ordersRepository.save(order);
		
		return order.getId();
	}
	
}
