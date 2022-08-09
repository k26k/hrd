CREATE TABLE dbcp_test(
    name    VARCHAR2(20) not null,
    email   VARCHAR2(30) PRIMARY KEY
);

INSERT INTO dbcp_test VALUES('qwer', 'asdf');

SELECT * FROM dbcp_test;