CREATE TABLE IF NOT EXISTS users (
	username varchar(500) not null primary key,
	password varchar(500) not null,
	enabled boolean not null
);

CREATE TABLE IF NOT EXISTS authorities (
	username varchar(500) not null,
	authority varchar(500) not null
);