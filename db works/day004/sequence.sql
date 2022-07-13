
-- ������(Sequence)
CREATE SEQUENCE mySeq 
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000
NOCYCLE
NOCACHE;

CREATE TABLE board(
    bno     NUMBER(4) PRIMARY KEY,
    title   VARCHAR2(50) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    regDate DATE DEFAULT SYSDATE
);

INSERT INTO board(bno, title, content, regDate)
VALUES(myseq.nextval, '����1', '����1', SYSDATE);
INSERT INTO board(bno, title, content, regDate)
VALUES(myseq.nextval, '����2', '����2', SYSDATE);
INSERT INTO board(bno, title, content, regDate)
VALUES(myseq.nextval, '����3', '����3', SYSDATE);

SELECT * FROM board;

SELECT * 
FROM board
WHERE title = '����1';

SELECT * 
FROM board
WHERE bno = 1;

SELECT *
FROM board
WHERE bno in (1,2) 
ORDER BY bno DESC;

-- �Խñ� 3���� ������ '�����մϴ�'�� ����
UPDATE board 
SET content = '�����մϴ�'
WHERE bno = 3;





