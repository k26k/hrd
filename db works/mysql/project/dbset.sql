show databases;
use spring_board;
use spring_board_project;
show tables;
select * from board;
select * from board_category;
select * from comment;
select * from letter;
select * from post;
select * from user;

ALTER TABLE board RENAME COLUMN postnum to boardnum;
ALTER TABLE comment RENAME COLUMN postnum to boardnum;
ALTER TABLE comment RENAME COLUMN commnet_writer to id;

ALTER TABLE letter ADD COLUMN opendate datetime NOT NULL default CURRENT_TIMESTAMP;

insert into user values('test', 'test', '이정호', '실험용_계정', 1, 'aaa@bbb.com', '010-0000-0000' );
insert into board values( default , 'test_board', 'test_board' );
insert into post values( 1, default, 'test_post', 'test', '테스트용입니다.', default, 0 );

SELECT * FROM post WHERE boardnum = 1;

SELECT COUNT(*) FROM ( SELECT 1 FROM board WHERE category_num = 1 );
 SELECT 1 FROM board WHERE category_num = 1 ;