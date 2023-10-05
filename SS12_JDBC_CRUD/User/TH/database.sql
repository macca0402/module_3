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
select * from users
where users.id=1;
delete from users where id=1;
update users set users.name="Nhi",users.email="yennhi@gmail.com",users.country="da nang" where id=2;
