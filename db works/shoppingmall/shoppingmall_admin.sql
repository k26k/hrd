DELETE t_address wHERE num = 1;
-- t_address TABLE ����
CREATE TABLE t_address(
    num         NUMBER(4),
    username    VARCHAR2(20),
    tel         VARCHAR2(20) NOT NULL,
    email       VARCHAR2(30) NOT NULL,
    gender      VARCHAR2(6),
    joinDate    DATE DEFAULT SYSDATE,
    PRIMARY KEY(num)
);

SELECT * FROM t_address;

-- �Ϸù�ȣ(������) ����
CREATE SEQUENCE ab_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 9999
NOCYCLE
NOCACHE;

INSERT INTO t_address(num, username, tel, email, gender, joinDate)
VALUES (ab_seq.NEXTVAL, '�ƹ���', '010-1234-5678', 'test@test.com', '��', SYSDATE);

SELECT * FROM t_address WHERE num = 1;