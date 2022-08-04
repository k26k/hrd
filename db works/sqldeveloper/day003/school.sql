-- 학과 테이블 작성
CREATE TABLE major(
    dname       VARCHAR2(30),
    dtel        VARCHAR2(20),
    location    VARCHAR2(20),
    PRIMARY KEY(dname)
);

INSERT INTO major VALUES('소프트웨어학과', '02-1234-1234', 'B동 3층');
INSERT INTO major VALUES('화학공학과', '02-1234-4567', 'B동 4층');
INSERT INTO major VALUES('전기전자공학과', '02-1234-5678', 'B동 5층');

SELECT * FROM major;


-- 교수 테이블 작성
CREATE TABLE professor(
    pnumber     NUMBER(3),
    pname       VARCHAR2(20),
    major       VARCHAR2(30),
    PRIMARY KEY(pnumber)
);

INSERT INTO professor VALUES(301, '박은종', 'JAVA 프로그래밍');
INSERT INTO professor VALUES(402, '송미영', 'JSP 웹프로그래밍');
INSERT INTO professor VALUES(501, '오용철', '데이터베이스');

SELECT * FROM professor;


-- 학생 테이블 작성
CREATE TABLE student(
    snumber     NUMBER(10),
    sname       VARCHAR2(20) NOT NULL,
    age         NUMBER(3),
    gender      VARCHAR2(4),
    address     VARCHAR2(30),
    dname       VARCHAR2(30) NOT NULL,
    pnumber     NUMBER(3) NOT NULL,
    PRIMARY KEY(snumber),
    CONSTRAINT FK_major_std FOREIGN KEY(dname)
    REFERENCES major(dname),
    CONSTRAINT FK_prof_std FOREIGN KEY(pnumber)
    REFERENCES professor(pnumber)
);

INSERT INTO student VALUES(20211234, '이강', 22, '여', '서울시 구로구', '소프트웨어학과', 301);
INSERT INTO student VALUES(20211235, '박대양', 25, '남', '서울시 성동구', '전기전자공학과', 501);
INSERT INTO student VALUES(20211236, '한비야', 23, '여', '서울시 강남구', '소프트웨어학과', 402);
INSERT INTO student VALUES(20211237, '정산들', 27, '남', '경기도 수원시', '화학공학과', 501);

SELECT * FROM student;


-- 제약조건 변경
-- 삭제
ALTER TABLE student 
DROP CONSTRAINT FK_prof_std;

-- 추가
ALTER TABLE student 
add CONSTRAINT FK_prof_std FOREIGN KEY(pnumber)
REFERENCES professor(pnumber);






