
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


SELECT * FROM t_board ORDER BY bnum DESC;

INSERT INTO t_board(bnum, title, content, memberid)
values(b_seq.NEXTVAL, '照寒', 'ぞしぉ', 'qwe');

UPDATE t_board SET title = 'aklasdad', content = 'kgjgdhgh' WHERE bnum = 10;

ALTER TABLE t_board ADD recommend NUMBER(4);
ALTER TABLE t_board ADD views NUMBER(4);

UPDATE t_board set recommend = 0 WHERE recommend IS NULL;
UPDATE t_board set views = 0 WHERE views IS NULL;

ALTER TABLE t_board DROP CONSTRAINT FK_MemberBoard;
ALTER TABLE t_board ADD CONSTRAINT FK_MemberBoard FOREIGN KEY (memberid)
REFERENCES t_member(memberid)ON DELETE CASCADE;

ALTER TABLE t_board DROP COLUMN recommend;
ALTER TABLE t_board RENAME COLUMN views TO hit;


CREATE TABLE t_order(
    name    VARCHAR2(10),
    joindate    DATE DEFAULT SYSDATE
);

SELECT * FROM t_order;
DROP TABLE t_order;

INSERT INTO t_order(name) values('ぞぞぞ');
INSERT INTO t_order(name, joindate) values('ぞぞぞ2', TO_DATE('1997-01-01', 'yyyy-mm-dd'));

SELECT * FROM ( SELECT ROWNUM rn, a.* FROM ( SELECT * FROM t_board ORDER BY regdate DESC ) a ) WHERE rn BETWEEN 11 AND 20; 

SELECT ROWNUM rn, a.* FROM ( SELECT * FROM t_board ORDER BY regdate DESC ) a WHERE rn BETWEEN 1 AND 20; 

