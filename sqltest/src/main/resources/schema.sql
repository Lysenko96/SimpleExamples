DROP TABLE IF EXISTS singer_instrument;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS singer;
DROP TABLE IF EXISTS instrument;
DROP TABLE IF EXISTS track;

CREATE TABLE singer
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(60) NOT NULL,
    last_name  VARCHAR(40) NOT NULL,
    birth_date DATE,
    version    INT         NOT NULL DEFAULT 0,
    UNIQUE (first_name, last_name)
);

CREATE TABLE track
(
    id         SERIAL PRIMARY KEY,
    counter    INT         NOT NULL DEFAULT 0
);


CREATE TABLE album
(
    id           SERIAL PRIMARY KEY,
    singer_id    INT          , --NOT NULL,
    title        VARCHAR(100) NOT NULL,
    release_date DATE,
    version      INT          NOT NULL DEFAULT 0,
    UNIQUE (singer_id, title),
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
    singer_id     INT         NOT NULL,
    instrument_id VARCHAR(20) NOT NULL,
    PRIMARY KEY (singer_id, instrument_id),
    CONSTRAINT fk_singer_instrument_1
        FOREIGN KEY (singer_id)
            REFERENCES singer (id) ON DELETE CASCADE,
    CONSTRAINT fk_singer_instrument_2
        FOREIGN KEY (instrument_id)
            REFERENCES instrument (instrument_id)
);

