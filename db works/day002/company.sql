-- 부서와 사원 테이블 작성
CREATE TABLE department(
    deptid      NUMBER,                 -- 부서 번호
    deptname    VARCHAR2(20) NOT NULL,  -- 부서 이름
    location    VARCHAR2(20) NOT NULL,  -- 부서 위치
    PRIMARY KEY(deptid)                 -- 고유키 설정
);

CREATE TABLE employee(
    empid NUMBER(3) PRIMARY KEY,            -- 사원 아이디
    empname VARCHAR2(20) NOT NULL,          -- 사원 이름
    age NUMBER(3),                          -- 사원 나이
    deptid NUMBER,                          -- 부서 코드
    CONSTRAINT EMP_FK FOREIGN KEY(deptid)   -- 외래키 관계 추가
    REFERENCES department(deptid)           -- 사원 아이디
);

-- 부서 자료 추가
INSERT INTO department VALUES (10, '전산팀', '서울');
INSERT INTO department VALUES (20, '총무팀', '인천');
SELECT * FROM department;

-- 사원 자료 추가
INSERT INTO employee VALUES (101, '이강', 27, 10);
INSERT INTO employee VALUES (102, '김산', 28, 20);
INSERT INTO employee VALUES (103, '정돌', 35, 30); -- 없는 부서 코드를 넣으면 부서 테이블의 무결성 위반
SELECT * FROM employee;

DROP TABLE department;
DROP TABLE employee;

-- 부서 삭제
DELETE FROM department WHERE deptid = 10;       -- 특정 행 삭제, 외래키 관계때문에 삭제 안됨
ALTER TABLE employee DROP CONSTRAINT EMP_FK;    -- 외래키 관계 삭제
DELETE FROM department WHERE deptid = 10;       -- 특정 행 삭제 재실행
SELECT * FROM department;                       -- 확인
SELECT * FROM employee;                         -- 확인


ALTER TABLE employee            
ADD CONSTRAINT EMP_FK FOREIGN KEY(deptid) 
REFERENCES department(deptid) ;                 -- 외래키 관계 추가, 키가 없는 행 때문에 추가 안됨 

DELETE FROM employee WHERE deptid = 10;       -- 키가 없는 행 삭제 

ALTER TABLE employee 
ADD CONSTRAINT EMP_FK FOREIGN KEY(deptid) 
REFERENCES department(deptid) ;                 -- 외래키 관계 재추가

SELECT * FROM department;                       -- 확인
SELECT * FROM employee;                         -- 확인










