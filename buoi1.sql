--bai tap phan 2
--1. Chọn toàn bộ thông tin trong bảng SALGRADE
select * from  SALGRADE;

--2. Chọn toàn bộ thông tin trong bảng EMP
select * from EMP;

--3 Hiển thị mọi loại nghề nghiệp 
select JOB from EMP;

--4. Hiển thị tên nhân viên và thu nhập trong một năm (REMUNERATION)
select ENAME, SAL * 12 REMUNERATION   from EMP;

--5. Hiển thị theo nội dung dưới đây Who, what and when
select ENAME || ' HAS HELP THE POSITION OF' || JOB ||' in dept' || DEPTNO ||' since ' || TO_CHAR(HIREDATE,'dd/MM/yyyy')  from EMP;

--6. Hiển thị cấu trúc bảng emp;
Describe emp;

--7. Thay đổi nhãn và định dạng hiển thị của cột sal và hiredate trong bảng emp;
select hiredate,to_char(sal,'$9999,999.00') salary from emp;

--bai tap phan 3
--1. Chọn nhân viên trong bảng EMP có mức lương từ 1000 đến 2000 (chọn các trường ENAME, DEPTNO, SAL). 
select ENAME,DEPTNO,SAL from EMP where SAL between 1000 and 2000;

--2. Hiển thị mã phòng ban, tên phòng ban, sắp xếp theo thứ tự tên phòng ban.
select DEPTNO,DNAME from DEPT
order by DNAME asc;

--3. Hiển thị danh sách những nhân viên làm tại phòng 10 và 20 theo thứ tự A,B,C
select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO from EMP
where DEPTNO in (10,20);

--4. Hiển thị tên và nghề nghiệp những nhân viên làm nghề thư ký (cleck) tại phòng 20.
select ENAME,JOB from EMP where JOB like 'CLERK';

--5. Hiển thị tất cả những nhân viên mà tên có các ký tự TH và LL
select ENAME from EMP where ENAME like '%TH' or ENAME like'%LL';

--6. Hiển thị tên nhân viên, nghề nghiệp, lương của những nhân viên có giám đốc quản lý.
select ENAME,JOB,SAL from EMP where JOB NOT like 'MANAGER' and JOB NOT like 'PRESIDENT';

--7. Hiển thị tên nhân viên, mã phòng ban, ngày gia nhập công ty sao cho gia nhập công ty trong năm 1983. 
select ENAME,DEPTNO,HIREDATE from EMP
where HIREDATE like '%-83';

--8. Hiển thị tên nhân viên, lương một năm (ANUAL_SAL ), thưởng sao cho lương lớn hơn thưởng và nghề nghiệp là SALEMAN, sắp theo thứ tự lương giảm dần và tên tăng dần. 
select ENAME,SAL*12 ANUAL_SAL,COMM from EMP
where SAL > COMM and JOB like 'SALESMAN' --có SALEMAN VÀ SALESMAN
order by SAL desc,ENAME asc;