create
database if not exists quan_ly_ban_hang;
use
quan_ly_ban_hang;

create table customer
(
    c_id          int primary key auto_increment,
    customer_name varchar(50),
    age           int
);

create table orders
(
    o_id        int primary key auto_increment,
    date_order  date,
    total_price float,
    customer_id int,
    foreign key (customer_id) references customer (c_id)
);

create table product
(
    id            int primary key auto_increment,
    name_product  varchar(50),
    product_price int
);

create table order_detail
(
    id_O  int,
    id_P  int,
    odQTY int,
    primary key (id_O, id_P),
    foreign key (id_O) references orders (o_id),
    foreign key (id_P) references product (id)
);

insert into customer(c_id, customer_name, age)
values (1, 'Minh Quan', 10),
       (2, 'Ngoc Oanh', 20),
       (3, 'Hong Ha', 50);

insert into orders(customer_id, date_order, total_price)
values (1, '2006-3-21', null),
       (2, '2006-3-23', null),
       (1, '2006-3-16', null);

insert into product(name_product, product_price)
values ('May Giat', 3),
       ('Tu Lanh', 5),
       ('Dieu Hoa', 7),
       ('Quat', 1),
       ('Bep Dien', 2);

insert into order_detail(id_O, id_P, odQTY)
values (1, 1, 3),
       (1, 3, 7),
       (1, 4, 2),
       (2, 1, 1),
       (3, 1, 8),
       (2, 5, 4),
       (2, 3, 3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o.o_id, o.date_order, o.total_price
from orders o;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.customer_name, p.name_product
from customer c
         join orders o on o.customer_id = c.c_id
         join order_detail od on od.id_O = o.o_id
         join product p on p.id = od.id_P
;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.customer_name
from customer c
         left join orders o on o.customer_id = c.c_id
         left join order_detail od on od.id_O = o.o_id
where od.id_P is null;



select o.o_id, o.date_order, p.product_price * od.odQTY as total_price
from orders o
         join order_detail od on o.o_id = od.id_O
         join product p on od.id_P = p.id;