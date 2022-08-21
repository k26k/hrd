
-- 테이블 복사
CREATE TABLE t_book as SELECT * From book;

SELECT * FROM t_book;

-- '축구의 역사'의 가격을 10000원으로 변경 
UPDATE t_book 
SET price = 10000
where bookid = 1;

COMMIT;

-- '양궁의 실체'의 출판사를 '나무수'로 변경
UPDATE t_book
SET publisher = '나무수'
WHERE bookid = 6;

-- '야구를 부탁해' 출판사를 '삼성당'으로 변경하고, 가격을 15000원으로 변경
UPDATE t_book
SET publisher = '삼성당', price = 15000
WHERE bookid = 8;

-- 삭제
-- DELETE FROM 테이블명 = 전체 삭제
-- DELETE FROM 테이블명 WHERE 행조건 = 행 삭제 

-- 도서번호가 5번인 책을 삭제
DELETE
FROM t_book
WHERE bookid = 5;

-- '골프 바이블' 도서를 삭제
DELETE
FROM t_book
WHERE bookname = '골프 바이블';

-- COMMIT전 ROLLBACK시 되돌리기 가능
ROLLBACK;
