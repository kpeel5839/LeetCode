# Write your MySQL query statement below
select d.name Department, e.name Employee, e.salary Salary
from employee e join department d on e.departmentId = d.id
where e.salary in (select ee.salary
                   from (select distinct salary
                         from employee
                         where departmentId = d.id
                         order by salary desc LIMIT 3) ee)
