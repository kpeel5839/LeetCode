# Write your MySQL query statement below
select ssss.score score, sss.rownumber 'rank'
from (select @rownum := @rownum + 1 rownumber, ss.score
     from (select distinct s.score
          from scores s
          order by s.score desc) ss, (select @rownum := 0) rownum) sss join scores ssss on sss.score = ssss.score
order by ssss.score desc;
