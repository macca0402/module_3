create
database if not exists quan_ly_sinh_vien;
use
quan_ly_sinh_vien;
create table class
(
    class_id     int primary key auto_increment,
    class_name   varchar(50),
    start_date   date,
    status_class boolean
);
create table student
(
    student_id     int primary key auto_increment,
    student_name   varchar(50),
    student_adress varchar(50),
    student_phone  varchar(50),
    status_student boolean,
    class_id       int,
    foreign key (class_id) references class (class_id)
);
create table subject
(
    sub_id     int primary key auto_increment,
    sub_name   varchar(50),
    credit     float,
    status_sub boolean
);
create table mark
(
    mark_id    int primary key auto_increment,
    sub_ID     int,
    stu_ID     int,
    foreign key (sub_ID) references subject (sub_id),
    foreign key (stu_ID) references student (student_id),
    mark       float,
    exam_times int
);
INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
INSERT INTO Student (student_name, student_adress, student_phone, status_student, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student(student_name, student_adress, status_student, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student(student_name, student_adress, student_phone, status_student, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO Mark(sub_ID, stu_ID, mark, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
select *
from class c;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select *
from student s
where s.student_name like 'H%';


-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select *
from class c
where c.start_date like '%-12-%';

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from subject s
where s.credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
SET
SQL_SAFE_UPDATES = 0;
update student s
set s.class_id=2
where s.student_name like 'Hung';
select *
from mark;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select quan_ly_sinh_vien.student.student_name, quan_ly_sinh_vien.mark.mark, quan_ly_sinh_vien.subject.sub_name
from student
         join quan_ly_sinh_vien.mark on quan_ly_sinh_vien.student.student_id = quan_ly_sinh_vien.mark.stu_ID
         join quan_ly_sinh_vien.subject on quan_ly_sinh_vien.mark.sub_ID = quan_ly_sinh_vien.subject.sub_id
order by mark desc, quan_ly_sinh_vien.student.student_name
;







