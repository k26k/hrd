package com.boot.dto;

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
public class CartDetailDto {
	
	private Long cartItemId;  //장바구니 상품 아이디
	
	private String itemNm; //상품명
	
	private int price; //상품 금액
	
	private int count; //수량
	
	private String imgUrl;  //상품 이미지 정보

	//생성자
	public CartDetailDto(Long cartItemId, String itemNm, int price, int count, String imgUrl) {
		super();
		this.cartItemId = cartItemId;
		this.itemNm = itemNm;
		this.price = price;
		this.count = count;
		this.imgUrl = imgUrl;
	}
}
