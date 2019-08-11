CREATE SCHEMA "client-app-config";
create table "client-app-config".properties
(
    application varchar(255),
    profile     varchar(255),
    label       varchar(255),
    key         varchar(255),
    value       varchar(255)
);

create unique index properties_unique_value
    on "client-app-config".properties (application, profile, label, key);

INSERT INTO "client-app-config".properties (application, profile, label, key, value)
VALUES ('client-app', 'default', 'latest', 'cars.limit', '4');
INSERT INTO "client-app-config".properties (application, profile, label, key, value)
VALUES ('client-app', 'dev', 'latest', 'cars.limit', '1');
INSERT INTO "client-app-config".properties (application, profile, label, key, value)
VALUES ('client-app', 'prod', 'latest', 'cars.limit', '2');
