# Write your MySQL query statement below
select dd.name Department, eee.name Employee, eee.salary Salary
from (select Max(e.salary) salary, d.name department
      from employee e join department d on e.departmentId = d.id
      group by d.name) ee, employee eee join department dd on eee.departmentId = dd.id
where eee.salary = ee.salary and dd.name = ee.department;