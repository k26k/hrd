package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.dto.ItemSearchDto;
import com.boot.dto.ItemViewDto;
import com.boot.entity.Item;

public interface ItemRepositoryCustom {

//	상품 조회 조건을 담고 있는 itemSearchDto 객체와
//	페이징 정보를 담고있는 pageable 객체를 파라미터로 함
	Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

	Page<ItemViewDto> getItemViewPage(ItemSearchDto itemSearchDto, Pageable pageable);
	
}
