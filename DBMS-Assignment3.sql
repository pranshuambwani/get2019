# Assignment 3 Ques 2
use StoreFront;

create table product_category(product_id INT,category_id INT,
FOREIGN KEY(product_id) REFERENCES product(id),
FOREIGN KEY(category_id) REFERENCES category(id));

select * from product;
select * from category;
insert into product_category values(1,1),(1,3),(2,3),(3,1),(3,4),(5,2),(5,5),(6,2);

#Ques. Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.

select p.id, p.name, (SELECT COUNT(*) FROM product_category where product_id=p.id) AS COUNT
FROM product p group by p.id HAVING COUNT>1;

#Display Count of products as per price range
SELECT  '0 - 100' as 'Range in Rs.', COUNT(id) AS COUNT FROM product
WHERE price  BETWEEN 0 AND 100
UNION 
SELECT  '101 - 500' as 'Range in Rs', COUNT(id) AS COUNT FROM product
WHERE price  BETWEEN 101 AND 500
UNION 
SELECT  'ABOVE 500' as 'Range in Rs', COUNT(id) AS COUNT FROM product
WHERE price  >500;

#Display the Categories along with number of products under each category.
SELECT c.category_name, (SELECT COUNT(*) FROM product_category where 
category_id=c.id) AS Number_Of_Products 
FROM category c GROUP BY c.id;


# Assignment 3 Ques 3

#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.id, u.name, u.email_id, u.contact_number, COUNT(o.id)
FROM user u join orders o where o.user_id=u.id AND DATEDIFF(CURDATE(), date_of_order_placed)<=30
GROUP BY o.user_id;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.id, u.name, u.email_id, u.contact_number, SUM(o.amount) AS revenue from
user u join orders o where  o.user_id=u.id AND DATEDIFF(CURDATE(), o.date_of_order_placed) <=30
GROUP BY o.user_id ORDER BY revenue DESC LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.name, COUNT(p.id) AS Number_Of_Purchases 
FROM product p join item_list i join orders o 
where i.product_id=p.id AND o.id=i.order_number AND DATEDIFF(CURDATE(),o.date_of_order_placed)<=60 
GROUP BY i.product_id 
ORDER BY COUNT(p.id) DESC LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT DATE_FORMAT(o.date_of_order_placed,"%M-%Y") AS MONTH ,SUM(o.amount) AS MONTHLY_SALE
FROM orders o
WHERE DATEDIFF(now(),o.date_of_order_placed)<=180
GROUP BY DATE_FORMAT(o.date_of_order_placed,"%M-%Y")
ORDER BY o.date_of_order_placed DESC;

select * from product;
#Mark the products as Inactive which are not ordered in last 90 days
UPDATE product set product.active=0 where product.id NOT IN(
SELECT * from(
Select p.id from product p join orders o join item_list i
where p.id=i.product_id AND i.order_number=o.id AND DATEDIFF(CURDATE(), o.date_of_order_placed)<=90));

#Given a category search keyword, display all the Products present in this category/categories.
SELECT p.id, p.name, p.price 
from product p join product_category pc join category c
where p.id=pc.product_id AND c.id=pc.category_id AND c.category_name='shirt';

#Display top 10 Items which were cancelled most.
SELECT p.id, p.name, COUNT(p.id) AS Number_Of_cancellation
from product p join item_list i 
where p.id=i.product_id and i.status= 'Cancelled'
GROUP BY i.product_id
ORDER BY Count(p.id) DESC LIMIT 10;


# Assignment 3 Ques 4

create table state(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40));

create table city(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40),
state_id INT,
Foreign Key(state_id) REFERENCES State(Id));

create table zip_code(
id INT PRIMARY KEY AUTO_INCREMENT,
Code VARCHAR(10),
City_Id INT,
Foreign Key(City_id) REFERENCES City(Id));

select z.code, c.name, s.name
from zip_code z join city c join state s
where z.city_id=c.id AND c.state_id=s.id
order by s.name, c.name;

# Assignment 3 Ques 5

#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.
create view order_info AS
SELECT p.id, p.name AS title, p.price, u.name, u.email_id, o.date_of_order_placed, i.status
from product p join item_list i  join orders o join user u 
where p.id=i.product_id AND i.order_number=o.id AND o.user_id=u.id
AND DATEDIFF(CURDATE(), o.date_of_order_placed)<=60
ORDER BY o.date_of_order_placed DESC;

select * from order_info;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
select id, title from order_info where status='Shipped';

#Use the above view to display the top 5 most selling products.
select id, title, COUNT(id) AS Number_of_items_sold 
from order_info
group by id
order by COUNT(id) DESC LIMIT 5;