package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.constant.OrderStatus;
import com.boot.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	public Page<Orders> findByMemberIdAndOrderStatusOrderByIdDesc(Long memberId, OrderStatus orderStatus, Pageable pageable); 
	
}
