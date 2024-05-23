CREATE DATABASE IF NOT EXISTS k_pac;

DROP TABLE IF EXISTS k_pac_k_pac_sets;
DROP TABLE IF EXISTS k_pac_set;
DROP TABLE IF EXISTS k_pac;

CREATE TABLE k_pac(
    k_pac_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(250),
    description VARCHAR(2000),
    createdAt DATE DEFAULT (CURRENT_DATE)
);

CREATE TABLE k_pac_set(
    k_pac_set_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(250),
    FOREIGN KEY (k_pac_set_id) REFERENCES k_pac(k_pac_id)
);

CREATE TABLE k_pac_k_pac_sets(
    id BIGINT,
    id_set BIGINT,
    FOREIGN KEY (id) REFERENCES k_pac(k_pac_id),
    FOREIGN KEY (id_set) REFERENCES k_pac_set(k_pac_set_id),
    PRIMARY KEY (id, id_set)
);