CREATE TABLE tbl_board(
    bno     NUMBER(5) PRIMARY KEY,
    title   VARCHAR2(200),
    writer  VARCHAR2(20),
    content VARCHAR2(2000),
    regdate DATE DEFAULT SYSDATE,
    cnt     NUMBER(5) DEFAULT 0
);

CREATE SEQUENCE seq;

INSERT INTO tbl_board(bno, title, writer, content)
VALUES(seq.NEXTVAL, '�����λ�', '������', '�� ��Ź�帳�ϴ�.');

SELECT * FROM tbl_board;


DELETE tbl_board WHERE title IS NULL;



CREATE TABLE tbl_users(
    id      VARCHAR2(20) PRIMARY KEY,
    passwd  VARCHAR2(20) NOT NULL,
    name    VARCHAR2(20) NOT NULL,
    role    VARCHAR2(5)
);

INSERT INTO tbl_users(id, passwd, name, role)
VALUES('test', '1234', '������', 'Admin');

INSERT INTO tbl_users(id, passwd, name, role)
VALUES('user', '1234', '��׷�', 'User');

SELECT * FROM tbl_users;