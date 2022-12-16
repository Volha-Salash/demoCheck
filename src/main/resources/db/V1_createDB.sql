CREATE TABLE IF NOT EXISTS product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(64) UNIQUE NOT NULL,
    price       NUMERIC,
    sale        INTEGER
);


CREATE TABLE IF NOT EXISTS discount_card
(
    id          SERIAL PRIMARY KEY,
    number      VARCHAR(64) UNIQUE,
    discount    INTEGER
);


INSERT INTO product (id, name, price, sale) VALUES (1,'Milk', 2.5, 5);

INSERT INTO discount_card (id, number, discount) VALUES (1, 1234, 2);