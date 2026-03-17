CREATE DATABASE IF NOT EXISTS saga_sale;
CREATE DATABASE IF NOT EXISTS saga_payment;
CREATE DATABASE IF NOT EXISTS saga_inventory;

CREATE TABLE saga_state (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    sale_id       VARCHAR(36)  NOT NULL,
    current_event VARCHAR(50)  NOT NULL,
    processed_at  DATETIME     NOT NULL DEFAULT NOW(),
    UNIQUE KEY uq_sale_event (sale_id, current_event)
);
