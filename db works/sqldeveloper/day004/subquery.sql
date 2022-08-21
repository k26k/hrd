
SELECT * FROM customer;
SELECT * FROM orders;
SELECT * FROM book;

-- ��������(�μ� ����)

-- ���� ��� ����
SELECT bookname, price
FROM book
WHERE price = (SELECT MAX(price)FROM book);

-- ������ ������ ���� �ִ� ���� �̸�
SELECT name
FROM customer
WHERE custid IN(SELECT custid FROM orders);

-- '������' ���� �ֹ������� �˻�
SELECT *
FROM orders
WHERE custid = (SELECT custid
                FROM customer
                WHERE name = '������');

-- �̻� �̵��� ������ ������ ������ ���� �̸�
SELECT name
FROM customer
WHERE custid IN(SELECT custid 
                FROM orders 
                WHERE bookid IN(SELECT bookid
                                FROM book
                                WHERE publisher = '�̻�̵��'));
                                
-- ���ǻ纰�� ��ݻ��� ��� ���� ���ݺ��� ��� ������ �˻��Ͻÿ�
-- Ʃ�� ���� : ���̺� �̸��� ��Ī
-- WHERE b2.publisher = b1.publisher : ��ü ����
SELECT b1.bookname
FROM book b1
WHERE b1.price > (SELECT AVG(b2.price)
                  FROM book b2
                  WHERE b2.publisher = b1.publisher);


SELECT AVG(price)
FROM book 
GROUP BY publisher;

SELECT bookname
FROM book
WHERE price < ( SELECT AVG(price)
                FROM (  SELECT price
                        FROM book
                        WHERE publisher = 
                        ));


-- �ζ��� �� - FROM �μ� ����

-- �� ��ȣ�� 2 ������ ���� �Ǹž��� �˻�
SELECT cs.name, SUM(od.saleprice) AS total
FROM (SELECT custid, name
      FROM customer
      WHERE custid <= 2) cs,
     orders od
WHERE cs.custid = od.custid
GROUP BY cs.name;



