create sequence hibernate_sequence start 1 increment 1
create table user (id int8 not null, name varchar(255), password varchar(255), primary key (id))
