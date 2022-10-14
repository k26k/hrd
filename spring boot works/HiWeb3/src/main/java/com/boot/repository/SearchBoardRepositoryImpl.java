package com.boot.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.boot.entity.Board;
import com.boot.entity.QBoard;
import com.boot.entity.QMember;
import com.boot.entity.QReply;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;

@Repository
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

	public SearchBoardRepositoryImpl() {
		super(Board.class);
	}

	@Override
	public List<Tuple> searchList() {
		QBoard qBoard = QBoard.board;
		QMember qMember = QMember.member;
//		QReply qReply = QReply.reply;
		
		JPQLQuery<Board> jpqlQuery = from(qBoard);
		jpqlQuery.leftJoin(qMember).on(qBoard.writer.eq(qMember));
//		jpqlQuery.leftJoin(qReply).on(qReply.board.eq(qBoard));
		jpqlQuery.groupBy(qBoard);
		
		JPQLQuery<Tuple> jpqlQuery2 = jpqlQuery.select(qBoard, qMember);
//		JPQLQuery<Tuple> jpqlQuery2 = jpqlQuery.select(qBoard, qMember, qReply.count());
		
		List<Tuple> tuples = jpqlQuery2.fetch();
		
		return tuples;
	}

	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		QBoard qBoard = QBoard.board;
		QMember qMember = QMember.member;
//		QReply qReply = QReply.reply;
		
		JPQLQuery<Board> jpqlQuery = from(qBoard);
		jpqlQuery.leftJoin(qMember).on(qBoard.writer.eq(qMember));
//		jpqlQuery.leftJoin(qReply).on(qReply.board.eq(qBoard));
		jpqlQuery.groupBy(qBoard);
		
		JPQLQuery<Tuple> jpqlQuery2 = jpqlQuery.select(qBoard, qMember);
//		JPQLQuery<Tuple> jpqlQuery2 = jpqlQuery.select(qBoard, qMember, qReply.count());
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		BooleanExpression booleanExpression = qBoard.bno.gt(0L);
		
		booleanBuilder.and(booleanExpression);
		
		if(type != null) {
			String[] types = type.split("/");
			BooleanBuilder conditonBuiler = new BooleanBuilder();
			
			for(String t : types) {
				switch (t) {
				case "t":
					conditonBuiler.or(qBoard.title.contains(keyword));
					break;

				case "c":
					conditonBuiler.or(qBoard.content.contains(keyword));
					break;
				
				case "w":
					conditonBuiler.or(qBoard.writer.name.contains(keyword));
					break;

				default:
					break;
				}
			}
			
			booleanBuilder.and(conditonBuiler);
		}
		
		jpqlQuery2.where(booleanBuilder);
		
		Sort sort = pageable.getSort();
		sort.stream().forEach( order -> {
			Order direction = order.isAscending() ? Order.ASC : Order.DESC;
			String prop = order.getProperty();
			
			PathBuilder orderByExpression = new PathBuilder(Board.class, "board");
			jpqlQuery2.orderBy(new OrderSpecifier<>(direction, orderByExpression.get(prop)));			
		});
		
		jpqlQuery2.groupBy(qBoard);
		
		jpqlQuery2.offset(pageable.getOffset());
		jpqlQuery2.limit(pageable.getPageSize());
		
		List<Tuple> tuples = jpqlQuery2.fetch();
		
		tuples.forEach(t->System.out.println(t.toString()));
		
		long count = jpqlQuery2.fetchCount();
		
		return new PageImpl<Object[]>(
				tuples.stream().map(t -> t.toArray()).collect(Collectors.toList())
				, pageable
				, count);
	}

}
