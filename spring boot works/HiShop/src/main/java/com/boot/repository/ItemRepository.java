package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>  {

	public Page<Item> findByItemNameContains(String itemName, Pageable pageable);

	public Page<Item> findByPriceLessThanOrderByPrice(Integer price, Pageable pageable);
	
}
