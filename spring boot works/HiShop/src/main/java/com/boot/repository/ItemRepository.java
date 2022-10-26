package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.boot.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom  {

	public Page<Item> findByItemNameContains(String itemName, Pageable pageable);
 
	public Page<Item> findByPriceLessThanOrderByPrice(Integer price, Pageable pageable);
	
}
