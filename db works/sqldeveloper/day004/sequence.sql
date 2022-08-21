
-- 시퀸스(Sequence)
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
VALUES(myseq.nextval, '제목1', '내용1', SYSDATE);
INSERT INTO board(bno, title, content, regDate)
VALUES(myseq.nextval, '제목2', '내용2', SYSDATE);
INSERT INTO board(bno, title, content, regDate)
VALUES(myseq.nextval, '제목3', '내용3', SYSDATE);

SELECT * FROM board;

SELECT * 
FROM board
WHERE title = '제목1';

SELECT * 
FROM board
WHERE bno = 1;

SELECT *
FROM board
WHERE bno in (1,2) 
ORDER BY bno DESC;

-- 게시글 3번의 내용을 '감사합니다'로 수정
UPDATE board 
SET content = '감사합니다'
WHERE bno = 3;





