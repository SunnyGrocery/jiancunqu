create table user
(
    id          char(32),
    name        varchar(32),
    pwd         varchar(32),
    phone_num   varchar(32),
    real_id_num varchar(32),
    volume      int        default 100,
    available   tinyint(1) default 1,
    constraint user_table_pk
        primary key (id)
);

create unique index user_name_uindex
    on USER (name);

