-- ex4 ���̺� ����
CREATE TABLE ex4(
    userID VARCHAR2(10) PRIMARY KEY, -- �⺻Ű ����, PRIMARY KEY���� UNIQUE�� NOT NULL�� ������
    passwd VARCHAR2(10) NOT NULL    
);

-- ���̺� �̸� ����
ALTER TABLE ex4 RENAME TO member; 

-- Į�� �߰�
ALTER TABLE member ADD regDate DATE;

-- �޿� Į�� �߰�
ALTER TABLE member ADD salary NUMBER;

-- �Ի��� Į�� �߰�
ALTER TABLE member ADD hireDate VARCHAR(1);

-- �Ի��� Į�� ����
ALTER TABLE member MODIFY hireDate VARCHAR(20);

-- ������ ����
INSERT INTO member (userID, passwd, regdate, salary, hiredate)
VALUES('cloud2022', 'abcd12345', SYSDATE, 3000000, '2022/06/09');


-- ������ ����
INSERT INTO member (userID, passwd) VALUES ('sky2022', 'abcd123');
INSERT INTO member (userID, passwd) VALUES ('sky2023', 'abcd123');
INSERT INTO member (userID, passwd, regDate)
VALUES ('river2022', 'abcd1234', SYSDATE);
INSERT INTO member (userID, passwd, regDate, salary)
VALUES ('smile2022', 'abcd1234', SYSDATE, 1000000);
--INSERT INTO member (userID, passwd) VALUES ('sky2022', 'abcd123'); -- �⺻Ű UNIQUE ���Ἲ ���� �ߺ����� �Ұ�

-- ������ ��ȸ
SELECT * FROM member;
SELECT userID FROM member;
SELECT * FROM member WHERE userID = 'river2022' ;
SELECT userID FROM member WHERE passwd = 'abcd1234' ;

-- ������ ��ȸ(�������� ����)
SELECT * FROM member ORDER BY salary;

-- ������ ��ȸ(�������� ����)
SELECT * FROM member ORDER BY salary DESC;

-- ������ ����
UPDATE member SET salary = 2000000 WHERE userID = 'smile2022';
UPDATE member SET salary = 1000000 WHERE userID = 'river2022';

-- sky ������ ����
UPDATE member SET regDate = SYSDATE WHERE userID = 'sky2022';
UPDATE member SET regDare = SYSDATE WHERE userID = 'sky2023';
UPDATE member SET salary = 250000 WHERE userID = 'sky2022';
UPDATE member SET salary = 500000 WHERE userID = 'sky2023';

-- ������ ����
COMMIT;

SELECT * FROM member;

DELETE FROM member  ;
DELETE FROM member WHERE userID = 'sky2023' ;
DELETE FROM member WHERE userID = 'sky2023' ;

ROLLBACK;

-- ���̺� ����
CREATE TABLE member2 AS SELECT userID, passwd FROM member WHERE userID = 'sky2023';
SELECT * FROM member2;

-- ���̺� ����
DROP TABLE member2;

-- ���̺��� ����
DESC member;

-- Į�� �̸� ����
--ALTER TABLE member RENAME COLUMN 