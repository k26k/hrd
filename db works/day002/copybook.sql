
-- ���̺� ����
CREATE TABLE t_book as SELECT * From book;

SELECT * FROM t_book;

-- '�౸�� ����'�� ������ 10000������ ���� 
UPDATE t_book 
SET price = 10000
where bookid = 1;

COMMIT;

-- '����� ��ü'�� ���ǻ縦 '������'�� ����
UPDATE t_book
SET publisher = '������'
WHERE bookid = 6;

-- '�߱��� ��Ź��' ���ǻ縦 '�Ｚ��'���� �����ϰ�, ������ 15000������ ����
UPDATE t_book
SET publisher = '�Ｚ��', price = 15000
WHERE bookid = 8;

-- ����
-- DELETE FROM ���̺�� = ��ü ����
-- DELETE FROM ���̺�� WHERE ������ = �� ���� 

-- ������ȣ�� 5���� å�� ����
DELETE
FROM t_book
WHERE bookid = 5;

-- '���� ���̺�' ������ ����
DELETE
FROM t_book
WHERE bookname = '���� ���̺�';

-- COMMIT�� ROLLBACK�� �ǵ����� ����
ROLLBACK;
