create database if not exists quan_ly_don_dat_hang;
use quan_ly_don_dat_hang;
create table orderer(
id int primary key auto_increment,
full_name varchar(50)

);
create table product(
id int primary key auto_increment,
name_product nvarchar(50),
unit nvarchar(50),
description_product varchar(50)
);
create table orderer_product(
orderer_id int ,
product_id int,
primary key(orderer_id,product_id),
foreign key (orderer_id) references orderer(id),
foreign key (product_id) references product(id),
id int primary key auto_increment,
order_date date,
order_quantity int,
);
create table shipper(
id int primary key auto_increment,
full_name varchar(50)

)
create table customer(
id int primary key auto_increment,
full_name varchar(50)

)