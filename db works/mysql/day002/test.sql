show databases;

use jspdb;
show tables;

select * from department;
select * from employee;
select * from user;

-- 참조키가 부모 테이블에 없어서 추가 불가 오류 발생  
insert into employee values(103, '홍길동', 400, 30);

-- 해당 테이블의 참조키를 사용중인 자식 테이블이 있어어 삭제 불가 오류 발생
delete from department where depid = 10;