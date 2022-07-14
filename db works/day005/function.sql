
-- �Լ�

-- ���� ���� �Լ�
-- ROUND ���ڸ� �ݿø��Ѵ�. ROUND(12.583, 1) 12.6
-- TRUNC ���ڸ� �����Ѵ�.(����) TRUNC(12.583, 1) 12.5
-- MOD ������ �� �������� ���Ѵ� MOD(15, 2) 1
-- CEIL ���ڸ� ������ �ø��Ѵ�. CEIL(15.351) 16
-- FLOOR ���ڸ� ������ �����Ѵ�. FLOOR(15.351) 15
-- ABS ���밪�� ���Ѵ� ABS(-10) 10
-- POWER �ŵ������� ���Ѵ�. POWER(2, 3) 8
-- SQRT �������� ���Ѵ�. SQRT(4) 2

-- dual = ���� ���̺�

-- ���밪
SELECT ABS(-10) FROM dual;

-- �Ҽ� ù° �ڸ����� �ݿø�
SELECT ROUND(3.875, 1) FROM dual;

-- �ݿø� ����
SELECT  ROUND(123.875, -2),
        ROUND(123.875, -1),
        ROUND(123.875, 0),
        ROUND(123.875, 1),
        ROUND(123.875, 2),
        ROUND(123.875, 3)
FROM dual;

-- ���� ��� �ֹ� �ݾ��� ��� ������ �ݿø��� ���� ���Ͻÿ�
SELECT name AS ���̸�, ravsp AS ��ձݾ�
FROM customer c1,  (SELECT  custid, ROUND(AVG(saleprice),-2) ravsp
                    FROM orders
                    GROUP BY custid) o1
WHERE c1.custid = o1.custid;

SELECT  custid, ROUND(AVG(saleprice),-2)
FROM orders
GROUP BY custid;

-- salary�� 30���� ������ �Ҽ� �ڸ����� ���� ������ �� ���
SELECT *
FROM employee;

SELECT empname �̸�, salary ����, TRUNC(salary/30) �ϱ�
FROM employee;

-- ���� ���� �Լ�
-- LOWER ���� �ҹ��ڷ� ��ȯ LOWER(��ABCD��) abcd
-- UPPER ���� �빮�ڷ� ��ȯ UPPER(��abcd��) ABCD
-- INITCAP ù��° ���ڸ� �빮�ڷ� ��ȯ INITCAP (��abcd��) Abcd
-- SUBSTR ���ڿ��� �Ϻκ��� ���� SUBSTR(��ABC��, 1, 2) AB
-- REPLACE Ư�� ���ڿ��� ã�� �ٲ۴� REPLACE(��AB��, ��A��, ��E��) EB
-- CONCAT �� ���ڿ��� ����(|| �����ڿ� ����) CONCAT(��A��, ��B��) AB
-- LENGTH ���ڿ��� ���̸� ���Ѵ�. LENGTH(��AB��) 2
-- INSTR ���� ������ ��ġ�� ���Ѵ�. INSTR(��ABCD��, ��D��) 4
-- LPAD ���ʺ��� Ư�����ڷ� �ڸ��� ä�� LPAD(��ABCD��, 6, ��*��) **ABCD
-- RPAD �����ʺ��� Ư�����ڷ� �ڸ��� ä�� RPAD(��ABCD��, 6, ��*��) ABCD**

(SELECT LPAD('cloud', 10, '*') FROM dual)
UNION (SELECT RPAD('cloud', 10, '*') FROM dual);

-- �μ� �̸����� ó������ �� ���� ���� ���
SELECT SUBSTR(deptname, 1, 2)
FROM department;

-- ���� ���� �߱��� ���Ե� ������ �󱸷� �����Ͽ� �˻�
SELECT  bookid, 
        REPLACE(bookname, '�߱�', '@��@'),
        publisher
FROM book;

-- �½��������� ������ ������ ����� ����(����Ʈ) ���� �˻��Ͻÿ�
SELECT  bookname,
        LENGTH(bookname)
FROM book
WHERE publisher = '�½�����';

-- ���̸����� ���� ���� ���� ����� �ο����� ���Ͻÿ�
-- GROUP BY������ �Լ��� ���Ե� �� ����
SELECT SUBSTR(name, 1, 1) ��, COUNT(*) ��
FROM customer
GROUP BY SUBSTR(name, 1, 1);









    




