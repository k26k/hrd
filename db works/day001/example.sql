-- ex2 ǥ ����
CREATE TABLE ex2(
    col_data DATE,
    col_timestamp TIMESTAMP
);

-- ������ �Է�
INSERT INTO ex2 VALUES (SYSDATE, SYSTIMESTAMP);

COMMIT;

-- ������ ��ȸ
SELECT * FROM ex2;

-- ex3 ǥ ����
CREATE TABLE ex3(
    col_null VARCHAR2(10),
    col_not_null VARCHAR2(10) NOT NULL
);

-- ex3�� ������ �Է�
INSERT INTO ex3 VALUES ('Hello', ''); -- NOT NULL �������� ����
INSERT INTO ex3 VALUES ('', 'Hello');

-- ������ ��ȸ
SELECT * FROM ex3;



