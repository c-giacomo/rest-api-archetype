create sequence IF NOT EXISTS roles_seq start with 1 increment by 50;
create sequence IF NOT EXISTS users_seq start with 1 increment by 50;
create table IF NOT EXISTS roles (id bigint not null, description varchar(20) not null, primary key (id));
create table IF NOT EXISTS users (id bigint not null, name varchar(20) not null, surname varchar(20) not null, email varchar(30), username varchar(30) not null, primary key (id));
create table IF NOT EXISTS users_roles (roles_id bigint not null, users_id bigint not null);
alter table if exists users_roles add constraint roles_fk foreign key (roles_id) references roles;
alter table if exists users_roles add constraint users_fk foreign key (users_id) references users;
