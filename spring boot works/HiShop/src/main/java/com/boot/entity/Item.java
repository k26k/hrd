package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.boot.config.BaseEntity;
import com.boot.constant.SellStatus;
import com.boot.dto.ItemFormDto;
import com.boot.exception.OutOfStockException;

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
@Entity
public class Item extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long id;

	@Column(nullable = false, length = 50)
	private String itemName;

	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer stockNumber;
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;
	
	@Enumerated(EnumType.STRING)
	private SellStatus sellStatus;
	
	//상품 수정 메서드
	public void updateItem(ItemFormDto itemFormDto) {
		this.itemName = itemFormDto.getItemName();
		this.price = itemFormDto.getPrice();
		this.stockNumber = itemFormDto.getStockNumber();
		this.itemDetail = itemFormDto.getItemDetail();
		this.sellStatus = itemFormDto.getSellStatus();	
	}
	
	public void removeStock(int buyNumber) {
		if(this.stockNumber < buyNumber) {
			throw new OutOfStockException("재고 수량 부족 오류. 재고: "
					+this.stockNumber+", 구매량: "+buyNumber);
		}else if(stockNumber == buyNumber) {
			this.sellStatus = SellStatus.SOLD_OUT;
		}
		this.stockNumber -= buyNumber;
	}
	
	public void addStock(int addNumber) {
		this.stockNumber += addNumber;
		if(this.stockNumber>0) {
			this.sellStatus = SellStatus.SELL;
		}
	}
	
}
