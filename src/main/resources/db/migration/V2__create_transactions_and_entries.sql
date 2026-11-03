CREATE TABLE transactions(
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL  DEFAULT now()
);

CREATE TABLE entries(
    id BIGSERIAL PRIMARY KEY,
    transaction_id BIGINT NOT NULL CONSTRAINT fk_entry_transaction REFERENCES transactions(id),
    account_id BIGINT NOT NULL  CONSTRAINT fk_entry_account REFERENCES accounts(id),
    direction VARCHAR(6) NOT NULL  CONSTRAINT chk_entry_direction CHECK(direction IN('DEBIT','CREDIT')),
    amount NUMERIC(19,4) NOT NULL  CONSTRAINT chk_entry_amount CHECK(amount>0)
);
