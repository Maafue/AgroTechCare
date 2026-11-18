CREATE TABLE brands
(
    id   bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar NOT NULL UNIQUE
);
CREATE TABLE machine_models
(
    id       bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name     varchar NOT NULL,
    brand_id bigint  NOT NULL REFERENCES brands (id),
    CONSTRAINT uq_machine_models_brand_id_name UNIQUE (brand_id, name)
);
CREATE TABLE clients
(
    id      bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type    varchar NOT NULL CHECK (type IN ('LEGAL', 'INDIVIDUAL')),
    name    varchar NOT NULL,
    unp     varchar UNIQUE,
    address varchar,
    phone   varchar NOT NULL,
    email   varchar,
    CONSTRAINT chk_clients_type_unp CHECK ( (type = 'LEGAL' AND unp IS NOT NULL)
                                                OR (type = 'INDIVIDUAL' AND unp IS NULL))
);
CREATE TABLE users
(
    id            bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    client_id     bigint REFERENCES clients (id),
    username      varchar NOT NULL UNIQUE,
    password_hash varchar NOT NULL,
    last_name     varchar NOT NULL,
    first_name    varchar NOT NULL,
    middle_name   varchar,
    phone         varchar,
    role          varchar NOT NULL CHECK (role IN ('CLIENT', 'MECHANIC', 'MANAGER', 'DIRECTOR')),
    active        boolean NOT NULL DEFAULT TRUE,
    CONSTRAINT chk_users_role_client_id CHECK ( (role = 'CLIENT' AND client_id IS NOT NULL)
                                                    OR (role !='CLIENT' AND client_id IS NULL) )
);
CREATE INDEX idx_users_client_id on users (client_id);
