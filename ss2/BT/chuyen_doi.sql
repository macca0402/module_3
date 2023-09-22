create
database if not exists mo_hinh_quan_he;
use
mo_hinh_quan_he;

create table export_bill
(
    id          int primary key auto_increment,
    date_export date
);

create table supplies
(
    id   int primary key auto_increment,
    name varchar(50)
);

create table export_bill_supplies
(
    price_export   float,
    quantity       int,
    export_bill_id int,
    supplies_id    int,
    primary key (export_bill_id, supplies_id),
    foreign key (export_bill_id) references export_bill (id),
    foreign key (supplies_id) references supplies (id)
);

create table factory
(
    id     int primary key auto_increment,
    name   varchar(50),
    adress varchar(50)
);

create table orders
(
    id         int primary key auto_increment,
    date_order date,
    factory_id int,
    foreign key (factory_id) references factory (id)
);

create table import_bill
(
    id          int primary key auto_increment,
    date_import date
);

create table import_bill_supplies
(
    price_import   float,
    quantity       int,
    import_bill_id int,
    supplies_id    int,
    primary key (import_bill_id, supplies_id),
    foreign key (import_bill_id) references import_bill (id),
    foreign key (supplies_id) references supplies (id)
);

create table supplies_orders
(
    orders_id   int,
    supplies_id int,
    primary key (orders_id, supplies_id),
    foreign key (orders_id) references orders (id),
    foreign key (supplies_id) references supplies (id)
);

create table numberphone
(
    id         int primary key,
    name       varchar(50),
    factory_id int,
    foreign key (factory_id) references factory (id)
);
