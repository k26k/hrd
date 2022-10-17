create user jweb@localhost identified by '54321';

create database javaweb;

grant all privileges on javaweb.* to jweb@localhost with grant option;

create user spring_board_project@localhost identified by '12345';

create database spring_board_project;

grant all privileges on spring_board_project.* to spring_board_project@localhost with grant option;

create user boot@localhost identified by 'boot';

create database bootweb;

grant all privileges on bootweb.* to boot@localhost with grant option;
