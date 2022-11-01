package com.boot.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dto.CartDetailDto;
import com.boot.dto.CartItemDto;
import com.boot.entity.Cart;
import com.boot.entity.CartItem;
import com.boot.entity.Item;
import com.boot.entity.Member;
import com.boot.repository.CartItemRepository;
import com.boot.repository.CartRepository;
import com.boot.repository.ItemRepository;
import com.boot.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CartService {

	private final CartRepository cartRepository;
	private final CartItemRepository cartItemRepository;
	private final MemberRepository memberRepository;
	private final ItemRepository itemRepository;
	
	public Long addCart(CartItemDto cartItemDto, String email) {
		Item item = itemRepository.findById(cartItemDto.getItemId()).orElseThrow(EntityNotFoundException::new);
		Member member = memberRepository.findByEmail(email).get();
		
		Optional<Cart> optionalCart = cartRepository.findByMemberId(member.getId());
		Cart cart = optionalCart.isPresent()? optionalCart.get():cartRepository.save(Cart.createCart(member));

		Optional<CartItem> optionalCartItem =cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());
		CartItem cartItem = optionalCartItem.isPresent()? optionalCartItem.get():CartItem.createCartItem(cart, item, 0);
		cartItem.addCount(cartItemDto.getCount());
		cartItem = cartItemRepository.save(cartItem);
		return cartItem.getId();
	}
	
	public List<CartDetailDto> getCart(String email){
		Member member = memberRepository.findByEmail(email).get();
		Cart cart = cartRepository.findByMemberId(member.getId())
				.orElseGet(()->cartRepository.save(Cart.createCart(member)));
		List<CartDetailDto> list = cartItemRepository.findCartDetailDtoList(cart.getId());
		return list;
	}
	
	public void updateCart(Long itemId, int count, String email) {
		CartItem cartItem = cartItemRepository.findById(itemId)
				.orElseThrow(EntityNotFoundException::new);
		Member member = memberRepository.findByEmail(email).get();
		Cart cart = cartRepository.findByMemberId(member.getId())
				.orElseThrow(EntityNotFoundException::new);
		if(cartItem.getCart().getId() == cart.getId()) {
			cartItem.updateCount(count);
			cartItemRepository.save(cartItem);
		}else {
			throw new EntityNotFoundException("타인의 장바구니는 수정할수 없습니다");
		}
	}
	
	public void deleteCart(Long itemId, String email) {
		CartItem cartItem = cartItemRepository.findById(itemId)
				.orElseThrow(EntityNotFoundException::new);
		Member member = memberRepository.findByEmail(email).get();
		Cart cart = cartRepository.findByMemberId(member.getId())
				.orElseThrow(EntityNotFoundException::new);
		if(cartItem.getCart().getId() == cart.getId()) {
			cartItemRepository.delete(cartItem);
		}else {
			throw new EntityNotFoundException("타인의 장바구니는 삭제할수 없습니다");
		}
	}
	
	public void deleteCartAll(String email) {
		Member member = memberRepository.findByEmail(email).get();
		Cart cart = cartRepository.findByMemberId(member.getId())
				.orElseThrow(EntityNotFoundException::new);
		int count = cartItemRepository.deleteByCartId(cart.getId());
		System.out.println("delete cartItem: "+count);
	}
	
}
