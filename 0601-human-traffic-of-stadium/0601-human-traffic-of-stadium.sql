# Write your MySQL query statement below
select q4.id, q4.visit_date, q4.people
from stadium q4
where Exists (select s1.id
      from stadium s1 join stadium s2 on s1.id + 1 = s2.id join stadium s3 on s2.id + 1 = s3.id
      where q4.id = s1.id and 100 <= s1.people and 100 <= s2.people and 100 <= s3.people) or
      Exists (select s1.id
      from stadium s1 join stadium s2 on s1.id + 1 = s2.id join stadium s3 on s2.id + 1 = s3.id
      where q4.id = s2.id and 100 <= s1.people and 100 <= s2.people and 100 <= s3.people) or
      Exists (select s1.id
      from stadium s1 join stadium s2 on s1.id + 1 = s2.id join stadium s3 on s2.id + 1 = s3.id
      where q4.id = s3.id and 100 <= s1.people and 100 <= s2.people and 100 <= s3.people)
      