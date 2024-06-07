create table if not exists roles (
	name varchar(20) primary key not null,
	description varchar(100) not null
);

create table if not exists users (
	id varchar(255) primary key not null,
	name varchar(100) not null,
	lastname varchar(100) not null,
	nickname varchar(20) not null,
	email varchar(50) not null,
	password varchar(255) not null,
	role varchar(20) not null
);

create table if not exists posts (
	id varchar(255) primary key not null,
	photo text not null,
	registerDate date not null,
	name varchar(100) not null,
	age int not null,
	animalType varchar(30) NOT NULL,
	vaccinate boolean not null,
	race varchar(50),
	ppp boolean,
	city varchar (50),
	province varchar(50) not null,
	available boolean,
	likes int default 0,
	userId varchar(255) not null
);

create table if not exists comments (
	id varchar(255) primary key not null,
	bodyText text not null,
	likes int default 0,
	userId varchar(255) not null,
	postId varchar(255) not null
);

create table if not exists comments (
	id text primary key,
	bodyText text not null,
	likes int default 0,
	userId text not null,
	postId text not null
);
