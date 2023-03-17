# Write your MySQL query statement below
select distinct llll.a ConsecutiveNums
from (select l.num a, ll.num b, lll.num c
      from logs l join logs ll on l.id + 1 = ll.id join logs lll on ll.id + 1 = lll.id) llll
where llll.a = llll.b and llll.b = llll.c;