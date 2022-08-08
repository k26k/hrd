
CREATE TABLE t_member(
    memberid    VARCHAR2(20) PRIMARY KEY,
    passwd      VARCHAR2(20) NOT NULL,
    name        VARCHAR2(20) NOT NULL,
    gender      VARCHAR2(20) ,
    joindate    DATE DEFAULT SYSDATE
);

CREATE TABLE t_board(
    bnum        NUMBER(4) PRIMARY KEY,
    title       VARCHAR2(100) NOT NULL,
    content     VARCHAR2(2000) NOT NULL,
    regdate     DATE DEFAULT SYSDATE,
    memberid    VARCHAR2(20) ,
    CONSTRAINT FK_MemberBoard FOREIGN KEY (memberid)
    REFERENCES t_member(memberid)
);

CREATE SEQUENCE b_seq;

INSERT INTO t_member(memberid, passwd, name, gender) 
VALUES('qwer','1234','侯?欠','けぉ');

SELECT * FROM t_member;

SELECT * FROM t_member ORDER BY joindate DESC;

DELETE t_member WHERE memberid = 'qweqwewq';

UPDATE t_member SET memberid= 'ぜずそ', name = '098', passwd='ぜずそ' WHERE memberid = 'せぜず';


SELECT * FROM t_board;

INSERT INTO t_board(bnum, title, content, memberid)
values(b_seq.NEXTVAL, '照寒', 'ぞしぉ', 'qwe');

UPDATE t_board SET title = 'aklasdad', content = 'kgjgdhgh' WHERE bnum = 10;