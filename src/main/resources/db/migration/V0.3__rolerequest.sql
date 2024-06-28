create table if not exists roleendpoint (
	id varchar(255) primary key not null,
	role varchar(20) not null,
	endpoint varchar(100) not null,
	status boolean not null default true
);

