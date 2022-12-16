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
    number      INTEGER UNIQUE,
    discount    INTEGER
);

CREATE TABLE IF NOT EXISTS  checks
(
    id          SERIAL PRIMARY KEY,
    amount      INTEGER
);


INSERT INTO product (id, name, price, sale)
VALUES (1,'Cream', 1.5, 2),
       (2,'Wafer', 1, 5),
       (3,'Milk', 2.5, 0),
       (4,'Avocado', 5.5, 0),
       (5,'Chicken', 3.5, 0),
       (6,'Bread', 1.51, 0),
       (7,'Cakes', 1.78, 1),
       (8,'Green', 2.27, 0),
       (9,'Tomato', 3.53, 1),
       (10,'Salad', 4.78, 1),
       (11,'Duck', 12.25, 1),
       (12,'Beef', 1.51, 0),
       (13,'Bacon', 3.53, 1),
       (14,'Bakes', 1.49, 1),
       (15,'Sausages', 1.51, 0),
       (16,'Pork', 12.25, 1),
       (17,'Apple', 1.78, 1),
       (18,'Banana', 3.53, 1),
       (19,'Cherry', 1.78, 1),
       (20,'Salmon', 1.51, 0);

INSERT INTO discount_card (id, number, discount)
VALUES (1, 1234, 2),
       (2, 2234, 5),
       (3, 3234, 1),
       (4, 4234, 7),
       (5, 5234, 1);

INSERT INTO checks (id, amount)
VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,1),(7,2),(8,1),(9,5),(10,3);