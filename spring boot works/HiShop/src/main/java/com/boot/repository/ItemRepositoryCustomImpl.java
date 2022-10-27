package com.boot.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.boot.constant.SellStatus;
import com.boot.dto.ItemSearchDto;
import com.boot.dto.ItemViewDto;
import com.boot.dto.QItemViewDto;
import com.boot.entity.Item;
import com.boot.entity.QItem;
import com.boot.entity.QItemImage;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

	private JPAQueryFactory queryFactory;
	
	public ItemRepositoryCustomImpl(EntityManager entityManager) {
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	private BooleanExpression searchSellStatusEq(SellStatus searchSellStatus) {
		return searchSellStatus==null? null:(
				searchSellStatus==SellStatus.ALL? null:QItem.item.sellStatus.eq(searchSellStatus));
	}
	
	private BooleanExpression searchRegTimeAfter(String searchDateType) {
		LocalDateTime localDate = LocalDateTime.now();
		
		if(StringUtils.equals("all", searchDateType)) {
			return null;
		}else if(StringUtils.equals("1d", searchDateType)) {
			localDate = localDate.minusDays(1);
		}else if(StringUtils.equals("1w", searchDateType)) {
			localDate = localDate.minusWeeks(1);
		}else if(StringUtils.equals("1m", searchDateType)) {
			localDate = localDate.minusMonths(1);
		}else if(StringUtils.equals("6m", searchDateType)) {
			localDate = localDate.minusMonths(6);
		}else if(StringUtils.equals("1y", searchDateType)) {
			localDate = localDate.minusYears(1);
		}else {
			return null;
		}
		
		return QItem.item.regTime.after(localDate);
	}
	
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(searchQuery == null) {
			return null;
		}
		
		if(StringUtils.equals("itemName", searchBy)) {
			return QItem.item.itemName.like("%"+searchQuery+"%");
		}else if(StringUtils.equals("price", searchBy)) {
			return QItem.item.price.like("%"+searchQuery+"%");
		}else if(StringUtils.equals("itemDetail", searchBy)) {
			return QItem.item.itemDetail.like("%"+searchQuery+"%");
		}else if(StringUtils.equals("createdBy", searchBy)) {
			return QItem.item.createdBy.like("%"+searchQuery+"%");
		}
		return null;
	}
	
	private BooleanExpression itemNameLike(String searchQuery){
        return StringUtils.isEmpty(searchQuery) ? null : QItem.item.itemName.like("%" + searchQuery + "%");
    }
	
	@Override
	public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
		
		System.out.println("\n\n getAdminItemPage start \n\n");
		
		List<Item> content = queryFactory
				.selectFrom(QItem.item)
				.where(this.searchSellStatusEq(itemSearchDto.getSellStatus())
						, this.searchRegTimeAfter(itemSearchDto.getSearchDateType())
						, this.searchByLike(itemSearchDto.getSearchBy(), itemSearchDto.getSearchQuery()))
				.orderBy(QItem.item.id.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
		
		long total = queryFactory
				.select(Wildcard.count)
				.from(QItem.item)
				.where(this.searchSellStatusEq(itemSearchDto.getSellStatus())
						, this.searchRegTimeAfter(itemSearchDto.getSearchDateType())
						, this.searchByLike(itemSearchDto.getSearchBy(), itemSearchDto.getSearchQuery()))
				.fetchOne();
		
		System.out.println("getAdminItemPage total: "+total);
		
		Page<Item> page = new PageImpl<Item>(content, pageable, total);
		
		return page;
	}

	@Override
	public Page<ItemViewDto> getItemViewPage(ItemSearchDto itemSearchDto, Pageable pageable) {

		QItem item = QItem.item;
        QItemImage itemImage = QItemImage.itemImage;
		
		List<ItemViewDto> content = queryFactory.select(
					new QItemViewDto(
						item.id,
						item.itemName,
						item.price,
						item.stockNumber,
						item.itemDetail,
						item.sellStatus,
						itemImage.imageUrl)
				).from(itemImage)
				.join(itemImage.item, item)
				.where(itemImage.repImgYn.eq("Y"))
				.where(this.itemNameLike(itemSearchDto.getSearchQuery()))
				.orderBy(item.id.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
		
		long total = queryFactory
				.select(Wildcard.count)
				.from(itemImage)
				.join(itemImage.item, item)
				.where(itemImage.repImgYn.eq("Y"))
				.where(this.itemNameLike(itemSearchDto.getSearchQuery()))
				.fetchOne();
		
		return new PageImpl<ItemViewDto>(content, pageable, total);
	}
	
}
