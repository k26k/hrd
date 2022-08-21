-- 테이블 생성
CREATE TABLE employee(
    empid       NUMBER(5) PRIMARY KEY,
    name		VARCHAR2(20) NOT NULL,
    phone		VARCHAR2(15) NOT NULL,
    hiredate	DATE NOT NULL
);
CREATE TABLE job_history(
    jobid   	VARCHAR2(10) PRIMARY KEY,
    jobtitle	VARCHAR2(20) NOT NULL,
    startdate	DATE NOT NULL,
    enddate	    DATE NOT NULL,
    empid   	NUMBER(5) NOT NULL,
    FOREIGN KEY(empid) 
    REFERENCES employee(empid)
);

-- 자료 삽입
INSERT INTO employee VALUES(
    101,
    '장그래',
    '010-1234-5678',
    TO_DATE('2015-08-01','YYYY-MM-DD')
);
INSERT INTO job_history VALUES(
    'IT_PROG',
    '웹 프로그래머',
    TO_DATE('2018-01-01','YYYY-MM-DD'),
    TO_DATE('2020-12-31','YYYY-MM-DD'),
    101
);
INSERT INTO job_history VALUES(
    'FI_ACCOUNT',
    '과장',
    TO_DATE('2021-01-01','YYYY-MM-DD'),
    TO_DATE('2021-12-31','YYYY-MM-DD'),
    101
);
INSERT INTO job_history VALUES(
    'HR_REP',
    '대리',
    TO_DATE('2022-01-01','YYYY-MM-DD'),
    TO_DATE('2022-08-10','YYYY-MM-DD'),
    101
);

-- 자료 조회
SELECT * FROM employee;
SELECT * FROM job_history;

-- 무결성 제약 조건 오류 발생
-- 자료 삽입시 부모 키가 없는 오류 발생
INSERT INTO job_history VALUES(
    'IT_PROG2',
    '웹 프로그래머2',
    TO_DATE('2018-01-01','YYYY-MM-DD'),
    TO_DATE('2022-08-10','YYYY-MM-DD'),
    200
);
-- 자료 삭제시 자식 레코드가 발견되는 오류
DELETE employee WHERE empid = 101;
