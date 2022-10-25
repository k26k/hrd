package com.boot.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.boot.constant.SellStatus;
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
public class ItemFormDto {

	private Long id;

	@NotBlank(message = "상품명은 필수 입력 값입니다.")
	private String itemName;

	@NotNull(message = "상품 가격은 필수 입력 값입니다.")
	private Integer price;
	
	@NotNull(message = "상품 재고 수량은 필수 입력 값입니다.")
	private Integer stockNumber;
	
	@NotBlank(message = "상품 상세설명은 필수 입력 값입니다.")
	private String itemDetail;
	
	@NotBlank(message = "상품 상태는 필수 입력 값입니다.")
	private SellStatus sellStatus;
	
	private List<ItemImageDto> itemImageDtoList;
	
	private List<Long> itemImageDtoIdList;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static ItemFormDto createDto(Item item) {
		return modelMapper.map(item, ItemFormDto.class);
	}
	
	public Item createItem() {
		return modelMapper.map(this, Item.class);
	}
	
}
