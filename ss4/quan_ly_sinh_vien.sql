use
quan_ly_sinh_vien;
-- 1
select *
from subject
having Credit = (select max(Credit) from subject);
-- 2
select subject.sub_name,
       subject.credit,
       subject.status,
       max(mark.mark) as max_point
from subject
         join mark on mark.sub_id = subject.sub_id
;
-- 3
select subject.student_name, avg(mark.mark) as diem_trung_binh
from student
         join mark on mark.student_id = subject.student_id
group by subject.student_name
order by diem_trung_binh desc;
 