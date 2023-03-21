# Write your MySQL query statement below
select u1.user_id buyer_id, u1.join_date, IFNULL((select count(o.buyer_id)
                                  from users u join orders o on u.user_id = o.buyer_id
                                  where u1.user_id = o.buyer_id and '2019-01-01' <= o.order_date
                                  group by o.buyer_id), 0) orders_in_2019
from users u1