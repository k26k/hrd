-- ���̺� �����

CREATE TABLE ex1(
    column1 CHAR(10), -- ���� ����
    column2 VARCHAR2(10), -- ���� ����
    column3 NUMBER -- ����
);

-- ������ �Է�

INSERT INTO ex1 (column1, column2, column3) VALUES ('abc', 'abc', 10);
INSERT INTO ex1 (column1, column2) VALUES ('�츮', '�츮');

COMMIT; -- ������ ���� �� Ŀ�� �ʼ�

-- ������ �˻�


SELECT * FROM ex1;

-- Ư�� column(��) �˻�

SELECT column1, column2 FROM ex1;

-- CHAR�� VARCHAR2�� ũ�� ��

-- Į���� ��Ī ����� ��� : Į���� as ����

SELECT column1, length(column1) AS Len1, 
       column2, length(column2) AS Len2
    FROM ex1 



