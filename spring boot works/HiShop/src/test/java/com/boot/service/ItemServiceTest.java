package com.boot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.multipart.MultipartFile;

import com.boot.constant.SellStatus;
import com.boot.dto.ItemFormDto;
import com.boot.entity.Item;

@SpringBootTest
public class ItemServiceTest {

	@Autowired
	private ItemService itemService;
	
	private List<MultipartFile> createMultipartFileList(){
		List<MultipartFile> multipartFileList = new ArrayList<MultipartFile>();
		
		for(int i=1; i<=5; i++) {
			String name = "image"+i;
			String originalName = "image" + i + ".jpg";
			MockMultipartFile multipartFile = 
					new MockMultipartFile(name, originalName, "image/jpg", new byte[] {1,2,3,4});
			
			multipartFileList.add(multipartFile);
		}
		
		return multipartFileList;
	}
	
//	@Test
//	@WithMockUser(username = "admin", roles = "ADMIN")
//	public void saveItem() throws IOException {
//		ItemFormDto itemFormDto = ItemFormDto.builder()
//				.itemName("테스트 상품")
//				.price(10000)
//				.stockNumber(10)
//				.itemDetail("테스트 상품 입니다.")
//				.sellStatus(SellStatus.SELL)
//				.build();
//		
//		Long itemId = itemService.saveItem(itemFormDto, this.createMultipartFileList());
//		System.out.println("TEST saveItem() itemId: "+itemId);
//	}
	
//	@Test
//	public void getItemFormDtoPageTest() {
//		Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "id"));
//		Page<ItemFormDto> page = itemService.getItemFormDtoPage(pageable);
//		System.out.println(page.toString());
//		page.getContent().forEach(dto->{System.out.println(dto.toString());});
//	}
	
	
}
