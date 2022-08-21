
-- 모든 고객의 정보
SELECT *
from customer;

-- 고객번호가 3번인 고객의 이름을 검색
SELECT name
FROM customer
WHERE custid = 3;

-- 주소가 대한민국인 고객의 이름과 전화번호를 검색
SELECT name, phone
FROM customer
WHERE address like '%대한민국%';

-- 전화번호가 null인 고객의 이름과 주소를 검색
-- null 검색법 IS NULL 반대는 NOT NULL
SELECT name, address
FROM customer
WHERE phone IS NULL;
