
-- 함수

-- 숫자 관련 함수
-- ROUND 숫자를 반올림한다. ROUND(12.583, 1) 12.6
-- TRUNC 숫자를 절삭한다.(버림) TRUNC(12.583, 1) 12.5
-- MOD 나누기 후 나머지를 구한다 MOD(15, 2) 1
-- CEIL 숫자를 정수로 올림한다. CEIL(15.351) 16
-- FLOOR 숫자를 정수로 내림한다. FLOOR(15.351) 15
-- ABS 절대값을 구한다 ABS(-10) 10
-- POWER 거듭제곱을 구한다. POWER(2, 3) 8
-- SQRT 제곱근을 구한다. SQRT(4) 2

-- dual = 가상 테이블

-- 절대값
SELECT ABS(-10) FROM dual;

-- 소수 첫째 자리까지 반올림
SELECT ROUND(3.875, 1) FROM dual;

-- 반올림 실험
SELECT  ROUND(123.875, -2),
        ROUND(123.875, -1),
        ROUND(123.875, 0),
        ROUND(123.875, 1),
        ROUND(123.875, 2),
        ROUND(123.875, 3)
FROM dual;

-- 고객별 평균 주문 금액을 백원 단위로 반올림한 값을 구하시오
SELECT name AS 고객이름, ravsp AS 평균금액
FROM customer c1,  (SELECT  custid, ROUND(AVG(saleprice),-2) ravsp
                    FROM orders
                    GROUP BY custid) o1
WHERE c1.custid = o1.custid;

SELECT  custid, ROUND(AVG(saleprice),-2)
FROM orders
GROUP BY custid;

-- salary를 30으로 나눈후 소수 자리수에 따라 절삭한 값 출력
SELECT *
FROM employee;

SELECT empname 이름, salary 월급, TRUNC(salary/30) 일급
FROM employee;

-- 문자 관련 함수
-- LOWER 값을 소문자로 변환 LOWER(‘ABCD’) abcd
-- UPPER 값을 대문자로 변환 UPPER(‘abcd’) ABCD
-- INITCAP 첫번째 글자만 대문자로 변환 INITCAP (‘abcd’) Abcd
-- SUBSTR 문자열중 일부분을 선택 SUBSTR(‘ABC’, 1, 2) AB
-- REPLACE 특정 문자열을 찾아 바꾼다 REPLACE(‘AB’, ‘A’, ‘E’) EB
-- CONCAT 두 문자열을 연결(|| 연산자와 같다) CONCAT(‘A’, ‘B’) AB
-- LENGTH 문자열의 길이를 구한다. LENGTH(‘AB’) 2
-- INSTR 명명된 문자의 위치를 구한다. INSTR(‘ABCD’, ‘D’) 4
-- LPAD 왼쪽부터 특정문자로 자리를 채움 LPAD(‘ABCD’, 6, ‘*’) **ABCD
-- RPAD 오른쪽부터 특정문자로 자리를 채움 RPAD(‘ABCD’, 6, ‘*’) ABCD**

(SELECT LPAD('cloud', 10, '*') FROM dual)
UNION (SELECT RPAD('cloud', 10, '*') FROM dual);

-- 부서 이름에서 처음부터 두 개의 문자 출력
SELECT SUBSTR(deptname, 1, 2)
FROM department;

-- 도서 제목에 야구가 포함된 도서를 농구로 변경하여 검색
SELECT  bookid, 
        REPLACE(bookname, '야구', '@농구@'),
        publisher
FROM book;

-- 굿스포츠에서 출판한 도서의 제목과 글자(바이트) 수를 검색하시오
SELECT  bookname,
        LENGTH(bookname)
FROM book
WHERE publisher = '굿스포츠';

-- 고객이름에서 같은 성을 가진 사람의 인원수를 구하시오
-- GROUP BY절에는 함수도 포함될 수 있음
SELECT SUBSTR(name, 1, 1) 성, COUNT(*) 수
FROM customer
GROUP BY SUBSTR(name, 1, 1);









    




