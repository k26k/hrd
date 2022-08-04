DELETE t_address wHERE num = 1;

-- t_address TABLE ����
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

-- �Ϸù�ȣ(������) ����
CREATE SEQUENCE usernum_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999999
NOCYCLE
NOCACHE;

INSERT INTO t_address(num, userid, userpw, username, tel, email, gender, joinDate)
VALUES (ab_seq.NEXTVAL, 'qwer', '1234', '�ƹ���', '010-1234-5678', 'test@test.com', '��', SYSDATE);

SELECT * FROM t_address WHERE num = 1;