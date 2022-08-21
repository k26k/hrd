-- 관계 부서1 회원다
-- 부서(department)
-- 부서아이디(depid), 부서이름(depname), 부서위치(deplocation)
-- 직원(employee)
-- 직원아이디(empid), 직원이름(empname), 나이(age), 소속부서(depid)

create table department(
	depid		int primary key,
    depname		varchar(20) not null,
    deplocation	varchar(20) not null
);

create table employee(
	empid	int primary key,
    empname	varchar(30) not null,
    age		int,
    depid	int,
    constraint fk_dept_emp foreign key(depid) references department(depid)
);
-- constraint fk_dept_emp = 해당 참조키의 이름 참조키에 제약조건 걸때 필요
-- 참조키 뒤에 on delete cascade 추가시 부모테이블의 참조키가 삭제될때 해당 키를 참조중인 자식테이블의 데이터도 삭제됨

insert into department values(10, '개발팀', '서울');
insert into department values(20, '디자인팀', '인천');

select * from department;

insert into employee values(101, '한강', 27, 10);
insert into employee values(102, '백두산', 32, 20);

-- 부모테이블에 참조키가 없어서 추가 안됨
-- insert into employee values(103, '홍길동', 32, 30);

select * from employee;

-- 해당 키를 참조중인 자식테이블이 있어서 삭제 불가능
-- delete from department where depid = 10;
