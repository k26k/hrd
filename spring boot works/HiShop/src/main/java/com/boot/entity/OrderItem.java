package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@ToString(exclude = {"item", "orders"})
@Setter
@Getter
@Entity
public class OrderItem extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_item_id")
	private Long id;
	
	private int orderPrice;
	
	private int count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id")
	private Orders orders;
	
	public static OrderItem createOrderItem(Item item, int price, int count) {
		OrderItem orderItem = OrderItem.builder()
				.item(item)
				.orderPrice(price)
				.count(count)
				.build();
		item.removeStock(count);
		return orderItem;
	}
	
	public int getTotalPrice() {
		return orderPrice * count;
	}
	
	public void cancle() {
		this.item.addStock(count);
	}
	
}
