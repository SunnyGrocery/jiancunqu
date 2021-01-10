create table file
(
    id              char(32),
    file_name       varchar(32),
    file_size       varchar(32),
    ptime           date,
    name            varchar(32),
    constraint table_file_pk
        primary key (id)
);

create unique index file_ptime_uindex
    on file (ptime);


