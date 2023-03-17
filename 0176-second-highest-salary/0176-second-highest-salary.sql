# Write your MySQL query statement below
select Max(e.salary) secondHighestSalary
from employee e left join (select Max(r.salary) salary
                 from employee r) f on e.salary = f.salary
where f.salary is NULL;