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
	role varchar(20) not null,
	foreign key (role) references roles(name)
);

create table if not exists posts (
	id varchar(255) primary key not null,
	photo text not null,
	registerDate date not null,
	name varchar(100) not null,
	age int not null,
	animalType varchar(30) NOT NULL,
	vaccinated boolean not null,
	breed varchar(50),
	ppp boolean,
	city varchar (50),
	province varchar(50) not null,
	available boolean,
	likes int default 0,
	userId varchar(255) not null,
	foreign key (userId) references users(id)
);

create table if not exists messages (
	id varchar(255) primary key not null,
	bodyText text not null,
	sentDate timestamp default current_timestamp not null,
    senderId varchar(255) not null,
    receiverId varchar(255) not null,
    postId varchar(255) not null,
    foreign key (senderId) references users(id),
    foreign key (receiverId) references users(id),
    foreign key (postId) references posts(id)
);

create table if not exists protectors (
    id VARCHAR(255) primary key not null,
    name VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    phone VARCHAR(13) NOT NULL,
    email VARCHAR(50) NOT NULL
);


