

-- Bài tập phần 5
--1. Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng ban.
select ENAME,DNAME from EMP,DEPT where emp.DEPTNO = DEPT.DEPTNO;

-- 2. Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
select ENAME,LOC,DNAME from EMP,DEPT where EMP.DEPTNO=DEPT.DEPTNO;

-- 3. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương
select ENAME,JOB,SAL,GRADE from EMP,SALGRADE;

--4. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với điều kiện mức lương=3.
select ENAME,JOB,SAL,GRADE from EMP,SALGRADE where GRADE =3;

--5. Hiển thị những nhân viên tại DALLAS
select ENAME,LOC,SAL from EMP,DEPT where  LOC like 'DALLAS';

--6. Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân viên có nghề là cleck và sắp xếp theo chiều giảm.
select ENAME,JOB,SAL,GRADE,DNAME from EMP,DEPT,SALGRADE where JOB != 'CLERK' order by JOB desc ;

--7. Hiển thị chi tiết về những nhân viên kiếm được 36000 $ 1 năm hoặc nghề là cleck. (gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)
select ENAME, JOB, SAL*12 as ANUAL_SAL, DNAME,GRADE from EMP,DEPT,SALGRADE where SAL*12 >= 36000 or JOB ='CLERK';

--8. Hiển thị những phòng không có nhân viên nào làm việc.
select DEPTNO,DNAME,LOC from DEPT where DEPTNO not in (select DEPTNO from EMP);

--9. Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý
Select e.ename emp_name, e.sal emp_sal,
       m.ename mgr_name, m.sal mgr_sal
from emp e, emp m
where e.mgr = m.empno;

--10. Như câu 9 hiển thị thêm thông tin về ông KINGSQL:
Select e.ename emp_name, e.sal emp_sal,m.ename mgr_name, m.sal mgr_sal from emp e left outer join emp m on e.mgr=m.empno;

--11. Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào năm 1994.
select distinct JOB from EMP where (extract(year from HIREDATE)=1981) and (extract(year from HIREDATE)!=1994);

--12. Tìm những nhân viên gia nhập công ty trước giám đốc của họ
select e.ENAME EMP_NAME, to_char(e.HIREDATE,'DD-MM-YYYY') EMP_HIREDATE, m.ENAME MGR_NAME, to_char(m.HIREDATE,'DD-MM-YYYY') MGR_HIREDATE from EMP e, EMP m
where e.HIREDATE < m.HIREDATE;

--13. Tìm tất cả các nhân viên, ngày gia nhập công ty, tên nhân viên, tên người giám đốc
-- và ngày gia nhập công ty của người giám đốc ấy.
select e.ename emp_name,to_char(e.hiredate,'DD-MM-YYYY') emp_hiredate,m.ename mgr_name, to_char(m.hiredate,'DD-MM-YYYY') mgr_hiredate from emp e left join emp m on e.mgr=m.empno;

--14. Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.
select JOB,max(SAL) from EMP group by JOB

--15.Tìm mức lương cao nhất trong mỗi phòng ban, sắp xếp theo thứ tự phòng ban.
select ENAME, JOB, DEPTNO,SAL from EMP where SAL in (select max(sal) from EMP group by DEPTNO) order by DEPTNO;

--16 Tìm nhân viên gia nhập vào phòng ban sớm nhất
select ENAME,to_char(HIREDATE,'dd-mm-yyyy') HIREDATE,DEPTNO from EMP where HIREDATE in (select min(HIREDATE) from EMP group by DEPTNO);

--17. Hiển thị những nhân viên có mức lương lớn hơn lương TB của phòng ban mà họ làm việc.
Select Empno ,Ename ,Sal,emp.Deptno From emp inner Join (Select Deptno ,avg(Sal) avgsal From emp Group By Deptno) tblsalavg On emp.Deptno=tblsalavg.Deptno Where Sal > tblsalavg.avgsal order by deptno;

--18. Hiển thị tên nhân viên, mã nhân viên, mã giám đốc, tên giám đốc, phòng ban làm việc của giám đốc, mức lương của giám đốc.
select e.EMPNO EMP_number, e.ENAME EMP_NAME, e.SAL EMP_SAL, m.mgr mgr_number, m.ENAME mgr_NAME, m.DEPTNO mgr_DEPT, GRADE from EMP e inner join EMP m on e.MGR = m.EMPNO ,SALGRADE
