# Write your MySQL query statement below
select s1.id, CASE
       WHEN (s1.id % 2) = 1 and s1.id not in (select MAX(s4.id)
                                              from seat s4)
                          THEN (select s2.student
                                from seat s2
                                where s1.id + 1 = s2.id)
       WHEN (s1.id % 2) = 0 THEN (select s3.student
                                from seat s3
                                where s1.id - 1 = s3.id)
       ELSE s1.student END student
from seat s1