create database if not exists ss12;
use ss12;

create table users(
id int(3) primary key not null auto_increment,
name varchar(120) not null,
email varchar(220) not null,
country varchar(120)
);

insert into users(name,email,country) values('Minh','minh@codegym.vn','VietNam');

insert into users(name,email,country) values('Kante','kante@che.uk','Kenia');

select * from users;
where users.id=1;
delete from users where id=1;
update users set users.name="Nhi",users.email="yennhi@gmail.com",users.country="da nang" where id=2;


delimiter //
create procedure find_all()
begin
select * from users;
end
//
delimiter ; 
call find_all();

delimiter //
create procedure updateInfo(in NEW_ID int,NEW_NAME varchar(120),NEW_EMAIL varchar(220),NEW_COUNTRY varchar(120))
begin
update users set users.name=NEW_NAME,users.email=NEW_EMAIL,users.country=NEW_COUNTRY where id=NEW_ID;
end
//
delimiter ;

CALL updateInfo(7,"Lan","lan@gmail.com","NewYork");

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user


delimiter //
create procedure deleteUser(in new_id int)
begin

end 
// 
delimiter ;