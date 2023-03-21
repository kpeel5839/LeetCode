# Write your MySQL query statement below
select q1.stock_name, q2.price - q1.price capital_gain_loss
from (select s1.stock_name, Sum(s1.price) price
      from stocks s1
      where s1.operation = 'Buy'
      group by s1.stock_name) q1 join 
      (select s2.stock_name, Sum(s2.price) price
      from stocks s2
      where s2.operation = 'Sell'
      group by s2.stock_name) q2 on q1.stock_name = q2.stock_name