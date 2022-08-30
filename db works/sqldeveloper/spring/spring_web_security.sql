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


INSERT INTO users(username, password) values('user00', 'pw00'); 
INSERT INTO users(username, password) values('member00', 'pw00'); 
INSERT INTO users(username, password) values('admin00', 'pw00'); 

INSERT INTO authorities(username, authority) VALUES('user00', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('member00', 'ROLE_MEMBER');
INSERT INTO authorities(username, authority) VALUES('admin00', 'ROLE_MEMBER');
INSERT INTO authorities(username, authority) VALUES('admin00', 'ROLE_ADMIN');

SELECT * FROM users;
SELECT * FROM authorities;

ALTER TABLE users ADD enabled CHAR(1) DEFAULT '1';
ALTER TABLE users DROP COLUMN enable;

UPDATE authorities SET authority='ROLE_USER' WHERE authority='RULE_USER';
UPDATE authorities SET authority='ROLE_MEMBER' WHERE authority='RULE_MEMBER';
UPDATE authorities SET authority='ROLE_ADMIN' WHERE authority='RULE_ADMIN';
