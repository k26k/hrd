-- 전체 조회
SELECT * FROM book;

-- 모든 도서의 이름과 가격을 조회
SELECT bookname, price FROM book;

-- 모든 도서의 도서 번호, 도서이름, 출판사, 가격 조회
SELECT bookid, bookname, publisher, price FROM book;

-- 모든 도서의 출판사 조회
SELECT publisher FROM book;

-- 모든 도서의 출판사 조회 (중복 제거 - DISTINCT)
SELECT DISTINCT publisher FROM book;

-- 조건절 WHERE 사용

--가격이 20000원 미만인 도서 검색
SELECT *
FROM book
WHERE price < 20000;

--가격이 10000원 이상 20000원 이하인 도서 검색
-- 범위 : BETWEEN 최소 AND 최대
SELECT *
FROM book
WHERE price BETWEEN 10000 and 20000;

SELECT *
FROM book
WHERE 10000 <= price and price <= 20000;

-- IN()
-- 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색
SELECT *
FROM book
WHERE publisher IN('굿스포츠', '대한미디어');

-- 출판사가 '굿스포츠' 혹은 '대한미디어'가 아닌 도서를 검색
SELECT *
FROM book
WHERE publisher NOT IN('굿스포츠', '대한미디어');

-- LIKE 연산자 
-- '축구의 역사'를 출간한 출판사 검색
SELECT bookname, publisher
FROM book
WHERE bookname like '축구의 역사';

-- 도서 이름에 '축구'가 포함된 출판사 검색 
-- '단어%' = 시작 단어
-- '%단어' = 끝 단어
-- '%단어%' = 포함 단어
SELECT bookname, publisher
FROM book
WHERE bookname like '축구%';

SELECT bookname, publisher
FROM book
WHERE bookname like '%축구';

SELECT bookname, publisher
FROM book
WHERE bookname like '%축구%';

-- 축구의 관한 도서중 가격이 20000원 이상인 도서 검색
SELECT bookname, price
FROM book
WHERE bookname like '%축구%' AND 20000 <= price;

-- 정렬하면서 검색
-- ORDER BY
-- 도서를 이름순으로 검색
SELECT *
FROM book
ORDER BY bookname;

-- 도서를 가격순으로 가격이 같으면 이름순으로 검색
SELECT *
FROM book
ORDER BY price, bookname;

-- 도서를 가격의 내림차순으로 가격이 같으면 출판사를 오름차순으로 검색
SELECT *
FROM book
ORDER BY price DESC, bookname ASC;



