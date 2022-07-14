
-- 뷰(VIEW)
-- 원본데이터 수정 없이 필요한 사용자에게 적절한 데이터를 제공

-- address에 '대한민국'을 포함하는 고객들로만 구성된 뷰를 생성
CREATE VIEW vw_customer
AS  SELECT  *
    FROM    customer
    WHERE   address LIKE '%대한민국%';
    
-- 뷰 조회
SELECT * 
FROM vw_customer;

-- 고객의 이름과 주문한 도서의 이름, 가격을 검색
CREATE VIEW vw_orders 
AS  SELECT customer.name, book.bookname, book.price 
    FROM customer, orders, book
    WHERE   customer.custid = orders.custid
            AND orders.bookid = book.bookid;
            
SELECT *
FROM vw_orders;

-- 뷰 삭제
DROP VIEW vw_customer;