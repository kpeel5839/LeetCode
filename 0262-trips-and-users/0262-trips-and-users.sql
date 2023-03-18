# Write your MySQL query statement below
select t1.request_at Day, round(IFNULL(t2.cc, 0) / IFNULL(t1.cc, 0), 2) 'Cancellation Rate'
from (select t.request_at, count(id) cc
      from trips t
      where (select u.banned
            from users u
            where t.client_id = u.users_id) = 'No' and
            (select u.banned
            from users u
            where t.driver_id = u.users_id) = 'No'
      group by t.request_at) t1 left join
      (select request_at, count(id) cc
      from trips t
      where status like 'cancelled_by_%' and 
            (select u.banned
            from users u
            where t.client_id = u.users_id) = 'No' and
            (select u.banned
            from users u
            where t.driver_id = u.users_id) = 'No'
      group by request_at) t2 on t1.request_at = t2.request_at
where t1.request_At BETWEEN '2013-10-01' and '2013-10-03'
