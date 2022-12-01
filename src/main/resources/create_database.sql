
create database kudos;

create table kudos
(
    id                  SERIAL  primary key,
    subject             varchar(256)  not null,
    date                date          not null,
    recipientEmployeeId varchar(50)   not null,
    text                varchar(1000) not null,
    sourceEmployeeId    varchar(50)   not null
);
