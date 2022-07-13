
SELECT * FROM customer;
SELECT * FROM orders;
SELECT * FROM book;

-- 서브쿼리(부속 질의)

-- 가장 비싼 도서
SELECT bookname, price
FROM book
WHERE price = (SELECT MAX(price)FROM book);

-- 도서를 구매한 적이 있는 고객의 이름
SELECT name
FROM customer
WHERE custid IN(SELECT custid FROM orders);

-- '박지성' 고객의 주문내역을 검색
SELECT *
FROM orders
WHERE custid = (SELECT custid
                FROM customer
                WHERE name = '박지성');

-- 이상 미디어에서 출판한 도서를 구매한 고객의 이름
SELECT name
FROM customer
WHERE custid IN(SELECT custid 
                FROM orders 
                WHERE bookid IN(SELECT bookid
                                FROM book
                                WHERE publisher = '이상미디어'));
                                
-- 출판사별로 출반사의 평균 도서 가격보다 비싼 도서를 검색하시오
-- 튜플 변수 : 테이블 이름의 별칭
-- WHERE b2.publisher = b1.publisher : 자체 조인
SELECT b1.bookname
FROM book b1
WHERE b1.price > (SELECT AVG(b2.price)
                  FROM book b2
                  WHERE b2.publisher = b1.publisher);


SELECT AVG(price)
FROM book 
GROUP BY publisher;

SELECT bookname
FROM book
WHERE price < ( SELECT AVG(price)
                FROM (  SELECT price
                        FROM book
                        WHERE publisher = 
                        ));


-- 인라인 뷰 - FROM 부속 질의

-- 고객 번호가 2 이하인 고객의 판매액을 검색
SELECT cs.name, SUM(od.saleprice) AS total
FROM (SELECT custid, name
      FROM customer
      WHERE custid <= 2) cs,
     orders od
WHERE cs.custid = od.custid
GROUP BY cs.name;



