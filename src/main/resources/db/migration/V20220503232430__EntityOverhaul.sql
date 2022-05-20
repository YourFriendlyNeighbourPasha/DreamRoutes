drop table licenses_categories;
drop table driver_license_category;
drop table driver_license;
drop table salary;
drop table internal_accident;
drop table internal_shipping_task_report;
drop table internal_shipping_task;
drop table external_accident;
drop table external_shipping_task_report;
drop table external_shipping_task;
drop table route;
drop table freight;
drop table vehicle;
drop table driver;

alter table country
    alter column code type varchar(3),
    alter column name type varchar(56);

alter table region
    alter column name type varchar(150);

alter table city
    alter column name type varchar(85);

create table route
(
    id             uuid    not null
        constraint route_pkey
            primary key,
    distance       real    not null,
    estimated_time bigint  not null,
    title          varchar(50),
    type           integer,
    first_city_id  integer not null references city,
    second_city_id integer not null references city,
    created_by     varchar(45),
    created_at     timestamp,
    modified_by    varchar(45),
    modified_at    timestamp
);

create table freight
(
    id          uuid             not null
        constraint freight_pkey
            primary key,
    description varchar(300),
    type        integer,
    weight      double precision not null,
    created_by  varchar(45),
    created_at  timestamp,
    modified_by varchar(45),
    modified_at timestamp
);

create table vehicle
(
    id                 uuid             not null
        constraint vehicle_pkey
            primary key,
    manufacturer_title varchar(50),
    model              varchar(20),
    vehicle_code       varchar(25),
    weight_capacity    double precision not null,
    created_by         varchar(45),
    created_at         timestamp,
    modified_by        varchar(45),
    modified_at        timestamp
);

create table driver_license_category
(
    id   serial not null
        constraint driver_license_category_pkey
            primary key,
    code varchar(10)
);

create table driver
(
    id          uuid not null
        constraint driver_pkey
            primary key,
    birthday    date,
    employed_on date,
    first_name  varchar(75),
    last_name   varchar(75),
    middle_name varchar(75),
    created_by  varchar(45),
    created_at  timestamp,
    modified_by varchar(45),
    modified_at timestamp
);

create table driver_license
(
    id                uuid    not null
        constraint driver_license_pkey
            primary key,
    driver_id         uuid    not null references driver,
    expiration_date   date,
    issued_at         date,
    issuing_authority integer not null,
    number            bigint  not null,
    created_by        varchar(45),
    created_at        timestamp,
    modified_by       varchar(45),
    modified_at       timestamp
);

create table licenses_categories
(
    driver_license_id          uuid    not null references driver_license,
    driver_license_category_id integer not null references driver_license_category
);

create table salary
(
    id          uuid not null
        constraint salary_pkey
            primary key,
    bonus_cost  numeric(19, 2),
    cost        numeric(19, 2),
    driver_id   uuid not null references driver,
    created_by  varchar(45),
    created_at  timestamp,
    modified_by varchar(45),
    modified_at timestamp
);

create table internal_shipping_task
(
    id             uuid not null
        constraint internal_shipping_task_pkey
            primary key,
    departure_time timestamp,
    driver_id      uuid not null references driver,
    freight_id     uuid not null references freight,
    route_id       uuid not null references route,
    vehicle_id     uuid not null references vehicle,
    created_by     varchar(45),
    created_at     timestamp,
    modified_by    varchar(45),
    modified_at    timestamp
);

create table internal_shipping_task_report
(
    id                        uuid not null
        constraint internal_shipping_task_report_pkey
            primary key,
    destination_time          timestamp,
    internal_shipping_task_id uuid not null references internal_shipping_task,
    created_by                varchar(45),
    created_at                timestamp,
    modified_by               varchar(45),
    modified_at               timestamp
);

create table internal_accident
(
    id                    uuid not null
        constraint internal_accident_pkey
            primary key,
    description           varchar(300),
    happened_at           timestamp,
    internal_ship_task_id uuid not null references internal_shipping_task_report,
    created_by            varchar(45),
    created_at            timestamp,
    modified_by           varchar(45),
    modified_at           timestamp
);

create table external_shipping_task
(
    id              uuid not null
        constraint external_shipping_task_pkey
            primary key,
    departure_time  timestamp,
    driver_id       uuid not null references driver,
    extra_driver_id uuid not null references driver,
    freight_id      uuid not null references freight,
    route_id        uuid not null references route,
    vehicle_id      uuid not null references vehicle,
    created_by      varchar(45),
    created_at      timestamp,
    modified_by     varchar(45),
    modified_at     timestamp
);

create table external_shipping_task_report
(
    id                        uuid not null
        constraint external_shipping_task_report_pkey
            primary key,
    destination_time          timestamp,
    external_shipping_task_id uuid not null references external_shipping_task,
    created_by                varchar(45),
    created_at                timestamp,
    modified_by               varchar(45),
    modified_at               timestamp
);

create table external_accident
(
    id                    uuid not null
        constraint external_accident_pkey
            primary key,
    description           varchar(255),
    happened_at           timestamp,
    external_ship_task_id uuid not null references external_shipping_task_report,
    created_by            varchar(45),
    created_at            timestamp,
    modified_by           varchar(45),
    modified_at           timestamp
);

alter table route
    owner to postgres;
alter table freight
    owner to postgres;
alter table vehicle
    owner to postgres;
alter table driver
    owner to postgres;
alter table driver_license_category
    owner to postgres;
alter table driver_license
    owner to postgres;
alter table licenses_categories
    owner to postgres;
alter table salary
    owner to postgres;
alter table internal_shipping_task
    owner to postgres;
alter table internal_shipping_task_report
    owner to postgres;
alter table internal_accident
    owner to postgres;
alter table external_shipping_task
    owner to postgres;
alter table external_shipping_task_report
    owner to postgres;
alter table external_accident
    owner to postgres;