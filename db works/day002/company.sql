-- �μ��� ��� ���̺� �ۼ�
CREATE TABLE department(
    deptid      NUMBER,                 -- �μ� ��ȣ
    deptname    VARCHAR2(20) NOT NULL,  -- �μ� �̸�
    location    VARCHAR2(20) NOT NULL,  -- �μ� ��ġ
    PRIMARY KEY(deptid)                 -- ����Ű ����
);

CREATE TABLE employee(
    empid NUMBER(3) PRIMARY KEY,            -- ��� ���̵�
    empname VARCHAR2(20) NOT NULL,          -- ��� �̸�
    age NUMBER(3),                          -- ��� ����
    deptid NUMBER,                          -- �μ� �ڵ�
    CONSTRAINT EMP_FK FOREIGN KEY(deptid)   -- �ܷ�Ű ���� �߰�
    REFERENCES department(deptid)           -- ��� ���̵�
);

-- �μ� �ڷ� �߰�
INSERT INTO department VALUES (10, '������', '����');
INSERT INTO department VALUES (20, '�ѹ���', '��õ');
SELECT * FROM department;

-- ��� �ڷ� �߰�
INSERT INTO employee VALUES (101, '�̰�', 27, 10);
INSERT INTO employee VALUES (102, '���', 28, 20);
INSERT INTO employee VALUES (103, '����', 35, 30); -- ���� �μ� �ڵ带 ������ �μ� ���̺��� ���Ἲ ����
SELECT * FROM employee;

DROP TABLE department;
DROP TABLE employee;

-- �μ� ����
DELETE FROM department WHERE deptid = 10;       -- Ư�� �� ����, �ܷ�Ű ���趧���� ���� �ȵ�
ALTER TABLE employee DROP CONSTRAINT EMP_FK;    -- �ܷ�Ű ���� ����
DELETE FROM department WHERE deptid = 10;       -- Ư�� �� ���� �����
SELECT * FROM department;                       -- Ȯ��
SELECT * FROM employee;                         -- Ȯ��


ALTER TABLE employee            
ADD CONSTRAINT EMP_FK FOREIGN KEY(deptid) 
REFERENCES department(deptid) ;                 -- �ܷ�Ű ���� �߰�, Ű�� ���� �� ������ �߰� �ȵ� 

DELETE FROM employee WHERE deptid = 10;       -- Ű�� ���� �� ���� 

ALTER TABLE employee 
ADD CONSTRAINT EMP_FK FOREIGN KEY(deptid) 
REFERENCES department(deptid) ;                 -- �ܷ�Ű ���� ���߰�

SELECT * FROM department;                       -- Ȯ��
SELECT * FROM employee;                         -- Ȯ��










