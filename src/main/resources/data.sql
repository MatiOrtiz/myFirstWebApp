create table ToDo(
                     id int not null,
                     username varchar(255) not null,
                     description varchar(255) not null,
                     target_Date DATETIME not null,
                     done boolean not null,
                     primary key(id)
);

insert into ToDo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10001,'admin', 'Learn Spring Framework', CURRENT_DATE(), false);

insert into ToDo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10002,'admin', 'Learn MySQL', CURRENT_DATE(), false);

insert into ToDo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10003,'admin', 'Learn Spring Boot', CURRENT_DATE(), false);
