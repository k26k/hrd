
-- ��� ���� ����
SELECT *
from customer;

-- ����ȣ�� 3���� ���� �̸��� �˻�
SELECT name
FROM customer
WHERE custid = 3;

-- �ּҰ� ���ѹα��� ���� �̸��� ��ȭ��ȣ�� �˻�
SELECT name, phone
FROM customer
WHERE address like '%���ѹα�%';

-- ��ȭ��ȣ�� null�� ���� �̸��� �ּҸ� �˻�
-- null �˻��� IS NULL �ݴ�� NOT NULL
SELECT name, address
FROM customer
WHERE phone IS NULL;
