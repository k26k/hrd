package com.boot.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.constant.SellStatus;
import com.boot.entity.Item;

@SpringBootTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item createItem(int i) {
		Item item = Item.builder()
				.itemName("테스트 상품 "+i)
				.price(10000+i*100)
				.stockNumber(10+i/10)
				.itemDetail(i+"번 테스트 상품 입니다.")
				.sellStatus(SellStatus.SELL)
				.build();
		return item;
	}
	
//	@Test
//	public void addItem() {
//		IntStream.rangeClosed(1, 100).forEach( i ->{
//		Item item = this.createItem(i);
//		
//		Item savedItem = itemRepository.save(item);
//		
//		System.out.println(savedItem.toString());	
//		});
//	}
	
}
