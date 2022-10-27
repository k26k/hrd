package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	public List<Orders> findByMemberIdOrderByIdDesc(Long memberId); 
	
}
