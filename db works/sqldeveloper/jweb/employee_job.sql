-- ���̺� ����
CREATE TABLE employee(
    empid       NUMBER(5) PRIMARY KEY,
    name		VARCHAR2(20) NOT NULL,
    phone		VARCHAR2(15) NOT NULL,
    hiredate	DATE NOT NULL
);
CREATE TABLE job_history(
    jobid   	VARCHAR2(10) PRIMARY KEY,
    jobtitle	VARCHAR2(20) NOT NULL,
    startdate	DATE NOT NULL,
    enddate	    DATE NOT NULL,
    empid   	NUMBER(5) NOT NULL,
    FOREIGN KEY(empid) 
    REFERENCES employee(empid)
);

-- �ڷ� ����
INSERT INTO employee VALUES(
    101,
    '��׷�',
    '010-1234-5678',
    TO_DATE('2015-08-01','YYYY-MM-DD')
);
INSERT INTO job_history VALUES(
    'IT_PROG',
    '�� ���α׷���',
    TO_DATE('2018-01-01','YYYY-MM-DD'),
    TO_DATE('2020-12-31','YYYY-MM-DD'),
    101
);
INSERT INTO job_history VALUES(
    'FI_ACCOUNT',
    '����',
    TO_DATE('2021-01-01','YYYY-MM-DD'),
    TO_DATE('2021-12-31','YYYY-MM-DD'),
    101
);
INSERT INTO job_history VALUES(
    'HR_REP',
    '�븮',
    TO_DATE('2022-01-01','YYYY-MM-DD'),
    TO_DATE('2022-08-10','YYYY-MM-DD'),
    101
);

-- �ڷ� ��ȸ
SELECT * FROM employee;
SELECT * FROM job_history;

-- ���Ἲ ���� ���� ���� �߻�
-- �ڷ� ���Խ� �θ� Ű�� ���� ���� �߻�
INSERT INTO job_history VALUES(
    'IT_PROG2',
    '�� ���α׷���2',
    TO_DATE('2018-01-01','YYYY-MM-DD'),
    TO_DATE('2022-08-10','YYYY-MM-DD'),
    200
);
-- �ڷ� ������ �ڽ� ���ڵ尡 �߰ߵǴ� ����
DELETE employee WHERE empid = 101;
