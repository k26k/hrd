package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.ItemImage;

public interface ItemImageRepository extends JpaRepository<ItemImage, Long> {

	List<ItemImage> findByItemIdOrderById(Long Id);
	
}
