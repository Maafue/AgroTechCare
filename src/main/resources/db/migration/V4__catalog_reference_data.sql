CREATE TABLE parts
(
    id      bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    article varchar NOT NULL
        CONSTRAINT uq_parts_article UNIQUE,
    name    varchar NOT NULL,
    price   numeric(10, 2)
);
CREATE TABLE jobs
(
    id         bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       varchar NOT NULL,
    norm_hours numeric(8, 2),
    price      numeric(10, 2)
);