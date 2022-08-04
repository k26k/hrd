-- �����Լ� SUM, COUNT, AVG
-- �ֹ� ���̺� �˻�

-- ���� �ֹ��� ������ �� �Ǹž��� ���Ͻÿ�
SELECT SUM(saleprice) AS �Ѹ���
FROM orders;

-- '�迬��' ���� �ֹ��� ������ �� �Ǹž��� ���Ͻÿ�
SELECT SUM(saleprice) AS �Ѹ���
FROM orders
WHere custid = 2;

-- ���� �ֹ��� ������ �� ����� ��հ� ���ϱ�
SELECT SUM(saleprice) AS Total,
       AVG(saleprice) AS Average
FROM orders;

-- ���� ������ ���� �Ǹ� �Ǽ��� ���Ͻÿ�
SELECT COUNT(*) as ���ǸűǼ�
FROM orders;

-- ������ �ֹ��� ������ �� ������ �Ǹž��� ���Ͻÿ�
SELECT custid, COUNT(*) ���ǸűǼ�, SUM(saleprice) �Ѿ�
FROM orders
GROUP BY custid;

-- ������ 8000�� �̻��� ������ ������ ���� ���Ͽ� �� �����ֹ������� �� ������ ���ϱ�
-- �� ������ �� �� �̻� ������ ���� ���Ͻÿ� 
-- HAVING�� GROUP BY ��� ��Ÿ���� �׷��� ������
SELECT custid, COUNT(*) ���ǸűǼ�, SUM(saleprice) �Ѿ�
FROM orders
WHERE 8000 <= saleprice
GROUP BY custid
HAVING 2 <= count(*);



