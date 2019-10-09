#1

select e.ename, e.job, e.sal, d.loc
from emp e join dept d using(deptno)
where d.loc="chicago";

#2
select emp, ename, job, deptno
from emp
where emp not in (select distinct mgr from emp where mgr is not null);

#3
select ename, job, mgr
from emp
where mgr = (select mgr from emp where ename="blake");

#4
select ename, hiredate
from emp
order by hiredate desc
limit 5;


#5
select e.ename, e.job, d.dname
from emp e join dept d using(deptno)
where mgr = (select emp from emp where ename="jones");
