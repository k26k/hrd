create user jweb@localhost identified by '54321';

create database javaweb;

grant all privileges on javaweb.* to jweb@localhost with grant option;


create user spring_board_project@localhost identified by '12345';

create database spring_board_project;

grant all privileges on spring_board_project.* to spring_board_project@localhost with grant option;


create user springbootuser@localhost identified by 'springboot';

create database springbootweb;

grant all privileges on springbootweb.* to springbootuser@localhost with grant option;


create user spring_boot_shopping_user@localhost identified by 'spring_boot_shopping_user';

create database spring_boot_shopping_db;

grant all privileges on spring_boot_shopping_db.* to spring_boot_shopping_user@localhost with grant option;