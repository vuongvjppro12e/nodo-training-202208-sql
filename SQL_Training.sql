--bai tap phan 2
--1
select * from  SALGRADE;
--2
select * from EMP;
--3
select JOB from EMP;
--4
select ENAME, SAL * 12 REMUNERATION   from EMP;
--5
select ENAME || ' HAS HELP THE POSITION OF' || JOB ||' in dept' || DEPTNO ||' since ' || TO_CHAR(HIREDATE,'dd/MM/yyyy')  from EMP;
--6
--7

--bai tap phan 3
--1
select ENAME,DEPTNO,SAL from EMP where SAL between 1000 and 2000
--2
select DEPTNO,DNAME from DEPT
order by DNAME asc;
--3
select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO from EMP
where DEPTNO in (10,20);
--4
select ENAME,JOB from EMP where JOB like 'CLERK';
--5
select ENAME from EMP where ENAME like '%TH' or ENAME like'%LL';
--6
select ENAME,JOB,SAL from EMP where JOB NOT like 'MANAGER' and JOB NOT like 'PRESIDENT';
--7
select ENAME,DEPTNO,HIREDATE from EMP
where HIREDATE like '%-83';
--8
select ENAME,SAL*12 ANUAL_SAL,COMM from EMP
where SAL > COMM and JOB like 'SALESMAN' --có SALEMAN VÀ SALESMAN
order by SAL desc,ENAME asc;