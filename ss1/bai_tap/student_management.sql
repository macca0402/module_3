create table student_management.Class
(
    id   int not null,
    name varchar(45) null
);
create table student_management.teacher
(
    id      int not null,
    name    varchar(45) null,
    age     int not null,
    country varchar(45) null
);
select *
from student_management.class;
select *
from student_management.teacher;