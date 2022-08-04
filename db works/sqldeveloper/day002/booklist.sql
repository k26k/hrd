-- book table ���� 
CREATE TABLE book(
    bookid      NUMBER PRIMARY KEY,
    bookname    VARCHAR2(40),
    publisher   VARCHAR2(40),
    price       NUMBER
);

-- book table �ڷ� ����
INSERT INTO book VALUES(1, '�౸�� ����', '�½�����', 7000);
INSERT INTO book VALUES(2, '�౸ �ƴ� ����', '������', 13000);
INSERT INTO book VALUES(3, '�౸�� ����', '���ѹ̵��', 22000);
INSERT INTO book VALUES(4, '���� ���̺�', '���ѹ̵��', 35000);
INSERT INTO book VALUES(5, '�ǰ� ����', '�½�����', 8000);
INSERT INTO book VALUES(6, '����� ��ü', '�½�����', 6000);
INSERT INTO book VALUES(7, '�߱��� �߾�', '�̻�̵��', 20000);
INSERT INTO book VALUES(8, '�߱��� ��Ź��', '�̻�̵��', 13000);
INSERT INTO book VALUES(9, '�ø��� �̾߱�', '�Ｚ��', 7500);
INSERT INTO book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

-- book table �ڷ� ��ȸ

-- ��ü ��ȸ
SELECT * FROM book;

-- ��� ������ �̸��� ������ ��ȸ
SELECT bookname, price FROM book;

-- ��� ������ ���� ��ȣ, �����̸�, ���ǻ�, ���� ��ȸ
SELECT bookid, bookname, publisher, price
FROM book;

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
WHERE price BETWEEN 10000 AND 20000;

SELECT *
FROM book
WHERE 10000 <= price AND price <= 20000;

-- IN()
-- ���ǻ簡 '�½�����' Ȥ�� '���ѹ̵��'�� ������ �˻�
SELECT *
FROM book
WHERE publisher IN('�½�����', '���ѹ̵��');

SELECT *
FROM book
WHERE publisher = '�½�����' OR publisher = '���ѹ̵��';

-- ���ǻ簡 '�½�����' Ȥ�� '���ѹ̵��'�� �ƴ� ������ �˻�
SELECT *
FROM book
WHERE publisher NOT IN('�½�����', '���ѹ̵��');

-- LIKE ������ 
-- '�౸�� ����'�� �Ⱓ�� ���ǻ� �˻�
SELECT bookname, publisher
FROM book
WHERE bookname LIKE '�౸�� ����';

-- ���� �̸��� '�౸'�� ���Ե� ���ǻ� �˻� 
-- '�ܾ�%' = ���� �ܾ�
-- '%�ܾ�' = �� �ܾ�
-- '%�ܾ�%' = ���� �ܾ�
SELECT bookname, publisher
FROM book
WHERE bookname LIKE '%�౸%';

-- �౸�� ���� ������ ������ 20000�� �̻��� ���� �˻�
SELECT *
FROM book
WHERE bookname LIKE '%�౸%' AND 20000 <= price;

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
ORDER BY price DESC, publisher ASC;
























