CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select salary getNthHighestSalary
      from (select e.salary, @rownum := @rownum + 1 rownumber
            from (select DISTINCT eee.salary
                  from employee eee) e,
            (select @rownum := 0) rownum
            order by salary desc) ee
      where ee.rownumber = N
  );
END