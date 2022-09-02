CREATE TABLE users(
    username    VARCHAR2(50) NOT NULL PRIMARY KEY,
    password    VARCHAR2(50) NOT NULL,
    enabled      CHAR(1) DEFAULT '1'
);

CREATE TABLE authorities(
    username    VARCHAR2(50) NOT NULL,
    authority   VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username)
    REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities(username, authority);

CREATE TABLE tbl_member(
    userid      VARCHAR2(50) PRIMARY KEY,
    userpw      VARCHAR2(100) NOT NULL,
    username    VARCHAR2(100) NOT NULL,
    regdate     DATE DEFAULT SYSDATE,
    updatedate  DATE DEFAULT SYSDATE,
    enabled     CHAR(1) DEFAULT '1'
);

CREATE TABLE tbl_member_auth(
    auth        VARCHAR2(50) NOT NULL,
    userid      VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_member_auth FOREIGN KEY(userid)
    REFERENCES tbl_member(userid)
);



INSERT INTO users(username, password) values('user00', 'pw00'); 
INSERT INTO users(username, password) values('member00', 'pw00'); 
INSERT INTO users(username, password) values('admin00', 'pw00'); 

INSERT INTO authorities(username, authority) VALUES('user00', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('member00', 'ROLE_MEMBER');
INSERT INTO authorities(username, authority) VALUES('admin00', 'ROLE_MEMBER');
INSERT INTO authorities(username, authority) VALUES('admin00', 'ROLE_ADMIN');

SELECT * FROM users;
SELECT * FROM authorities;
SELECT * FROM tbl_member ORDER BY updatedate DESC; 
SELECT * FROM tbl_member_auth;

DELETE FROM tbl_member;

ALTER TABLE users ADD enabled CHAR(1) DEFAULT '1';
ALTER TABLE users DROP COLUMN enable;

UPDATE authorities SET authority='ROLE_USER' WHERE authority='RULE_USER';
UPDATE authorities SET authority='ROLE_MEMBER' WHERE authority='RULE_MEMBER';
UPDATE authorities SET authority='ROLE_ADMIN' WHERE authority='RULE_ADMIN';
UPDATE tbl_member 
SET userid='user00', username='user00-up', updatedate=SYSDATE
WHERE userid = 'user00';

SELECT * FROM tbl_member m LEFT JOIN tbl_member_auth ma ON m.userid=ma.userid WHERE m.userid = 'user00';

SELECT m.userid, userpw, username, enabled, regdate, updatedate, auth  FROM tbl_member m 
LEFT OUTER JOIN tbl_member_auth ma ON m.userid = ma.userid 
WHERE m.userid = 'user00';

ALTER TABLE tbl_member_auth MODIFY CONSTRAINT fk_member_auth ON UPDATE CASCADE;
