--Bài tập phần 4


--1. Liệt kê tên nhân viên, mã phòng ban và lương nhân viên được tăng 15% (PCTSAL).
SELECT ENAME,DEPTNO,SAL + SAL*0.15 PCTSAL FROM EMP;

--2. Viết câu lệnh hiển thị như sau:
SELECT CONCAT(RPAD(ENAME,8,'*') , LPAD(JOB,8,'*')) EMPLOYEE_AND_JOB
FROM EMP;

--3. Viết câu lệnh hiển thị như sau:
SELECT CONCAT(ENAME||' (', JOB||')') EMPLOYEE FROM EMP;

--4. Viết câu lệnh hiển thị như sau:
SELECT ENAME,DEPTNO,JOB FROM EMP WHERE DEPTNO=30;

--5. Tìm ngày thứ 6 đầu tiên cách 2 tháng so với ngày hiện tại hiển thị ngày dưới dạng 09 February 1990.
select NEXT_DAY(ADD_MONTHS(SYSDATE,2),'FRIDAY') "FIRST FRIDAY" FROM DUAL;

--6. Tìm thông itn về tên nhân viên, ngày gia nhập công ty của nhân viên phòng số 20, sao cho hiển thị như sau:
select ENAME, TO_CHAR( HIREDATE,'MONTH/dd/yyyy') DATE_HIRED FROM EMP WHERE DEPTNO =20;

--7. Hiển thị tên nhân viên, ngày gia nhập công ty, ngày xét nâng lương (sau ngày gia nhập công ty 1 năm), sắp xếp theo thứ tự ngày xét nâng lương.
select ENAME, HIREDATE, ADD_MONTHS(hiredate,12) HIREDATE_REVIEW  FROM EMP
ORDER BY HIREDATE_REVIEW;

--8. Hiển thị tên nhân viên và lương dưới dạng
select ENAME,(CASE WHEN SAL<1500 THEN 'BELOW 1500' WHEN SAL>1500 THEN TO_CHAR(SAL) WHEN SAL = 1500 THEN 'ONTARGET' END ) salary from emp;

--9. Cho biết thứ của ngày hiện tại
select to_char(sysdate,'DAY') date_system from dual;

--10 Đưa chuỗi dưới dạng nn/nn, kiểm tra nếu khúng khuôn dạng trả lời là YES, ngược lại là NO. Kiểm tra với các chuỗi 12/34, 01/1a, 99\88
select decode('12/34','12/34','yes','01/1a','no','99\98','no','udefine') decode_check from dual;

--11 Hiển thị tên nhân viên, ngày gia nhập công ty, ngày lĩnh lương sao cho ngày lĩnh lương phải vào thứ 6, nhân viên chỉ được nhận lương sau ít nhất 15 ngày làm việc tại công ty, sắp xếp theo thứ tự ngày gia nhập công ty.
select ename,hiredate, next_day(hiredate + 15,'friday') salarydate from emp where ((current_date-hiredate)>15) order by HIREDATE;

--4.5.2. Hàm trên nhóm dữ liệu

--1. Tìm lương thấp nhất, lớn nhất và lương trung bình của tất cả các nhân viên
select min(sal) as minsalary,max(sal) as maxsalary,round(avg(sal),2) as average from emp;

--2. Tìm lương nhỏ nhất và lớn của mỗi loại nghề nghiệp
select job, max(sal),min(sal) from emp group by job;

--3. Tìm xem có bao nhiêu giám đốc trong danh sách nhân viên.
select count(*) manager from emp where job= 'MANAGER';

--4. Tìm tất cả các phòng ban mà số nhân viên trong phòng >3
select deptno,count(*)as Tong_NV from emp
group by deptno
having count(*)>3;

select * from emp;
--5. Tìm ra mức lương nhỏ nhất của mỗi nhân viên làm việc cho một giám đốc nào đó sắp xếp theo thứ tự tăng dần của mức lương.
select job,min(sal) from emp where job!='MANAGER' group by job;