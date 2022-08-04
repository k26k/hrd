USE jspdb;

select * from user;

select * from user where uid = null;

delete from user where uid = null;


update user set name='추신수' where uid=123;
update user set name='남한강' where uid=158;

alter table user add phone varchar(20);

update user set phone='010-1234-5678' where uid=158;

