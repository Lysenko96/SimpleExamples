DROP TABLE IF EXISTS singer_instrument;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS singer;
DROP TABLE IF EXISTS singer_audit;
DROP TABLE IF EXISTS instrument;

CREATE TABLE singer
(
    --id         INT         NOT NULL AUTO_INCREMENT,
    id         SERIAL PRIMARY KEY ,
    first_name VARCHAR(60) NOT NULL,
    last_name  VARCHAR(40) NOT NULL,
    birth_date DATE,
    version    INT         DEFAULT 0,
    UNIQUE (first_name, last_name)
   -- PRIMARY KEY (id)
);

CREATE TABLE singer_audit
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(60) NOT NULL,
    last_name  VARCHAR(40) NOT NULL,
    birth_date DATE,
    version    INT          DEFAULT 0,
    created_by VARCHAR(20),
    created_date TIMESTAMP,
    last_modified_by VARCHAR(20),
    last_modified_date TIMESTAMP,
    UNIQUE (first_name, last_name)
    --PRIMARY KEY (id)
);


CREATE TABLE album
(
    id           SERIAL PRIMARY KEY,
    singer_id    INT          NOT NULL,
    title        VARCHAR(100) NOT NULL,
    release_date DATE,
    version      INT           DEFAULT 0,
    UNIQUE (singer_id, title),
   -- PRIMARY KEY (ID),
    CONSTRAINT fk_album_singer FOREIGN KEY (singer_id)
        REFERENCES singer (ID)
);

CREATE TABLE instrument
(
    instrument_id VARCHAR(20) NOT NULL,
    PRIMARY KEY (instrument_id)
);

CREATE TABLE singer_instrument
(
    singer_id INT NOT NULL,
    instrument_id VARCHAR(20) NOT NULL,
    PRIMARY KEY (singer_id, instrument_id),
    CONSTRAINT fk_singer_instrument_1
        FOREIGN KEY (singer_id)
        REFERENCES singer (id) ON DELETE CASCADE,
    CONSTRAINT fk_singer_instrument_2
        FOREIGN KEY (instrument_id)
        REFERENCES instrument (instrument_id)
);

