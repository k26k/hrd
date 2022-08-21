-- ���� : �� �� �̻��� ���̺��� ����
SELECT * FROM customer;
SELECT * FROM orders;

-- ============================ ���� ���� ================================
-- ���� ���̺��� ���� ������ ��ġ�ϴ� �ุ �������� ����

-- ���� ���� �ֹ��� ���� �����͸� ��� �˻�
SELECT *
FROM customer, orders
WHERE customer.custid = orders.custid;

-- ���� �̸��� ���� �ֹ��� ������ �ǸŰ����� �˻�
SELECT customer.name, orders.saleprice
FROM customer, orders
WHERE customer.custid = orders.custid;
 
-- '�Ȼ�'���� �ֹ������� �˻�
SELECT *
FROM customer, orders
WHERE customer.custid = orders.custid
AND customer.name = '�Ȼ�';

-- ������ �ֹ��� ��� ������ �� �Ǹž��� ���ϰ� ������ ����
SELECT customer.name, SUM(saleprice)
FROM customer, orders
WHERE customer.custid = orders.custid
GROUP BY customer.name
ORDER BY customer.name;

-- ���� �̸��� �ֹ��� ������ �̸��� �˻�
SELECT customer.name, book.bookname
FROM customer, orders, book
WHERE customer.custid = orders.custid
AND orders.bookid = book.bookid;

-- ������ 20000���� ������ �ֹ��� ���� �̸��� ������ �̸��� �˻�
SELECT customer.name, book.bookname
FROM customer, orders, book
WHERE customer.custid = orders.custid
AND orders.bookid = book.bookid
AND book.price = 20000;


-- ============================ �ܺ� ���� ================================
-- ���� ���̺��� ������ ���� ��ġ���� �ʴ� ��쿡�� ��� �����͸� ����

-- ������ �������� ���� ���� �����Ͽ� ���� �̸��� ���� �ֹ��� ������ �ǸŰ��� ���ϱ�
SELECT customer.name, orders.saleprice
FROM customer LEFT OUTER JOIN orders
ON customer.custid = orders.custid;




