
-- ��(VIEW)
-- ���������� ���� ���� �ʿ��� ����ڿ��� ������ �����͸� ����

-- address�� '���ѹα�'�� �����ϴ� ����θ� ������ �並 ����
CREATE VIEW vw_customer
AS  SELECT  *
    FROM    customer
    WHERE   address LIKE '%���ѹα�%';
    
-- �� ��ȸ
SELECT * 
FROM vw_customer;

-- ���� �̸��� �ֹ��� ������ �̸�, ������ �˻�
CREATE VIEW vw_orders 
AS  SELECT customer.name, book.bookname, book.price 
    FROM customer, orders, book
    WHERE   customer.custid = orders.custid
            AND orders.bookid = book.bookid;
            
SELECT *
FROM vw_orders;

-- �� ����
DROP VIEW vw_customer;