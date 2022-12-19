create table if not exists product
(
    id          bigserial primary key,
    name        VARCHAR(64) UNIQUE NOT NULL,
    price       decimal,
	is_sale     boolean
);


create table if not exists discount_card
(
    id          bigserial primary key,
    number      integer unique,
    discount    decimal
);

create table if not exists  checks
(
    id          bigserial primary key,
    amount      decimal
);


insert into product (id, name, price, is_sale)
values (1,'Cream', 1.5, true),
       (2,'Wafer', 1, false ),
       (3,'Milk', 2.5, true),
       (4,'Avocado', 5.5, false),
       (5,'Chicken', 3.5, false),
       (6,'Bread', 1.51, true),
       (7,'Cakes', 1.78, true),
       (8,'Green', 2.27, false),
       (9,'Tomato', 3.53, false),
       (10,'Salad', 4.78, true),
       (11,'Duck', 12.25, false),
       (12,'Beef', 1.51, false),
       (13,'Bacon', 3.53, true),
       (14,'Bakes', 1.49, false),
       (15,'Sausages', 1.51, true),
       (16,'Pork', 12.25, false),
       (17,'Apple', 1.78, true),
       (18,'Banana', 3.53, false),
       (19,'Cherry', 1.78, true),
       (20,'Salmon', 1.51, false);

insert into discount_card (id, number, discount)
values (1, 1234, 2),
       (2, 2234, 5),
       (3, 3234, 1),
       (4, 4234, 7),
       (5, 5234, 1);

insert into checks (id, amount)
values (1,1),(2,2),(3,3),(4,4),(5,5),(6,1),(7,2),(8,1),(9,5),(10,3);