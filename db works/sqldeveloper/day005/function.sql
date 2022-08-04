
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


-- ��¥, �ð� �Լ�
--��¥ ���� ��Ģ
--�Լ� 		        ���� 			        ��ȯ��
--Date + Number 	��¥���� �ϼ��� ���Ѵ�. 	Date
--Date - Number 	��¥���� �ϼ��� ����. 	    Date
--Date ? Date 	    ��¥���� ��¥�� ����. 	    �ϼ�
--
--�Լ� 			    ���� 					                ��
--MONTH_BETWEEN 	�� ��¥ ������ ������ ��� 			        MONTH_BETWEEN(SYSDATE, HIRE_DATE)
--ADD_MONTHS 		���� ��¥�� ���Ѵ�. 			            ADD_MONTHS(HIRE_DATE, 5)
--NEXT_DAY 		    ��õ� ��¥���� ���ƿ��� ������ ��¥�� ��� 	NEXT_DAY(HIRE_DATE, 1)

-- �� �ֹ��� ���� +10�� Ȯ��
SELECT orderid, orderdate, orderdate+10
FROM orders;

-- �ֹ���ȣ 6���� 10������ ������ �ֹ��Ͽ� 3������ ���� ��
SELECT  orderid,
        orderdate,
        ADD_MONTHS(orderdate, 3)
FROM orders
WHERE orderid BETWEEN 6 AND 10;

-- �ֹ���ȣ�� 10�� ������ �ֹ��Ϸκ��� ���ñ����� �� ������
SELECT  orderid,
        orderdate,
        SYSDATE,
        TRUNC(MONTHS_BETWEEN(SYSDATE,orderdate),0)
FROM orders
WHERE orderid = 10;

-- ��ȯ �Լ�
-- TO_CHAR       ����, ����,��¥ ���� ������ VARCHAR2�� ��ȯ
-- TO_NUMBER     ���ڸ� ���� Ÿ������ ��ȯ
-- TO_DATE       ��¥�� ��Ÿ���� ���ڿ��� ���� ������ ��¥ Ÿ��

-- ���� ���� ��ȯ
SELECT TO_NUMBER('123.3')
FROM dual;

-- ��¥ ���� : ��¥ ���ڿ��� ���� ���� ��¥ Ÿ������ ��ȯ
SELECT TO_DATE('2023-06-30', 'YYYY-MM-DD')
FROM dual;

-- ��¥�� ���� �������� ��ȯ
SELECT  TO_CHAR(SYSDATE),
        TO_CHAR(SYSDATE,'YY'),
        TO_CHAR(SYSDATE,'YYYY'),
        TO_CHAR(SYSDATE,'MM'),
        TO_CHAR(SYSDATE,'DD')
FROM dual;

-- �ð��� ���� �������� ��ȯ
SELECT  TO_CHAR(SYSDATE, 'HH:MI:SS')
FROM dual;

SELECT  TO_CHAR(SYSDATE, 'HH24:MI:SS')
FROM dual;


-- null ã��
SELECT *
FROM customer
WHERE phone is null;

-- null ��� �ٸ��� ���
SELECT name, NVL(phone,'xxx-xxxx-xxxx')
FROM customer;


