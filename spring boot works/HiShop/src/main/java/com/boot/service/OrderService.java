package com.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.constant.OrderStatus;
import com.boot.dto.OrderDto;
import com.boot.dto.OrderHistoryDto;
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
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), orderDto.getCount());
		orderItemList.add(orderItem);
		
		Orders order = Orders.createOrder(member, orderItemList);
		ordersRepository.save(order);
		
		return order.getId();
	}
	
	public Page<OrderHistoryDto> getOrderList(String email, Pageable pageable){
		Member member = memberRepository.findByEmail(email).get();
		Page<Orders> page = ordersRepository.findByMemberIdAndOrderStatusOrderByIdDesc(member.getId(), OrderStatus.ORDER, pageable);
		List<OrderHistoryDto> dtoList = page.getContent().stream().map(order->{return OrderHistoryDto.crateDto(order);}).collect(Collectors.toList());	
		Page<OrderHistoryDto> dtoPage = new PageImpl<OrderHistoryDto>(dtoList, pageable, page.getTotalElements());
		return dtoPage;
	}
	
	@Transactional(readOnly = false)
	public boolean cancleOrder(String email, Long id) {
		Member member = memberRepository.findByEmail(email).get();
		Orders orders = ordersRepository.findById(id).get();
		if(!orders.getMember().getId().equals(member.getId())) {
			return false;
		}
		
		orders.setOrderStatus(OrderStatus.CANCEL);
		for(int i=0; i<orders.getOrderItemList().size(); i++) {
			orders.getOrderItemList().get(i).cancle();
		}
		ordersRepository.save(orders);
		
		return true;
	}
	
}
