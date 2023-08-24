create database if not exists quanlybanhang;
use quanlybanhang;

create table customer(
Cid int primary key,
cName varchar(50),
age varchar(50)
);
create table orders(
Oid int primary key,
date_order date,
total_price float,
customer_id int,
foreign key (customer_id) references customer(Cid)
);
create table product(
id int primary key ,
name_product varchar(50),
product_price int 
);
create table order_detail(
id_O int,
id_P int,
odQTY int,
primary key(id_O,id_P),
foreign key( id_O) references orders(Oid),
foreign key( id_P) references product(id)
)
