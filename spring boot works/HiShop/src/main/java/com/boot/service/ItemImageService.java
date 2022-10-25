package com.boot.service;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.boot.dto.ItemImageDto;
import com.boot.entity.ItemImage;
import com.boot.repository.ItemImageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemImageService {

	@Value("${itemImageLocaiotn}")
	private String itemImageLocaiotn;
	
	private final ItemImageRepository itemImageRepository;
	
	private final FileService fileService;
	
	public void saveItemImage(ItemImage itemImage
			, MultipartFile itemImageFile) throws IOException {
		
		String originName = itemImageFile.getOriginalFilename();
		String imageName = "";
		String imageUrl = "";
		
		if(!StringUtils.isEmpty(originName)) {
			imageName = fileService.uploadFile(itemImageLocaiotn
					, originName
					, itemImageFile.getBytes());
			imageUrl = "/images/item/"+imageName;
			itemImage.setImageName(imageName);
		}
		
		itemImage.updateItemImage(imageName, originName, imageUrl);
        itemImageRepository.save(itemImage);
	}
	
	public List<ItemImage> getItemImageListByItemId(Long id){
		List<ItemImage> imageList = itemImageRepository.findByItemIdOrderById(id);
		return imageList;
	}
	
	public List<ItemImageDto> getItemImageDtoListByItemId(Long id){
		List<ItemImage> imageList = itemImageRepository.findByItemIdOrderById(id);
		Function<ItemImage, ItemImageDto> func = (i->{return ItemImageDto.of(i);});
		List<ItemImageDto> imageDtoList = imageList.stream()
				.map(func).collect(Collectors.toList());
		return imageDtoList;
	}
	
	public boolean updateItemImage(ItemImage itemImage
			, MultipartFile itemImageFile) throws IOException {
		
		if(itemImage.getImageName() != null && !itemImage.getImageName().equals("")) {
			fileService.deleteFile(itemImageLocaiotn+"/"+itemImage.getImageName());
		}
		
		String originName = itemImageFile.getOriginalFilename();
		String imageName = "";
		String imageUrl = "";
		
		if(!StringUtils.isEmpty(originName)) {
			imageName = fileService.uploadFile(itemImageLocaiotn
					, originName
					, itemImageFile.getBytes());
			imageUrl = "/images/item/"+imageName;
			itemImage.setImageName(imageName);
		}
		
		itemImage.updateItemImage(imageName, originName, imageUrl);
        itemImageRepository.save(itemImage);
        
        return true;
	}
	
}
