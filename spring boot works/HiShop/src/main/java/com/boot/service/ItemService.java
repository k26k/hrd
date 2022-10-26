package com.boot.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.boot.dto.ItemFormDto;
import com.boot.dto.ItemImageDto;
import com.boot.dto.ItemSearchDto;
import com.boot.dto.ItemViewDto;
import com.boot.entity.Item;
import com.boot.entity.ItemImage;
import com.boot.entity.QItem;
import com.boot.repository.ItemRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {

	private final ItemRepository itemRepository;
	private final ItemImageService itemImageService;
	

	
	public ItemFormDto getItemFormDtoById(Long id) {
		Optional<Item> optional = itemRepository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}
		ItemFormDto itemFormDto = ItemFormDto.createDto(optional.get());
		List<ItemImageDto> itemImageDtoList = itemImageService.getItemImageDtoListByItemId(id);
		itemFormDto.setItemImageDtoList(itemImageDtoList);
		return itemFormDto;
	}
	
	
	public Page<ItemFormDto> getItemFormDtoPage(Pageable pageable){
		Page<Item> itemPage = itemRepository.findAll(pageable);
		Function<Item, ItemFormDto> function = (item->{ 
			ItemFormDto itemFormDto = ItemFormDto.createDto(item);
			List<ItemImageDto> itemImageDtoList = itemImageService.getItemImageDtoListByItemId(item.getId());
			itemFormDto.setItemImageDtoList(itemImageDtoList);
			return itemFormDto;
		});
		List<ItemFormDto> itemFormDtoList = itemPage.getContent().stream().map(function).collect(Collectors.toList());
		
		Page<ItemFormDto> ItemFormDtoPage = new PageImpl<ItemFormDto>(itemFormDtoList, pageable, itemPage.getTotalPages());
		return ItemFormDtoPage;
	}
	
	public Page<ItemFormDto> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable){
		Page<Item> itemPage = itemRepository.getAdminItemPage(itemSearchDto, pageable);
		Function<Item, ItemFormDto> function = (item->{ 
			ItemFormDto itemFormDto = ItemFormDto.createDto(item);
			List<ItemImageDto> itemImageDtoList = itemImageService.getItemImageDtoListByItemId(item.getId());
			itemFormDto.setItemImageDtoList(itemImageDtoList);
			return itemFormDto;
		});
		List<ItemFormDto> itemFormDtoList = itemPage.getContent().stream().map(function).collect(Collectors.toList());
		
		Page<ItemFormDto> ItemFormDtoPage = new PageImpl<ItemFormDto>(itemFormDtoList, pageable, itemPage.getTotalElements());
		return ItemFormDtoPage;
	}
	
	public Page<ItemViewDto> getItemViewDto(ItemSearchDto itemSearchDto, Pageable pageable){
		Page<ItemViewDto> page = itemRepository.getItemViewPage(itemSearchDto, pageable);
		return page;
	}
	
	public Long saveItem(ItemFormDto itemDto
			, List<MultipartFile> itemImageFileList) throws IOException {
		
		Item item = itemDto.createItem();
		item = itemRepository.save(item);
		
		boolean repCheck = true;
		
		for(MultipartFile itemImageFile : itemImageFileList) {
			ItemImage itemImage = ItemImage.builder()
					.item(item)
					.repImgYn(repCheck? "Y":"N")
					.build();
			
			repCheck = false;
			
			itemImageService.saveItemImage(itemImage, itemImageFile);
		}
		
		
		return item.getId();
	}
		
		
	public boolean updateItem(ItemFormDto itemFormDto
			, List<MultipartFile> itemImageFileList) throws IOException {
		Optional<Item> optional = itemRepository.findById(itemFormDto.getId());
		if(!optional.isPresent()) {
			return false;
		}
		Item originItem = optional.get();
		Item item = itemFormDto.createItem();
		originItem.setSellStatus(item.getSellStatus());
		originItem.setItemName(item.getItemName());
		originItem.setPrice(item.getPrice());
		originItem.setStockNumber(item.getStockNumber());
		originItem.setItemDetail(item.getItemDetail());
		itemRepository.save(originItem);
		
		List<ItemImage> itemImageList = itemImageService.getItemImageListByItemId(originItem.getId());
		boolean repCheck = true;
		
		for(int i=0; i<5; i++) {
			ItemImage itemImage = itemImageList.get(i);
			itemImage.setRepImgYn(repCheck? "Y":"N");
			repCheck = false;
			MultipartFile itemImageFile = itemImageFileList.get(i);
			itemImageService.updateItemImage(itemImage, itemImageFile);
		}
		
		return true;
	}

	
	public boolean deleteItem(Long itemId) {
		itemImageService.deleteItemImage(itemId);
		itemRepository.deleteById(itemId);
		return true;
	}
	
}
