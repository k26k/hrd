-- USER(JWEB) ����
CREATE USER C##shoppingmall IDENTIFIED BY qwert;

-- ���� ���� �ο�
GRANT CREATE SESSION TO C##shoppingmall;

-- ���̺�� ���̺� ���� ����
GRANT CREATE TABLE, RESOURCE TO C##shoppingmall;

-- ���̺� �����̽� ���� �ֱ�
ALTER USER C##shoppingmall DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-- ���� ����� ������ �� ���
-- sqlplus ������
-- GRANT CREAT ANY TABLE TO C##JWEB;
-- GRANT CONNECT, RESOURCE, DBA TO C##JWEB;


