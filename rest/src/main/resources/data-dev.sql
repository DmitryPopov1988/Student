insert into users values (1,'qq', 'qq', 'ADMIN', true, 2);
insert into users values (2,'aa', 'aa', 'USER', true, 1);

insert into student values (1,'Bart', 'Simpson', 333, 'ASOI', 16, FILE_READ('/home/dmitry/IdeaProjects/hibernate/rest/src/main/resources/static/images/bart.png'));
insert into student values (2,'Homer', 'Simpson', 777, 'AI', 40, FILE_READ('/home/dmitry/IdeaProjects/hibernate/rest/src/main/resources/static/images/Homer_Simpson_Drink.png'));

insert into subject values (1,'Math');
insert into subject values (2,'Chemistry');
insert into subject values (3,'Computer Science');
insert into subject values (4,'Physics');

insert into subject_student values (1, 1);
insert into subject_student values (1, 3);
insert into subject_student values (2, 2);
insert into subject_student values (2, 4);
