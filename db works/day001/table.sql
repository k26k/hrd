-- 테이블 만들기

CREATE TABLE ex1(
    column1 CHAR(10), -- 고정 길이
    column2 VARCHAR2(10), -- 가변 길이
    column3 NUMBER -- 숫자
);

-- 데이터 입력

INSERT INTO ex1 (column1, column2, column3) VALUES ('abc', 'abc', 10);
INSERT INTO ex1 (column1, column2) VALUES ('우리', '우리');

COMMIT; -- 데이터 저장 후 커밋 필수

-- 데이터 검색


SELECT * FROM ex1;

-- 특정 column(열) 검색

SELECT column1, column2 FROM ex1;

-- CHAR과 VARCHAR2의 크기 비교

-- 칼럼에 별칭 만드는 방법 : 칼럼명 as 별명

SELECT column1, length(column1) AS Len1, 
       column2, length(column2) AS Len2
    FROM ex1 



