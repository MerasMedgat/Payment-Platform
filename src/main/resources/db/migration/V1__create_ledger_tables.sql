CREATE TABLE accounts(
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(30) NOT NULL,
    currency CHAR(3) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);