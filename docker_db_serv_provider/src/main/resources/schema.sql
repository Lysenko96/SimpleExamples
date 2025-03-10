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
create table if not exists pos.t_ban_article
(
    id_workplace integer            not null,
    id_param     integer            not null,
    dtype        smallint default 0 not null,
    id_shop      smallint           not null,
    action       varchar,
    constraint pk_dep_workplace
        primary key (id_workplace, id_param, id_shop)
);
-- create schema if not exists loyalty;
-- create sequence if not exists sertificates_id_seq;
-- create table if not exists loyalty.sertificates
-- (
--     id              bigint         default nextval('loyalty.sertificates_id_seq'::regclass) not null
--         primary key,
--     barcode         varchar(255)                                                            not null,
--     nominal_sum     numeric(10, 2) default 0.00                                             not null,
--     prepay_sum      numeric(10, 2) default 0.00                                             not null,
--     discount_sum    numeric(10, 2) default 0.00                                             not null,
--     status          integer        default 0                                                not null,
--     date_creation   timestamp      default now()                                            not null,
--     date_activation timestamp,
--     date_expiration timestamp,
--     edrpou          varchar(255),
--     memo            varchar(255),
--     tradepoint_id   bigint,
--     cashbox_id      bigint,
--     bill_number     bigint,
--     position        bigint
-- );
create table if not exists pos.t_client
(
    id_shop     smallint      default 0    not null,
    id_client   serial,
    id_discount integer[],
    full_name   varchar(70)                not null,
    active      boolean       default true not null,
    discount    numeric(6, 4) default 0    not null,
    sum         numeric(9, 2)[],
    dtype       smallint                   not null,
    description varchar(500),
    date_begin  date,
    date_end    date,
    time_begin  time with time zone,
    time_end    time with time zone,
    date_birth  date,
    date_reg    date                       not null,
    day_week    smallint                   not null,
    cardnumber  varchar(30)[],
    primary key (id_shop, id_client)
);
create table if not exists pos.t_currency
(
    id_shop     smallint       not null,
    id_currency smallint       not null,
    name        varchar(32)    not null,
    sname       varchar(16)    not null,
    symbol      varchar(16)    not null,
    exchange    numeric(12, 4) not null,
    digits      smallint       not null,
    isbase      boolean        not null,
    isnational  boolean        not null,
    primary key (id_currency, id_shop)
);
create table if not exists pos.t_discount
(
    id_shop            smallint default 0 not null,
    id_discount        serial,
    id_parent_discount integer,
    date_begin         date,
    date_end           date,
    time_begin         time with time zone,
    time_end           time with time zone,
    description        varchar(500),
    name               varchar(128)       not null,
    dtype              smallint,
    primary key (id_shop, id_discount)
);
create table if not exists pos.t_discount_item
(
    id_shop          smallint      default 0 not null,
    id_discount_item serial,
    id_discount      integer                 not null,
    id_item          integer                 not null,
    id_value         integer                 not null,
    dtype            smallint                not null,
    quantity         numeric(12, 6)          not null,
    price            numeric(9, 2) default 0 not null,
    memo             varchar(200),
    primary key (id_shop, id_discount_item),
    constraint t_discount_item_id_discount_fkey
        foreign key (id_shop, id_discount) references pos.t_discount
            on update cascade on delete cascade
);
create table if not exists pos.t_invoice_articles
(
    id_shop      smallint default 0 not null,
    invoice_guid uuid               not null,
    article      varchar(32),
    quantity     numeric(10, 3),
    measure      varchar(32)
);
create table if not exists pos.t_invoice
(
    id_shop  smallint default 0 not null,
    guid     uuid               not null
        primary key,
    date     date,
    number   integer,
    comments text
);
create table if not exists pos.t_variable
(
    id_shop smallint default 0 not null,
    vgroup  smallint           not null,
    name    varchar(32)        not null,
    value   varchar(128)       not null,
    primary key (id_shop, vgroup, name)
);
create table if not exists pos.t_audit_action
(
    id_shop         smallint  default 0        not null,
    id_audit_action serial,
    id_event        integer                    not null,
    id_workplace    integer                    not null,
    id_user         integer                    not null,
    id_article      integer,
    id_measure      integer,
    id_client       integer,
    fragment_number integer                    not null,
    check_number    integer,
    quantity        numeric(16, 3),
    price_sale      numeric(15, 8),
    date_event      timestamp default now()    not null,
    status_transfer smallint  default 0        not null,
    input_data      varchar(30),
    exported        smallint  default 0        not null,
    memo            text      default ''::text not null,
    primary key (id_shop, id_workplace, id_audit_action)
);
create table if not exists pos.t_paydiscount
(
    id_paydiscount serial,
    id_kassa       smallint      not null,
    dtype          integer       not null,
    check_number   integer       not null,
    check_pos      integer,
    summa          numeric(9, 2) not null,
    percent        numeric(9, 2) not null,
    id_shop        integer       not null,
    primary key (id_paydiscount, id_kassa, id_shop)
);