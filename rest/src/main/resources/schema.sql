DROP TABLE IF EXISTS  users;
DROP TABLE IF EXISTS  authorities;
DROP TABLE IF EXISTS  student;
DROP TABLE IF EXISTS  subject;

CREATE TABLE IF NOT EXISTS users (
  id BIGINT not null PRIMARY KEY,
	username varchar(500) not null,
	password varchar(500) not null,
	authority varchar(500) not null,
	enabled boolean not null
);

CREATE TABLE IF NOT EXISTS student (
  student_id BIGINT not null PRIMARY KEY,
	name varchar(500) not null,
	age BIGINT not null
);

CREATE TABLE IF NOT EXISTS subject (
  id BIGINT not null PRIMARY KEY,
	name_subject varchar(500) not null,
	student_id BIGINT
);



