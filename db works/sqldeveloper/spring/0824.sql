CREATE TABLE board(
    bno     NUMBER(5) PRIMARY KEY,
    title   VARCHAR2(200),
    writer  VARCHAR2(20),
    content VARCHAR2(2000),
    regdate DATE DEFAULT SYSDATE,
    cnt     NUMBER(5) DEFAULT 0
);

CREATE SEQUENCE seq;

INSERT INTO board(bno, title, writer, content)
VALUES(seq.NEXTVAL, '가입인사', '관리자', '잘 부탁드립니다.');

SELECT * FROM board;


DELETE board WHERE title IS NULL;



CREATE TABLE users(
    id      VARCHAR2(20) PRIMARY KEY,
    passwd  VARCHAR2(20) NOT NULL,
    name    VARCHAR2(20) NOT NULL,
    role    VARCHAR2(5)
);

INSERT INTO users(id, passwd, name, role)
VALUES('test', '1234', '관리자', 'Admin');

INSERT INTO users(id, passwd, name, role)
VALUES('user', '1234', '장그래', 'User');

SELECT * FROM users;