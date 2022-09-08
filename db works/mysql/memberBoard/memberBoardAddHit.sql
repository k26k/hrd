show databases;
use javaweb;
show tables;
select * from t_board;
alter table t_board add hit int;
update t_board set hit = 0;
SET SQL_SAFE_UPDATES = 0;

use spring_board_project;