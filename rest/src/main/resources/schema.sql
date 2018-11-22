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

