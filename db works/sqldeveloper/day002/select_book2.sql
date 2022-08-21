-- 집계함수 SUM, COUNT, AVG
-- 주문 테이블 검색

-- 고객이 주문한 도서의 총 판매액을 구하시오
SELECT SUM(saleprice) AS 총매출
FROM orders;

-- '김연아' 고객이 주문한 도서의 총 판매액을 구하시오
SELECT SUM(saleprice) AS 총매출
FROM orders
WHere custid = 2;

-- 고객이 주문한 도서의 총 매출과 평균값 구하기
SELECT SUM(saleprice) AS Total,
       AVG(saleprice) AS Average
FROM orders;

-- 마당 서점의 도서 판매 건수를 구하시오
SELECT COUNT(*) as 총판매권수
FROM orders;

-- 고객별로 주문한 도서의 총 수량과 판매액을 구하시오
SELECT custid, COUNT(*) 총판매권수, SUM(saleprice) 총액
FROM orders
GROUP BY custid;

-- 가격이 8000원 이상인 도서를 구매한 고객에 대하여 고 객별주문도서의 총 수량을 구하기
-- 단 도서를 두 권 이상 구매한 고객만 구하시오 
-- HAVING은 GROUP BY 결과 나타내는 그룹을 제한함
SELECT custid, COUNT(*) 총판매권수, SUM(saleprice) 총액
FROM orders
WHERE 8000 <= saleprice
GROUP BY custid
HAVING 2 <= count(*);



