show databases;
use spring_board_project;

create table user (
    id varchar(20) primary key ,
    password varchar(20) not null ,
    name varchar(20) not null ,
    nickname varchar(20) not null ,
    grade varchar(3) not null  default '1',
    email varchar(50) not null ,
    phone varchar(20)

);



create table user_auth(
    auth varchar(50) not null ,
    userid varchar(20) not null ,
    foreign key (userid) references user(id)
);


create table board_category(
    category_num int primary key auto_increment,
    category_name varchar(20) not null

);


create table board(
    category_num int not null ,
    boardnum int primary key auto_increment,
    title varchar(50) not null,
    writer varchar(20) not null ,
    content text not null ,
    writedate datetime default CURRENT_TIMESTAMP,
    hitcount int not null default 0,
    foreign key (writer) references user(id),
    foreign key (category_num) references board_category(category_num)

);

		

create table comment (
    comment_num int primary key auto_increment,
    boardnum int not null ,
    contents varchar(200) not null ,
    writedate datetime default CURRENT_TIMESTAMP,
    id varchar(20) not null,
    foreign key (id) references user(id),
    foreign key (boardnum) references board(boardnum)

);


create table letter (

    sender varchar(20) not null ,
    reciver varchar(20) not null ,
    title varchar(50) not null ,
    contents varchar(500) not null ,
    writedate datetime default CURRENT_TIMESTAMP,
    foreign key (reciver) references user(id)


);

insert into user(id, password, name, nickname, grade, email, phone)
values('test','test','test_user','테스트 유저','1','aaa@bbb.com','010-0000-0000');


delete from board_category where category_num =1 ;

insert into board_category(category_num, category_name)
values(1,'test_category1');   

insert into board_category(category_num, category_name)
values(2,'test_category2');  
 
insert into board_category(category_num, category_name)
values(3,'test_category3');  
 
insert into board_category(category_num, category_name)
values(4,'test_category4');   

insert into board_category(category_num, category_name)
values(5,'test_category5');   


insert into board(category_num, title, writer, content)
values(1, 'test_board1', 'test', 'test_content1');   

insert into board(category_num, title, writer, content)
values(2, 'test_board2', 'test', 'test_content2'); 

insert into board(category_num, title, writer, content)
values(3, 'test_board3', 'test', 'test_content3'); 
