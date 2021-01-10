create table file
(
    file_name       varchar(32),
    file_size       varchar(32),
    ptime           date,
    name            varchar(32),
    url             varchar (1024),
    share           tinyint(1) default 0,
    constraint table_file_pk
        primary key (file_name)
);

create unique index file_ptime_uindex
    on file (ptime);


