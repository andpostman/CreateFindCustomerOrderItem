create schema if not exists marketplace;

create table if not exists marketplace.customer
(
    id   serial,
    first_name varchar,
    last_name varchar,
    email varchar,
    primary key (id)
);

create table if not exists marketplace.order
(
    id          serial,
    date        date,
    customer_id int not null,
    primary key (id),
    foreign key (customer_id) references marketplace.customer (id)
);
create table if not exists marketplace.item
(
    id       serial,
    name     varchar,
    order_id int not null,
    primary key (id),
    foreign key (order_id) references marketplace.order (id)
);

insert into marketplace.customer (first_name, last_name, email)
values ('Roma', 'Serov','ser@mail.ru');
insert into marketplace.customer (first_name, last_name, email)
values ('Andrew', 'Klimov','klim@mail.ru');
insert into marketplace.customer (first_name, last_name, email)
values ('Stan', 'Lomov','lomov@mail.ru');
insert into marketplace.order(date, customer_id)
values (CURRENT_DATE, 1);
insert into marketplace.order(date, customer_id)
values (CURRENT_DATE, 1);
insert into marketplace.order(date, customer_id)
values (CURRENT_DATE, 1);
insert into marketplace.order(date, customer_id)
values (CURRENT_DATE, 2);
insert into marketplace.order(date, customer_id)
values (CURRENT_DATE, 2);
insert into marketplace.order(date, customer_id)
values (CURRENT_DATE, 3);
insert into marketplace.item(name, order_id)
values ('fork', 1);
insert into marketplace.item(name, order_id)
values ('spoon', 1);
insert into marketplace.item(name, order_id)
values ('knife', 1);
insert into marketplace.item(name, order_id)
values ('fork', 2);
insert into marketplace.item(name, order_id)
values ('spoon', 2);
insert into marketplace.item(name, order_id)
values ('knife', 2);
insert into marketplace.item(name, order_id)
values ('fork', 3);


