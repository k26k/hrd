package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	public List<OrderItem> findByOrdersIdOrderByIdDesc(Long ordersId);
	
}
