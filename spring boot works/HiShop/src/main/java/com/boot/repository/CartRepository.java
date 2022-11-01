package com.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	public Optional<Cart> findByMemberId(Long memberId);
	
}
