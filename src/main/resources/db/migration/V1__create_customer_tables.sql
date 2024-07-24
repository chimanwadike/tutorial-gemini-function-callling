CREATE TABLE customers
(
    id                 VARCHAR(6)   NOT NULL,
    name               VARCHAR(255) NULL,
    city               VARCHAR(255) NULL,
    working_area       VARCHAR(255) NULL,
    country            VARCHAR(255) NULL,
    grade              INT          NULL,
    opening_amount     DOUBLE       NULL,
    receiving_amount   DOUBLE       NULL,
    payment_amount     DOUBLE       NULL,
    outstanding_amount DOUBLE       NULL,
    phone_no           VARCHAR(255) NULL,
    agent_id           VARCHAR(255) NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);
