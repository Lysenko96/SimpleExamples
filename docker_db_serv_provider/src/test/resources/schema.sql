create schema if not exists pos;
create table if not exists pos.t_articles_group
(
    id_shop           smallint default 0 not null,
    id_articles_group serial,
    id_parent_group   integer,
    name              varchar(128)       not null,
    sign_activity     boolean  default true,
    primary key (id_shop, id_articles_group)
);
create table if not exists pos.t_article
(
    id_shop            smallint default 0     not null,
    id_article         serial,
    id_articles_group  integer                not null,
    id_maker           integer                not null,
    id_department      integer                not null,
    name               varchar(256)           not null,
    sname              varchar(64)            not null,
    dtype              smallint default 0     not null,
    vat_group          varchar(2)             not null,
    sale_in_tara       boolean  default false not null,
    active             boolean  default true  not null,
    fiscal             boolean  default false not null,
    local              boolean  default true  not null,
    article            varchar(32)            not null,
    memo               varchar(256),
    printer            integer  default 0     not null,
    article_before_str varchar(256),
    article_after_str  varchar(256),
    uktzed             varchar(20),
    is_excise          integer  default 0     not null,
    primary key (id_shop, id_article),
    constraint t_article_id_articles_group_fkey
        foreign key (id_shop, id_articles_group) references pos.t_articles_group
            on update cascade on delete cascade
);
create table if not exists pos.t_measure
(
    id_shop            smallint default 0    not null,
    id_measure         serial,
    name               varchar(64)           not null,
    sname              varchar(16)           not null,
    active             boolean  default true not null,
    description        varchar(256),
    digits             smallint default 0    not null,
    enabled_divisional numeric(4, 3)[],
    primary key (id_shop, id_measure)
);
create table if not exists pos.t_barcode
(
    id_shop           smallint default 0 not null,
    id_barcode        serial,
    id_article        integer            not null,
    id_measure        integer            not null,
    barcode           varchar(30)        not null,
    sign_find_barcode smallint default 1 not null,
    price             numeric(9, 2)[]    not null,
    dtype             smallint,
    add_field         numeric(9, 2)[],
    primary key (id_shop, id_barcode),
    constraint t_barcode_id_article_fkey
        foreign key (id_shop, id_article) references pos.t_article
            on update cascade on delete cascade,
    constraint t_barcode_id_measure_fkey
        foreign key (id_shop, id_measure) references pos.t_measure
            on update cascade on delete cascade
);
create table if not exists pos.t_profile
(
    id_shop    smallint default 0 not null,
    id_profile serial,
    name       varchar(100)       not null,
    primary key (id_shop, id_profile)
);
create table if not exists pos.t_user
(
    id_shop    smallint default 0    not null,
    id_user    serial,
    id_profile integer               not null,
    login      varchar(30)           not null,
    pswd       varchar(128)          not null,
    dtype      smallint default 0    not null,
    active     boolean  default true not null,
    full_name  varchar(300)          not null,
    date_begin date,
    date_end   date,
    cardnumber varchar(32),
    primary key (id_shop, id_user),
    constraint t_user_id_profile_fkey
        foreign key (id_shop, id_profile) references pos.t_profile
            on update cascade on delete cascade
);
create table if not exists pos.t_event
(
    id_shop      smallint default 0    not null,
    id_event     serial,
    name         varchar(100)          not null,
    check_access boolean  default true not null,
    keep_audit   boolean  default true not null,
    primary key (id_shop, id_event)
);
create table if not exists pos.t_profile_events
(
    id_shop    smallint default 0 not null,
    id_profile integer            not null,
    id_event   integer            not null,
    primary key (id_shop, id_profile, id_event),
    constraint t_profile_events_id_event_fkey
        foreign key (id_shop, id_event) references pos.t_event
            on update cascade on delete cascade,
    constraint t_profile_events_id_profile_fkey
        foreign key (id_shop, id_profile) references pos.t_profile
            on update cascade on delete cascade
);
create table if not exists pos.t_cash_register_report
(
    id_shop                 smallint                 default 0     not null,
    id_cash_register_report serial,
    id_workplace            integer                                not null,
    id_user                 integer                                not null,
    report_time             timestamp with time zone               not null,
    report_sum              numeric(15, 2)                         not null,
    sum_ready_money         numeric(15, 2)           default 0     not null,
    sum_ready_credit        numeric(15, 2)           default 0     not null,
    date_change             timestamp with time zone default now() not null,
    number_cash_register    varchar(20)                            not null,
    number_report           integer                                not null,
    suma                    numeric(15, 2),
    sumb                    numeric(15, 2),
    sum                     numeric(9, 2)[],
    primary key (id_shop, id_cash_register_report, id_workplace)
);
create table if not exists pos.t_check
(
    id_shop                 smallint default 0             not null,
    id_workplace            integer                        not null,
    id_check                serial,
    id_user                 integer                        not null,
    id_cash_register_report integer                        not null,
    id_client               integer,
    date_operation          date     default (now())::date not null,
    time_open               timestamp with time zone       not null,
    time_close              timestamp with time zone       not null,
    zet_number              integer                        not null,
    check_number            integer                        not null,
    sum                     numeric(9, 2)                  not null,
    discount_sum            numeric(9, 2)                  not null,
    roundsum                numeric(10, 2),
    number_cash_register    varchar(20)                    not null,
    description             varchar(250),
    dtype                   smallint                       not null,
    type_vat                smallint                       not null,
    memo                    varchar,
    id_order                integer,
    primary key (id_shop, id_workplace, id_check)
);
create table if not exists pos.t_check_articles
(
    id_shop             smallint default 0       not null,
    id_workplace        integer                  not null,
    id_check            integer                  not null,
    pos                 integer                  not null,
    id_measure          integer                  not null,
    id_article          integer                  not null,
    id_barcode          integer                  not null,
    id_check_return     integer,
    id_workplace_return integer,
    id_discount         integer[],
    id_action_coupon    integer[],
    article             varchar(32)              not null,
    barcode             varchar(30),
    quantity            numeric(10, 3)           not null,
    quantity_ret        numeric(10, 3),
    clean_price         numeric(9, 2)            not null,
    price               numeric(9, 2)            not null,
    sum                 numeric(9, 2)            not null,
    sum_ret             numeric(9, 2)            not null,
    discount_sum        numeric(9, 2)            not null,
    vat                 numeric(5, 4)            not null,
    vat_group           varchar(1)               not null,
    type_article        smallint                 not null,
    dtype               smallint,
    time_add            timestamp with time zone not null,
    time_open           timestamp with time zone not null,
    uktzed              varchar(20),
    excise              varchar,
    primary key (id_shop, id_workplace, id_check, pos),
    constraint t_check_articles_id_workplace_id_check_fkey
        foreign key (id_shop, id_workplace, id_check) references pos.t_check
            on update cascade on delete cascade
);
create table if not exists pos.t_check_pay
(
    id_shop                smallint default 0 not null,
    id_workplace           integer            not null,
    id_check               integer            not null,
    pos                    integer            not null,
    id_currency            integer            not null,
    id_bank                integer,
    dtype                  smallint           not null,
    sum                    numeric(10, 2)     not null,
    sum_ret                numeric(10, 2),
    slip_number            varchar(30),
    receive_money          numeric(10, 2),
    description            varchar(250),
    rrn                    varchar(20),
    sum_national           numeric(10, 2),
    receive_money_national numeric(10, 2),
    primary key (id_shop, id_workplace, id_check, pos),
    constraint t_check_pay_id_workplace_id_check_fkey
        foreign key (id_shop, id_workplace, id_check) references pos.t_check
            on update cascade on delete cascade
);
create table if not exists pos.t_cash_operation
(
    id_shop              smallint                 default 0     not null,
    id_operation         serial,
    id_workplace         integer                                not null,
    id_user              integer                                not null,
    date_operation       timestamp with time zone default now() not null,
    dtype                smallint                               not null,
    sum                  numeric(15, 2)                         not null,
    number_cash_register varchar(20)                            not null,
    primary key (id_shop, id_operation, id_workplace)
);
create table if not exists pos.t_shift_work
(
    id_shop      smallint                 default 0     not null,
    id_shift     serial,
    id_workplace integer                                not null,
    id_user      integer                                not null,
    date_shift   timestamp with time zone default now() not null,
    type_action  char                                   not null,
    primary key (id_shop, id_shift, id_workplace)
);