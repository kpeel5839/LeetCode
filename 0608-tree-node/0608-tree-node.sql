# Write your MySQL query statement below
# 본인을 가르키지 않는 애들
select id, CASE
            WHEN (p_id is null) THEN 'Root'
            WHEN Exists (select id
                         from tree t2
                         where t1.id = t2.p_id) THEN 'Inner'
            ELSE 'Leaf' END type
from tree t1
