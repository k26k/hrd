DELETE t_address wHERE num = 1;

-- t_address TABLE 생성
CREATE TABLE shopuser(
    usernum     NUMBER(6),
    userid      VARCHAR2(30) NOT NULL,
    userpw      VARCHAR2(30) NOT NULL,
    username    VARCHAR2(20) NOT NULL,
    tel         VARCHAR2(20) NOT NULL,
    email       VARCHAR2(30) NOT NULL,
    gender      VARCHAR2(12),
    joinDate    DATE DEFAULT SYSDATE,
    PRIMARY KEY(num)
);

SELECT * FROM shopuser;

-- 일련번호(시퀀스) 생성
CREATE SEQUENCE usernum_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999999
NOCYCLE
NOCACHE;

INSERT INTO t_address(num, userid, userpw, username, tel, email, gender, joinDate)
VALUES (ab_seq.NEXTVAL, 'qwer', '1234', '아무개', '010-1234-5678', 'test@test.com', '남', SYSDATE);

SELECT * FROM t_address WHERE num = 1;