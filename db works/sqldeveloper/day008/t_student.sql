CREATE TABLE t_student(
    stdid   NUMBER(3) PRIMARY KEY,
    stdname VARCHAR2(20) NOT NULL
);

DESCRIBE t_student;

INSERT INTO t_student(stdid, stdname) 
VALUES(1, '��k��');

SELECT * FROM t_student;
