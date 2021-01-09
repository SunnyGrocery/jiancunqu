create table admin
(
    id        char(32),
    name      varchar(32),
    pwd       varchar(32),
    available tinyint(1) default 1,
    constraint table_name_pk
        primary key (id)
);

create unique index admin_name_uindex
    on admin (name);


