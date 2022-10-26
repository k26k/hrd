package com.boot.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.boot.constant.SellStatus;
import com.boot.entity.Item;
import com.querydsl.core.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ItemViewDto {
	
	private Long id;

	private String itemName;

	private Integer price;
	
	private Integer stockNumber;
	
	private String itemDetail;
	
	private SellStatus sellStatus;
	
	private String imageUrl;
	
	@QueryProjection
	public ItemViewDto(
			Long id, String itemName, Integer price, Integer stockNumber
			, String itemDetail, SellStatus sellStatus, String imageUrl) {
		
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.stockNumber = stockNumber;
		this.itemDetail = itemDetail;
		this.sellStatus = sellStatus;
		this.imageUrl = imageUrl;
	}
	
}
