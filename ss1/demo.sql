create
database if not exists a0323i1;
use
a0323i1;
-- tạo bảng đơn giản 
create table student
(
    id int primary key, 'name'
    varchar
(
    50
),
    birthday date

    )
-- select
select *
from student;
-- insert
INSERT into student (id, name, birthday)
values (2, 'chanh', '2002-02-02');
insert into student
values (3, 'chanh3', '2002-02-03'),
       (4, 'chanh4', '2000-02-03');
-- update
update student
set name='nhi'
where id = 1;
set
sql_safe_updates=0;
update student
set name = 'nhi11'
where name = 'nhi';
-- delete
delete
from student;
-- thêm mới cột cho bảng
alter table student add column('point' int);
alter table student drop column point;
-- drop table 
drop table student;
drop
database a0323i1;

-- phân biệt delete và truncate
