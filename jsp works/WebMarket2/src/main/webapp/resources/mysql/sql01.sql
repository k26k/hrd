show databases;

use jspdb;

show tables;


create table engineer(
	eid		int auto_increment,
	epasswd	varchar(20) not null,
	ename 	varchar(20) not null,
	primary key(eid)
);

insert into engineer values(default, 'Bill', 'm1234');
insert into engineer values(default, '이강', 'm2345');

select * from engineer;



create table product(
	p_id varchar(10) primary key,
	p_name varchar(20),
	p_unitPrice integer,
	p_description text,
	p_manufacturer varchar(20),
	p_category varchar(20),
	p_unitsInStock long,
	p_condition varchar(20),
	p_productImage varchar(20)
);

insert into product values (
	'P1234', 
	'iPhone 6s', 
	800000, 
	'4.7-inch 1334x750 Retina HD Display//8-MegaPixel iSight Camera', 
	'Smart Phome', 
	'Apple', 
	1000, 
	'new', 
	'P1234.png'
);

insert into product values (
	'P1235', 
	'LG PC 그램', 
	1500000, 
	'13.3-inch, IPS LED Display//5rd Generation Intel Core Processor', 
	'Notebook', 
	'LG', 
	1000, 
	'Refurbished', 
	'P1235.png'
);

insert into product values (
	'P1236', 
	'Galaxy Tab5', 
	600000, 
	'212.8*125.6*6.6mm//SuperAMOLED Display//Octa-Core Processor', 
	'Tablet', 
	'Samsung', 
	1000, 
	'Old', 
	'P1236.png'
);

select * from product;

delete from product where p_id = 'P1237';

commit;

rollback;

alter table product modify p_productImage varchar(100);

update product set product='P1222' where p_id = 'P1234';

update product set  = (	'P1221', 
	'Galaxy Tab5', 
	600000, 
	'212.8*125.6*6.6mm//SuperAMOLED Display//Octa-Core Processor', 
	'Tablet', 
	'Samsung', 
	1000, 
	'Old', 
	'P1236.png') where p_id = 'P1222';
	
delete from product WHERE p_id='P1237';


drop table member;

create table member(
	id			varchar(20) not null,
	password	varchar(20) not null,
	name		varchar(20) not null,
	gender		varchar(6),
	birth		varchar(20),
	mail		varchar(30),
	phone		varchar(20),
	address		varchar(50),
	regist_day	varchar(20),
	primary key(id)
);

insert into member values(
	'qwer',
	'1234',
	'김아무개',
	'남',
	'1995-01-01',
	'asdf@zxcv.com',
	'010-1234-5678',
	'대충 한국 어디',
	'2022-08-17'
);

delete from member;
delete from member where id = '';

select * from member;

select * from member where id='1234';


drop table board;

create table board(
	num			int primary key auto_increment,
	name		varchar(20) not null,
	subject		varchar(100) not null,
	content		text not null,
	write_date	varchar(30),
	hit			int,
	recommend	int,
	id			varchar(20) not null,
	constraint fk_member_board foreign key(id)
	references member(id) on delete cascade
);

select * from board;

insert into board values(default, 'admin', 'test', '~~~', '2022-08-18', 0, 0, 'qwer');

delete from board WHERE num=3;

show databases;
use jspdb;
use mysql;
show tables;

