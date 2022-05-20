alter table internal_accident
    add column penalty numeric(19, 2);

alter table external_accident
    add column penalty numeric(19, 2);

