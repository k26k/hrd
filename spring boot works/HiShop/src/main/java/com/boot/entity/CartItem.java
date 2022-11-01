package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.boot.config.BaseEntity;

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
public class CartItem extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_item_id")
	private Long id;
	
	private int count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="item_id")
	private Item item;
	
	
	//장바구니에 담을 상품 엔티티 생성 메서드
	public static CartItem createCartItem(Cart cart, Item item, int count) {
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setItem(item);
		cartItem.setCount(count);
		return cartItem;
	}
	
	//해당 상품을 추가로 장바구니에 담을 메서드
	public void addCount(int count) {
		this.count += count;
	}
	
	//장바구니 품목 수량 변경
	public void updateCount(int count) {
		this.count = count;
	}
	
}
