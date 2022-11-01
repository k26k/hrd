package com.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.dto.CartDetailDto;
import com.boot.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	
	@Query("SELECT new com.boot.dto.CartDetailDto(ci.id, i.itemName, i.price, ci.count, im.imageUrl) "
			+ "FROM CartItem ci, ItemImage im JOIN ci.item i "
			+ "WHERE ci.cart.id = :cartId "
			+ "AND ci.item.id = im.item.id "
			+ "AND im.repImgYn = 'Y' "
			+ "ORDER BY ci.updateTime DESC ")
	public List<CartDetailDto> findCartDetailDtoList(Long cartId);
	
	public Optional<CartItem> findByCartIdAndItemId(Long cartId, Long itemId);
	
	public int deleteByCartId(Long cartId);
	
}
