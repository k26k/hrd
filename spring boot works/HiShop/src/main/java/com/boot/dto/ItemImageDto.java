package com.boot.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.boot.entity.Item;
import com.boot.entity.ItemImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ItemImageDto {

	private Long id;
	
	private String imageName;

	private String originName;
	
	private String imageUrl;
	
	private String repImgYn;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static ItemImageDto of(ItemImage itemImage) {
		return modelMapper.map(itemImage, ItemImageDto.class);
	}
	
}
