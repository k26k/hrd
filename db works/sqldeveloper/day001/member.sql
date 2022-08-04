-- ex4 테이블 생성
CREATE TABLE ex4(
    userID VARCHAR2(10) PRIMARY KEY, -- 기본키 선언, PRIMARY KEY에는 UNIQUE와 NOT NULL이 들어가있음
    passwd VARCHAR2(10) NOT NULL    
);

-- 테이블 이름 변경
ALTER TABLE ex4 RENAME TO member; 

-- 칼럼 추가
ALTER TABLE member ADD regDate DATE;

-- 급여 칼럼 추가
ALTER TABLE member ADD salary NUMBER;

-- 입사일 칼럼 추가
ALTER TABLE member ADD hireDate VARCHAR(1);

-- 입사일 칼럼 수정
ALTER TABLE member MODIFY hireDate VARCHAR(20);

-- 데이터 삽입
INSERT INTO member (userID, passwd, regdate, salary, hiredate)
VALUES('cloud2022', 'abcd12345', SYSDATE, 3000000, '2022/06/09');


-- 데이터 삽입
INSERT INTO member (userID, passwd) VALUES ('sky2022', 'abcd123');
INSERT INTO member (userID, passwd) VALUES ('sky2023', 'abcd123');
INSERT INTO member (userID, passwd, regDate)
VALUES ('river2022', 'abcd1234', SYSDATE);
INSERT INTO member (userID, passwd, regDate, salary)
VALUES ('smile2022', 'abcd1234', SYSDATE, 1000000);
--INSERT INTO member (userID, passwd) VALUES ('sky2022', 'abcd123'); -- 기본키 UNIQUE 무결성 위반 중복선언 불가

-- 데이터 조회
SELECT * FROM member;
SELECT userID FROM member;
SELECT * FROM member WHERE userID = 'river2022' ;
SELECT userID FROM member WHERE passwd = 'abcd1234' ;

-- 데이터 조회(오름차순 정렬)
SELECT * FROM member ORDER BY salary;

-- 데이터 조회(내림차순 정렬)
SELECT * FROM member ORDER BY salary DESC;

-- 데이터 수정
UPDATE member SET salary = 2000000 WHERE userID = 'smile2022';
UPDATE member SET salary = 1000000 WHERE userID = 'river2022';

-- sky 데이터 수정
UPDATE member SET regDate = SYSDATE WHERE userID = 'sky2022';
UPDATE member SET regDare = SYSDATE WHERE userID = 'sky2023';
UPDATE member SET salary = 250000 WHERE userID = 'sky2022';
UPDATE member SET salary = 500000 WHERE userID = 'sky2023';

-- 데이터 삭제
COMMIT;

SELECT * FROM member;

DELETE FROM member  ;
DELETE FROM member WHERE userID = 'sky2023' ;
DELETE FROM member WHERE userID = 'sky2023' ;

ROLLBACK;

-- 테이블 복사
CREATE TABLE member2 AS SELECT userID, passwd FROM member WHERE userID = 'sky2023';
SELECT * FROM member2;

-- 테이블 삭제
DROP TABLE member2;

-- 테이블의 구조
DESC member;

-- 칼럼 이름 변경
--ALTER TABLE member RENAME COLUMN 