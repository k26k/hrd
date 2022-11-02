show databases;

use legacy_board;

show tables;

SELECT * FROM user;

SELECT * FROM comment;
SELECT * FROM board;
SELECT * FROM board_category;

SELECT * FROM emoticon;
SELECT * FROM emoticon 
		ORDER BY emoticon_num DESC;

desc board;
desc comment;

create table emoticon (
	emoticon_num int auto_increment primary key,
    image_url varchar(100)
);

SELECT date_format(b.writedate, '%y-%m-%d') as date, sum(b.hitcount) hit, count(b.boardnum) board
from board b
join (select date_format(c.writedate, '%y-%m-%d') as date, count(c.comment_num) comment from comment c group by date) as sc on date_format(b.writedate, '%y-%m-%d') = sc.date
group by date;

select date_format(c.writedate, '%y-%m-%d') as date, count(c.comment_num) comment from comment c group by date;



SELECT b.date, b.hit, b.board, c.comment
from (SELECT date_format(writedate, '%y-%m-%d') as date, sum(hitcount) hit, count(boardnum) board
	from board
	group by date) as b
join (select date_format(writedate, '%y-%m-%d') as date, count(comment_num) comment 
	from comment
    group by date) as c 
on b.date = c.date;


SELECT date_format(b.writedate, '%y-%m-%d') as date, sum(b.hitcount) hit, count(b.boardnum) board, c.comment
from board b
join (select date_format(writedate, '%y-%m-%d') as cdate, count(comment_num) comment 
	from comment
    group by date) as c 
on b.date = cdate
group by date;