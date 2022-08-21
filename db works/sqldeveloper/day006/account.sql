CREATE TABLE account(
    ano     VARCHAR2(20) PRIMARY KEY,
    owner   VARCHAR2(20) NOT NULL,
    balance NUMBER NOT NULL
);

INSERT INTO account VALUES('111-1234-1234', '¿Ã¡§»£', 1000);

SELECT * FROM account;

COMMIT;