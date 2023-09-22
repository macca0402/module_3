create
database if not exists quan_ly_product;
use
quan_ly_product;
create table products
(
    id                  int primary key auto_increment,
    product_code        varchar(50),
    product_name        varchar(50),
    product_price       float,
    product_amount      int,
    product_description varchar(50),
    product_status      varchar(50)
);

create unique index index_code on products (product_code);
create index index_name_price on products (product_name, product_price);
select *
from products;
explain
select count(*)
from product
where product_amount = 20;
select count(*)
from products;

create view code_name_price_status as
select p.product_code, p.product_name, p.product_price, p.product_status
from products p
;

drop view code_name_price_status;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter
//
create procedure info_product(in product_id int)
begin
select *
from products p
where p.id = product_id;
end
//
   delimiter ;

call info_product(2);
-- Tạo store procedure thêm một sản phẩm mới
delimiter
//
create procedure add_product(in product_code varchar (50), product_name varchar (50), product_price float,
                             product_amount int, product_description varchar (50), product_status nvarchar(10))
begin
INSERT INTO product (product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES (product_code, product_name, product_price, product_amount, product_description, product_status);
end
//
   delimiter ;

call add_product('DJSFH','KẸO',12000,90,'DẺO','CÒN');

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter
//
CREATE PROCEDURE sp_update_product(in
                                       id int,
                                   product_code varchar (50),
                                   product_name varchar (50),
                                   product_price float,
                                   product_amount int,
                                   product_description varchar (50),
                                   product_status varchar (50))
BEGIN
update products
set product_code=product_code,
    product_name=product_name,
    product_price=product_price,
    product_amount=product_amount,
    product_description=product_description,
    product_status=product_status
where products.id = id;
END
//
delimiter ;
call sp_update_product(1,'DFKSD','CAFE',9000,12,'TRUNG NGUYEN', 'SAP HET');

-- Tạo store procedure xoá sản phẩm theo id
delimiter
//
CREATE PROCEDURE sp_delete_product(in
    id int)
BEGIN
delete
from products
where products.id = id;
END
//
delimiter ;
call sp_delete_product(1);


    
   