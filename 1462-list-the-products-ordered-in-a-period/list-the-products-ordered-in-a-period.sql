# Write your MySQL query statement below
select product_name, sum(unit) as unit
from products p
join Orders o
on p.product_id = o.product_id
where o.order_date like '2020-02-%'
group by o.product_id
having unit >= 100;
