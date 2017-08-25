drop schema if exists estore;
create database estore;
use estore;

CREATE TABLE user(
id int(11) NOT NULL auto_increment,
username varchar(50),
password varchar(100),
first_name varchar(50),
last_name varchar(50),
email varchar(100),
phone long,
adress varchar(100),
card_number int,
enabled tinyint(1) DEFAULT NULL,
last_password_reset_date date DEFAULT NULL,
PRIMARY KEY (id));

CREATE TABLE authority (
id int(11) NOT NULL,
name varchar(20) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE user_authority (
id int(11) NOT NULL auto_increment,
user_id int(11) NOT NULL,
authority_id int(11) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (authority_id) REFERENCES authority(id));

CREATE table brand(
id int not null auto_increment,
brand_name varchar(100) unique,
description varchar(500),
photo_path varchar(255),
PRIMARY KEY (id));


CREATE TABLE orders(
id int not null auto_increment,
price float not null,
payment_method varchar(100),
shipping_method varchar(100),
order_status varchar(100),
user_id int,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user(id));

CREATE TABLE section (
id int not null auto_increment,
section_name varchar(100) unique,
PRIMARY KEY (id));

CREATE TABLE product
(id int not null auto_increment,
product_name varchar(500),
details varchar(500),
price float not null,
photo_path varchar(255),
section_id int,
brand_id int,
PRIMARY KEY (id),
FOREIGN KEY (section_id) REFERENCES section(id),
FOREIGN KEY (brand_id) REFERENCES brand(id));

CREATE TABLE order_product
(id int not NULL auto_increment,
product_id int,
order_id int,
PRIMARY KEY (id),
FOREIGN KEY (product_id) REFERENCES product(id),
FOREIGN KEY (order_id) REFERENCES orders(id));

CREATE TABLE campaign (
id int not null auto_increment,
details varchar(200),
period varchar(100),
discount int not null,
PRIMARY KEY (id));

CREATE TABLE product_campaign(
id int not null auto_increment,
product_id int,
campaign_id int,
PRIMARY KEY (id),
FOREIGN KEY (product_id) REFERENCES product(id),
FOREIGN KEY (campaign_id) REFERENCES campaign(id));