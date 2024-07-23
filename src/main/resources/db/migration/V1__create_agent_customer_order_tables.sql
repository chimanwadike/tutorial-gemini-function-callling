CREATE TABLE agents
(
    id           VARCHAR(6)   NOT NULL,
    agent_name   VARCHAR(255) NULL,
    working_area VARCHAR(255) NULL,
    commission   VARCHAR(255) NULL,
    phone_no     VARCHAR(255) NULL,
    country      VARCHAR(255) NULL,
    CONSTRAINT pk_agents PRIMARY KEY (id)
);

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
    agent_id           VARCHAR(6)   NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id                VARCHAR(6)   NOT NULL,
    order_amount      DOUBLE       NULL,
    advance_amount    DOUBLE       NULL,
    order_date        date         NULL,
    customer_id       VARCHAR(6)   NULL,
    agent_id          VARCHAR(6)   NULL,
    order_description VARCHAR(255) NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

ALTER TABLE customers
    ADD CONSTRAINT FK_CUSTOMERS_ON_AGENT FOREIGN KEY (agent_id) REFERENCES agents (id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_AGENT FOREIGN KEY (agent_id) REFERENCES agents (id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);
