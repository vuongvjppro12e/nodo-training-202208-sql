-- câu hỏi phần 8
--1. Thêm dữ liệu vào bảng PROJECTS.
insert into PROJECT_VUONGCT(projid,p_desc,p_start_date,p_end_date,budget_amount,max_no_staff)
values('1','WRITE C030 COURSE',to_date('02-JAN-88','DD-MON-RR'),to_date('07-JAN-88','DD-MON-RR'),'500','1');
insert into PROJECT_VUONGCT(projid,p_desc,p_start_date,p_end_date,budget_amount,max_no_staff)
values('3','PROOF READ NOTES',to_date('01-JAN-89','DD-MON-RR'),to_date('10-JAN-89','DD-MON-RR'),'600','1');
SELECT * FROM PROJECT_VUONGCT;

--2. Thêm dữ liệu vào bảng ASSIGNMENTS.
insert into ASSIGNMENT_VUONGCT(PROJID,EMPNO,A_START_DATE,A_END_DATE,BILL_AMOUNT,ASSIGN_TYPE,HOURS)
values('1','7369',to_date('01-JAN-88','DD-MON-RR'),to_date('03-JAN-88','DD-MON-RR'),'50','WR','15');
select * from ASSIGNMENT_VUONGCT;

--3. Cập nhật trường ASIGNMENT_TYPE từ WT thành WR
update ASSIGNMENT_VUONGCT set ASSIGN_TYPE='WR' where ASSIGN_TYPE='WT';
select * from ASSIGNMENT_VUONGCT;

--câu hỏi phần 9
--1. Tạo Index trên cột PROJID cho bảng ASSIGNMENT.
create index i_vct_pro on PROJECT_VUONGCT (projid);

--2. Hiển thị danh sách của nhân viên thuộc sự quản lý của người có tên là 1 biến được nhập từ bàn phím
select e.empno,e.ename,e.job,m.mgr,e.hiredate,e.sal,e.comm,e.deptno
from emp e join emp m on e.mgr=m.empno
where m.mgr =(select mgr from emp where ename='&ename');