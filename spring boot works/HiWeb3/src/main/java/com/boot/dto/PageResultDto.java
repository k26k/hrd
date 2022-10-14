package com.boot.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class PageResultDto<DTO, EN> {
	
	private List<DTO> dtoList;
	
	private int page;
	private int totalPage;
	private int size;
	private int start, end;
	private boolean prev, next;
	private List<Integer> pageList;
	
	
	public PageResultDto(Page<EN> result, Function<EN ,DTO> fn){
		this.dtoList = result.stream().map(fn).collect(Collectors.toList());
		this.totalPage = result.getTotalPages();
		this.makePageList(result.getPageable());
	}
	
	public void makePageList(Pageable pageable) {
		this.page = pageable.getPageNumber()+1;
		this.size = pageable.getPageSize();
		this.start = 1;
		this.end = totalPage == 0 ? 1:totalPage;
		this.prev = page > start;
		this.next = page < end ;
				
		this.pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
	}
}
