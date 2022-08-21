-- ��ü ��ȸ
SELECT * FROM book;

-- ��� ������ �̸��� ������ ��ȸ
SELECT bookname, price FROM book;

-- ��� ������ ���� ��ȣ, �����̸�, ���ǻ�, ���� ��ȸ
SELECT bookid, bookname, publisher, price FROM book;

-- ��� ������ ���ǻ� ��ȸ
SELECT publisher FROM book;

-- ��� ������ ���ǻ� ��ȸ (�ߺ� ���� - DISTINCT)
SELECT DISTINCT publisher FROM book;

-- ������ WHERE ���

--������ 20000�� �̸��� ���� �˻�
SELECT *
FROM book
WHERE price < 20000;

--������ 10000�� �̻� 20000�� ������ ���� �˻�
-- ���� : BETWEEN �ּ� AND �ִ�
SELECT *
FROM book
WHERE price BETWEEN 10000 and 20000;

SELECT *
FROM book
WHERE 10000 <= price and price <= 20000;

-- IN()
-- ���ǻ簡 '�½�����' Ȥ�� '���ѹ̵��'�� ������ �˻�
SELECT *
FROM book
WHERE publisher IN('�½�����', '���ѹ̵��');

-- ���ǻ簡 '�½�����' Ȥ�� '���ѹ̵��'�� �ƴ� ������ �˻�
SELECT *
FROM book
WHERE publisher NOT IN('�½�����', '���ѹ̵��');

-- LIKE ������ 
-- '�౸�� ����'�� �Ⱓ�� ���ǻ� �˻�
SELECT bookname, publisher
FROM book
WHERE bookname like '�౸�� ����';

-- ���� �̸��� '�౸'�� ���Ե� ���ǻ� �˻� 
-- '�ܾ�%' = ���� �ܾ�
-- '%�ܾ�' = �� �ܾ�
-- '%�ܾ�%' = ���� �ܾ�
SELECT bookname, publisher
FROM book
WHERE bookname like '�౸%';

SELECT bookname, publisher
FROM book
WHERE bookname like '%�౸';

SELECT bookname, publisher
FROM book
WHERE bookname like '%�౸%';

-- �౸�� ���� ������ ������ 20000�� �̻��� ���� �˻�
SELECT bookname, price
FROM book
WHERE bookname like '%�౸%' AND 20000 <= price;

-- �����ϸ鼭 �˻�
-- ORDER BY
-- ������ �̸������� �˻�
SELECT *
FROM book
ORDER BY bookname;

-- ������ ���ݼ����� ������ ������ �̸������� �˻�
SELECT *
FROM book
ORDER BY price, bookname;

-- ������ ������ ������������ ������ ������ ���ǻ縦 ������������ �˻�
SELECT *
FROM book
ORDER BY price DESC, bookname ASC;



