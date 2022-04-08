create table country
(
    id   serial not null
        constraint country_pkey
            primary key,
    code varchar(255),
    name varchar(255)
);

create table region
(
    id         serial  not null
        constraint region_pkey
            primary key,
    name       varchar(255),
    country_id integer not null
        references country
);

create table city
(
    id        serial  not null
        constraint city_pkey
            primary key,
    name      varchar(255),
    region_id integer not null
        references region
);

create table route
(
    id             uuid    not null
        constraint route_pkey
            primary key,
    created_at     timestamp,
    modified_at    timestamp,
    distance       real    not null,
    estimated_time bigint  not null,
    title          varchar(255),
    type           integer,
    first_city_id  integer not null
        references city,
    second_city_id integer not null
        references city
);

create table freight
(
    id          uuid             not null
        constraint freight_pkey
            primary key,
    created_at  timestamp,
    modified_at timestamp,
    description varchar(255),
    type        integer,
    weight      double precision not null
);

create table vehicle
(
    id                 uuid             not null
        constraint vehicle_pkey
            primary key,
    created_at         timestamp,
    modified_at        timestamp,
    manufacturer_title varchar(255),
    model              varchar(255),
    vehicle_code       varchar(255),
    weight_capacity    double precision not null
);

create table driver_license_category
(
    id   serial not null
        constraint driver_license_category_pkey
            primary key,
    code varchar(255)
);

create table driver
(
    id          uuid not null
        constraint driver_pkey
            primary key,
    created_at  timestamp,
    modified_at timestamp,
    birthday    date,
    employed_on date,
    first_name  varchar(255),
    last_name   varchar(255),
    middle_name varchar(255)
);

create table driver_license
(
    id                uuid    not null
        constraint driver_license_pkey
            primary key,
    driver_id         uuid    not null
        references driver,
    created_at        timestamp,
    modified_at       timestamp,
    expiration_date   date,
    issued_at         date,
    issuing_authority integer not null,
    number            bigint  not null
);

create table licenses_categories
(
    driver_license_id          uuid    not null
        references driver_license,
    driver_license_category_id integer not null
        references driver_license_category
);

create table salary
(
    id          uuid not null
        constraint salary_pkey
            primary key,
    created_at  timestamp,
    modified_at timestamp,
    bonus_cost  numeric(19, 2),
    cost        numeric(19, 2),
    driver_id   uuid not null
        references driver
);

create table internal_shipping_task
(
    id             uuid not null
        constraint internal_shipping_task_pkey
            primary key,
    created_at     timestamp,
    modified_at    timestamp,
    departure_time timestamp,
    driver_id      uuid not null
        references driver,
    freight_id     uuid not null
        references freight,
    route_id       uuid not null
        references route,
    vehicle_id     uuid not null
        references vehicle
);

create table internal_shipping_task_report
(
    id                        uuid not null
        constraint internal_shipping_task_report_pkey
            primary key,
    created_at                timestamp,
    modified_at               timestamp,
    destination_time          timestamp,
    internal_shipping_task_id uuid not null
        references internal_shipping_task
);

create table internal_accident
(
    id                    uuid not null
        constraint internal_accident_pkey
            primary key,
    created_at            timestamp,
    modified_at           timestamp,
    description           varchar(255),
    happened_at           timestamp,
    internal_ship_task_id uuid not null
        constraint fkrqqucgttbm2ubd7lg3mpcxn53
            references internal_shipping_task_report
);

create table external_shipping_task
(
    id              uuid not null
        constraint external_shipping_task_pkey
            primary key,
    created_at      timestamp,
    modified_at     timestamp,
    departure_time  timestamp,
    driver_id       uuid not null
        references driver,
    extra_driver_id uuid not null
        references driver,
    freight_id      uuid not null
        references freight,
    route_id        uuid not null
        references route,
    vehicle_id      uuid not null
        references vehicle
);

create table external_shipping_task_report
(
    id                        uuid not null
        constraint external_shipping_task_report_pkey
            primary key,
    created_at                timestamp,
    modified_at               timestamp,
    destination_time          timestamp,
    external_shipping_task_id uuid not null
        references external_shipping_task
);

create table external_accident
(
    id                    uuid not null
        constraint external_accident_pkey
            primary key,
    created_at            timestamp,
    modified_at           timestamp,
    description           varchar(255),
    happened_at           timestamp,
    external_ship_task_id uuid not null
        constraint fk44hwubda4xslqkdemcktx49dg
            references external_shipping_task_report
);

-- ASSIGNING OWNER TO SCHEMAS
alter table country
    owner to postgres;
alter table region
    owner to postgres;
alter table city
    owner to postgres;
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