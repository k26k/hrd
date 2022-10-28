package com.boot.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import com.boot.config.BaseEntity;
import com.boot.constant.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderItemList"})
@Setter
@Getter
@Entity
public class Orders extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orders_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
//	cascade = 종속성 설정, orders 삭제시 연관된 orderItemList 함께 삭제
	private List<OrderItem> orderItemList = new ArrayList<OrderItem>();

	public void addOrderItem(OrderItem orderItem) {
		this.orderItemList.add(orderItem);
		orderItem.setOrders(this);
	}
	
	public static Orders createOrder(Member member, List<OrderItem> orderItemList) {
		Orders orders = new Orders();
		orders.setMember(member);
		orders.setOrderDate(LocalDateTime.now());
		orders.setOrderStatus(OrderStatus.ORDER);
		
		System.out.println("orderItemList: "+orders.getOrderItemList().toString());
		
		orderItemList.forEach(orderItem->{orders.addOrderItem(orderItem);});
		
		return orders;
	}
	
}
