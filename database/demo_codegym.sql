create
database if not exists demo_database;
use
demo_database;
create table jame
(
    username varchar(50) primary key,
    password varchar(50)
);
create table class
(
    class_id   int primary key auto_increment,
    class_name varchar(50)
);
create table student
(
    id_student       int primary key auto_increment,
    student_name     varchar(50),
    gender_student   boolean,
    birthday_student date,
    email_student    varchar(50),
    point_student    float,
    usename_student  varchar(50),
    class_id         int,
    foreign key (class_id) references class (class_id)
);

create table instructor
(
    instructor_id       int primary key auto_increment,
    instructor_name     varchar(50),
    instructor_birthday date,
    salary              float
);
create table room
(
    room_id   int primary key auto_increment,
    room_name varchar(50),
    class_id  int,
    foreign key (class_id) references class (class_id)
);
create table instructor_class
(
    instructor_id int,
    class_id      int,
    primary key (instructor_id, class_id),
    foreign key (instructor_id) references instructor (instructor_id),
    foreign key (class_id) references class (class_id),
    start_date    date,
    end_date      date
);
insert into class(class_name)
values ('c1121g1'),
       ('c1221g1'),
       ('a0821i1'),
       ('a0921i1');
insert into room(room_name, class_id)
values ('Ken', 1),
       ('Jame', 1),
       ('Ada', 2),
       ('Andy', 2);

insert into jame(`username`, `password`)
values ('cunn', '12345'),
       ('chunglh', '12345'),
       ('hoanhh', '12345'),
       ('dungd', '12345'),
       ('huynhtd', '12345'),
       ('hainm', '12345'),
       ('namtv', '12345'),
       ('hieuvm', '12345'),
       ('kynx', '12345'),
       ('vulm', '12345');

insert into jame(`username`, `password`)
values ('chau', '12345');

insert into instructor(instructor_name, instructor_birthday, salary)
values ('tran van chanh', '1985-02-03', 100),
       ('tran minh chien', '1985-02-03', 200),
       ('vu thanh tien', '1985-02-03', 300);
insert into instructor(instructor_name, instructor_birthday, salary)
values ('tran van nam', '1989-12-12', 100);



insert into student(student_name, birthday_student, gender_student, point_student, class_id, usename_student)
values ('nguyen ngoc cu', '1981-12-12', 1, 8, 1, 'cunn'),
       ('le hai chung', '1981-12-12', 1, 5, 1, 'chunglh'),
       ('hoang huu hoan', '1990-12-12', 1, 6, 2, 'hoanhh'),
       ('dau dung', '1987-12-12', 1, 8, 1, 'dungd'),
       ('ta dinh huynh', '1981-12-12', 1, 7, 2, 'huynhtd'),
       ('nguyen minh hai', '1987-12-12', 1, 9, 1, 'hainm'),
       ('tran van nam', '1989-12-12', 1, 4, 2, 'namtv'),
       ('vo minh hieu', '1981-12-12', 1, 3, 1, 'hieuvm'),
       ('le xuan ky', '1981-12-12', 1, 7, 2, 'kynx'),
       ('le minh vu', '1981-12-12', 1, 7, 1, 'vulm');

insert into student(student_name, birthday_student, gender_student, point_student, class_id)
values ('nguyen van a', '1981-12-12', 1, 8, null),
       ('tran van b', '1981-12-12', 1, 5, null);

--   insert into student(`name`,birthday, gender,`point`, class_id,`username`) 
--  values ('nguyen minh hai chau','1981-12-12',1,8,null,'chau');

insert into instructor_class(class_id, instructor_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 2);

select *
from room;
select*
from class;
select*
from student;
select*
from jame;
select*
from instructor;
select *
from instructor_class;
-- Lấy ra thông tin các học viên có lớp học và cho biết các học viên đang theo học lớp nào
select student.*
from student
         join class on class.class_id = student.class_id;
-- Lấy ra thông tin các học viên và cho biết các học viên đang theo học lớp nào và cả các bạn đã đăng ký nhưng chưa có lớp
select student.*, ifnull(class.class_name, 'chưa có lớp') as ten_lop
from student
         left join class on class.class_id = student.class_id;
-- Lấy ra thông tin của các bạn học viên tên 'nguyen minh hai'
select *
from student
where student.student_name like 'nguyen minh hai';
-- Lấy ra học viên có họ là 'nguyen'
select *
from student
where student.student_name like 'nguyen%';
-- Lấy ra các học viên có điểm lớn hơn 5
select *
from student
where student.point_student > 5;

-- Lấy ra thông tin các học viên có điểm 4,6,8
select *
from student
where student.point_student in (4, 6, 8);

-- Đếm số lượng học sinh theo từng lớp
select student.class_id, class.class_name, count(student.id_student) as so_luong
from student
         join class on student.class_id = class.class_id
group by class.class_id;

-- Thống kế số lượng học sinh theo từng loại điểm
select point_student, count(student.point_student) as so_luong_hoc_sinh
from student
group by student.point_student;
-- Thống kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
select point_student, count(student.point_student) as so_luong_hoc_sinh
from student
where point_student > 5
group by student.point_student;
-- Thống kê số lượng học sinh theo điểm lớn hơn 5 và chỉ hiển thị với số lượng >=2
select point_student, count(student.point_student) as so_luong_hoc_sinh
from student
where point_student > 5
group by student.point_student
having so_luong_hoc_sinh >= 2;

-- Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp học viên theo point giảm dần , 
-- nếu bằng nhau thì sắp xếp  theo tên tăng dần
select student.*, class.class_name
from student
         join class on class.class_id = student.class_id
where class.class_id = 1
order by point_student desc, student_name asc
;
-- Lấy ra thông tin của các học viên ten 'hai' or 'huynh'
select *
from student
where student_name like '%hai'
   or student_name like '%huynh'

-- RegexP : lấy ra học viên có tên bắt đầu bằng chữ H 
select *
from student
where student_name regexP('\\SH\\w*$');

-- Đếm số lượng học viên của trung tâm
select count(id_student) as so_luong
from student
-- Lấy ra các loại điểm duy nhất
select distinct(point_student)
from student;
-- Thống kê số lượng học sinh theo loại điểm >5 và chỉ hiển thị số lượng >=2
select point_student, count(id_student) as so_luong
from student
where point_student > 5
group by point_student
having so_luong >= 2;
-- BÀI 4
-- Hiển thị danh sách các lớp có học viên theo học và số lượng theo học viên của mỗi lớp
select class.class_id, class.class_name, count(class.class_id) as so_luong_hoc_vien
from student
         join class
              on class.class_id = student.class_id
group by class.class_id

-- Tính điểm lớn nhất của mỗi các lớp
select class.*, max(student.point_student) as diem_cao_nhat
from class
         join student
              on student.class_id = class.class_id
group by class.class_id
-- Tính điểm trung bình của từng lớp
select class.class_id, avg(student.point_student) as diem_trung_binh
from class
         join student
              on student.class_id = class.class_id
group by class.class_id
-- Lấy ra toàn bộ tên và ngày sinh của học viên và instructor ở data
select instructor_name, instructor_birthday
from instructor
union
select student_name, birthday_student
from student
-- Lấy ra top 3 học viên có điểm cao nhất của trung tâm
select student.student_name, student.point_student
from student
order by point_student desc limit 3;
-- 3 record tiếp theo
select student.student_name, student.point_student
from student
order by point_student desc limit 3,3;
-- Lấy ra các học viên có điểm số lớn nhất của trung tâm
select *
from student
where point_student = (select max(student.point_student) as diem_cao_nhat
                       from student);

-- Lấy ra tất cả các giảng viên chưa từng tham gia giảng dạy
select instructor_id, instructor_name
from instructor
where instructor_id not in
      (select instructor_id
       from instructor_class)
-- Hiển thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp và tên phòng học của từng lớp
select class.*, count(class.class_id) as so_luong_hoc_vien
from class
         join student on student.class_id = class.class_id
group by class.class_id;

-- hiển thị danh sách lớp có tên phòng học của từng lớp
select class.*, group_concat(room.room_name)
from class
         join room on room.class_id = class.class_id
group by class.class_id
-- Tính điểm lớn nhất của mỗi lớp
select class.*, max(student.point_student)
from class
         join student on student.class_id = class.class_id
group by class.class_id

-- Tính điểm trung bình của từng lớp
select class.*, avg(student.point_student)
from class
         join student on student.class_id = class.class_id
group by class.class_id
-- BÀI 5 
-- 	TẠO INDEX CHO BẢNG CUSTOMER
create index i_city on customers (city)
alter table customer
    add index i_country(country)
-- XÓA
delete
index i_city on customers
alter table customers drop index i_country;

-- VIEW 
create view w_student as
select s.id_student, s.student_name
from student s
         join class c on c.class_id = s.class_id;

-- HIỂN THỊ VIEW
select *
from w_student;

-- XÓA VIEW
drop view w_student;
-- STORED PROCEDURE 
-- tạo 1 sp ko có tham số  ( lấy toàn bộ thông tin học viên ) 
delimiter
//
create procedure get_all_student()
begin
select student.id_student, class.class_name
from student
         join class on class.class_id = student.class_id;
end
//
delimiter ;

-- SỬ DỤNG STORED PROCEDURE 
call get_all_student();

-- SỬ DỤNG SP CÓ 1 THAM SỐ KIỂU IN , TẠO SP HIỂN THỊ THÔNG TIN SINH VIEN THEO ID
delimiter
//
create procedure find_student_by_id(in id int)
begin
select student.*
from student
         join class on class.class_id = student.class_id
where student.id_student = id;
end
//
delimiter ;
call find_student_by_id(1);
-- TAOJ 1 FUNCTION KIỂM TRA ĐIỂM
delimiter
//
create function check_point(point int)
    returns varchar(10)
    deterministic
begin
 declare
result varchar(10);
 if
point >=6 then
	set result='pass';
else 
	set result='fail';
end if;
return result;
end
//
delimiter ;
-- GỌI FUNCTION
select check_point(5);
select student_name, point_student, check_point(point_student) as pass_fail
from student;

-- TẠO TRIGGER


create table history
(
    id         int auto_increment primary key,
    name       varchar(50),
    old_point  int,
    new_point  int,
    update_day date
);

delimiter
//
create trigger tr_history
    after update
    on student
    for each row
begin
    insert into history(name, old_point, new_point, update_day)
    values (old.name, old.point, new.point, now());
end //
delimiter;

 
