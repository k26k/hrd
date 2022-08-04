
CREATE TABLE t_member(
    memberid    VARCHAR2(20) PRIMARY KEY,
    passwd      VARCHAR2(20) NOT NULL,
    name        VARCHAR2(20) NOT NULL,
    gender      VARCHAR2(20) ,
    joindate    DATE DEFAULT SYSDATE
);

INSERT INTO t_member(memberid, passwd, name, gender) 
VALUES('qwer','1234','侯?欠','けぉ');

SELECT * FROM t_member;

SELECT * FROM t_member ORDER BY joindate DESC;

DELETE t_member WHERE memberid = 'qweqwewq';

UPDATE t_member SET memberid= 'ぜずそ', name = '098', passwd='ぜずそ' WHERE memberid = 'せぜず';