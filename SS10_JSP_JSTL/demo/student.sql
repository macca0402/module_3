create database student;
use student;
create table student(
 id int primary key auto_increment,
 name varchar(50),
 gender boolean,
 point float
);
select * from student;
update student set student.name="Lan",student.gender=1,student.point=10 where student.id=2;
select * from student where id=1;
INSERT into student(id,name,gender,point) values (7,"Khoa",0,4);
delete from student where student.id=6;
