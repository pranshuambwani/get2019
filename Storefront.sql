create database StoreFront;

use StoreFront;

#Assignment 1 and Assignment 2

create table User(
Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(40),
Email_Id VARCHAR(30),
Password VARCHAR(20),
Contact_Number BIGINT);

create table category(
Id INT UNIQUE NOT NULL AUTO_INCREMENT,
Category_Name VARCHAR(30) PRIMARY KEY,
Parent_Id INT,
Parent_Category VARCHAR(30),
FOREIGN KEY(Parent_Id) REFERENCES category(Id));

create table product(
Id INT PRIMARY KEY AUTO_INCREMENT,
Price INT,
Name VARCHAR(30),
Category_Id INT,
FOREIGN KEY(Category_Id) REFERENCES category(Id));

create table image(
Id INT PRIMARY KEY AUTO_INCREMENT,
Product_id INT,
Image BLOB,
FOREIGN KEY(Product_id) REFERENCES product(Id));

create table address(
Id INT PRIMARY KEY AUTO_INCREMENT,
User_id INT,
Zip_code VARCHAR(7),
FOREIGN KEY(User_id) REFERENCES User(Id));

alter table address drop Zip_code;
alter table address add column shipping_address varchar(30);

create table orders(
Id INT PRIMARY KEY AUTO_INCREMENT,
Date_of_order_placed DATE,
Amount INT,
Shipping_Address INT,
User_Id INT);

create table Item_List(
Id INT PRIMARY KEY AUTO_INCREMENT,
Product_Id INT,
Order_Number INT,
Status VARCHAR(10) CHECK (Status IN('Shipped', 'Cancelled', 'Returned')));

create table Stock(Product_id INT,
Quantity INT,
FOREIGN KEY(Product_id) REFERENCES product(Id));

show tables;


create table Role(User_id INT, 
role_type varchar(10)  CHECK (Status IN('Shopper', 'Administrator')),
FOREIGN KEY(User_id) REFERENCES User(Id));

desc User;

insert into user(name, email_id, password, contact_number) values
('Abhishek', 'admin@gmail.com', 'admin123', 1234567890),
('Nishant', 'nishant@gmail.com', 'nishant123', 6767689739),
('Shubham', 'shubham@gmail.com', 'shubham123', 6356276377);

select * from user;

alter table Role drop role_type;
alter table Role add column role_type varchar(15) CHECK (Status IN('Shopper','Administrator'));

insert into role values(1,'Administrator'),(2,'Shopper'),(3,'Shopper');

desc category;
alter table category drop parent_category;

alter table category add column category_desc varchar(30);

desc category;

insert into category(category_name,parent_id) values
('clothes',NULL),
('electronics',NULL);

insert into category(category_name,parent_id,category_desc) values
('shirt',1,'shirt is in clothes'),
('trouser',1,'trouser is in clothes'),
('refrigerator',2,'electronics item'),
('mobile phone',2,'electronics iten');

select * from category;

update category set category_desc='Top Category' where parent_id  is NULL;

desc product;

insert into product(price,name,category_id) values
(1000,'shirt1',3),
(1200,'shirt2',3),
(2000,'trouser1',4),
(2500,'trouser2',4),
(18000,'refrigerator1',5),
(20000,'refrigerator2',5),
(30000,'mobile1',6),
(20800,'mobile2',6);

select * from product;

desc image;

insert into image(product_id,image) values
(1,'C:\Users\User21\Downloads\shirt1.jpg'),
(3,'C:\Users\User21\Downloads\trouser1.jpg'),
(5,'C:\Users\User21\Downloads\refrigerator1.jpg'),
(6,'C:\Users\User21\Downloads\refrigerator2.jpg'),
(7,'C:\Users\User21\Downloads\mobile1.jpg');

select * from image;

show tables;

desc address;

insert into address(user_id,shipping_address) values(2,'Jodhpur'),(2,'Jaipur'),(3,'Jaisalmer');

select * from address;

desc product;

alter table product add column active INT CHECK (active IN (1,0));

alter table product add column created_time timestamp;

select * from product;
select * from category;
select * from image;


update product set active = 1 where id=7;
update product set active = 0 where id=8;
update product set  created_time = '2019-08-01 04:00:00' where id=8;

select * from category;
select * from product;
select * from stock;
select * from item_list;
select * from orders;
select * from user;
select * from role;
insert into stock values(1,34),(2,55),(3,67),(4,32);
show tables;
desc item_list;

insert into item_list (product_id, order_number, status) values
(4, 1, 'Cancelled'),
(5, 1, 'Shipped');

#Assignment 2 queries

select p.id,p.name,c.category_name,p.price from product p INNER JOIN category c ON p.category_id = c.id where p.active=1  order by p.created_time desc;
 
select * from product p where id NOT IN(select Distinct product_id from image);

select c.id,c.category_name,IFNULL(p.category_name,'Top category') as Parent from category c left join category p on c.parent_id = p.id order by p.category_name asc;

select c.id,c.category_name,p.category_name as Parent from category c left join category p on c.parent_id = p.id where c.id NOT IN(select DISTINCT parent_id from category);

select id,name,price from product where category_id = (select id from category where category_name = 'mobile phone');

select id,name,price from product where id IN(select product_id from stock where quantity<50);


#Assignment 3 queries

select * from orders ORDER BY date_of_order_placed LIMIT 50;

select * from orders ORDER BY amount LIMIT 10;

insert into orders values(1,'2019-08-02',2500,1,1);
insert into orders values(2,'2019-07-25',1600,2,2);
insert into orders values(3,'2019-08-06',1900,3,3);

SELECT DAY(date_of_order_placed)  from orders where id=2;

SELECT o.id, o.date_of_order_placed, o.user_id, o.amount from orders AS o, item_list AS i where DATEDIFF(CURDATE(), o.date_of_order_placed) > 10 AND 
o.id=i.order_number AND i.status!='Shipped';

select u.name from user u,role r where u.id=r.user_id and u.id NOT In(select user_id from orders where date_of_order_placed > CURDATE()-30);

SELECT  u.id, u.name, o.amount, o.date_of_order_placed, o.id
 from user as u, orders as o 
where u.id=o.user_id AND DATEDIFF(CURDATE(), o.date_of_order_placed) <=15;

select i.id,i.order_number,i.status,o.date_of_order_placed
from item_list i,orders o where o.id=i.order_number and i.status='Shipped'; 

SELECT p.name, p.price, o.date_of_order_placed
from orders as o, product as p, item_list as i
where i.order_number=o.id AND i.product_id=p.id AND p.price BETWEEN 20 AND 50;