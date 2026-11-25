CREATE TABLE machines
(
    id               bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    model_id         bigint  NOT NULL REFERENCES machine_models (id),
    owner_client_id  bigint  NOT NULL REFERENCES clients (id),
    serial_number    varchar NOT NULL  CONSTRAINT machines_serial_number_duplicate UNIQUE,
    manufacture_year int
        CONSTRAINT chk_machines_manufacture_year CHECK (manufacture_year <= EXTRACT(YEAR FROM CURRENT_DATE)
            AND manufacture_year >= 1950),
    warranty_until   date
);

CREATE INDEX idx_machines_model_id on machines (model_id);
CREATE INDEX idx_machines_owner_client_id on machines (owner_client_id);

CREATE TABLE contracts
(
    id          bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    number      varchar NOT NULL UNIQUE,
    client_id   bigint  NOT NULL REFERENCES clients (id),
    type        varchar NOT NULL
        CONSTRAINT chk_type CHECK ( type IN ('SALE', 'SERVICE', 'PARTS_SUPPLY')),
    signed_date date,
    end_date    date,
    amount      numeric(15, 4)
        CONSTRAINT chk_contracts_amount CHECK (amount >= 0),
    CONSTRAINT chk_contracts_signed_date_end_date CHECK ( signed_date <= end_date )

);
CREATE INDEX idx_contracts_client_id on contracts (client_id);
CREATE TABLE contract_machines
(
    contract_id bigint REFERENCES contracts (id),
    machine_id  bigint REFERENCES machines (id),
    PRIMARY KEY (contract_id, machine_id)
);
CREATE INDEX idx_contract_machines_machine_id on contract_machines (machine_id);
