CREATE TABLE person
(
    id         SERIAL PRIMARY KEY,
    email      VARCHAR(64) NOT NULL UNIQUE,
    first_name VARCHAR(64) NOT NULL,
    last_name  VARCHAR(64) NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);

INSERT INTO person(email, first_name, last_name)
VALUES ('mail1@g.co', 'Bobby1', 'Fisher1');

DROP TABLE IF EXISTS note;

CREATE TABLE note
(
    id         BIGSERIAL PRIMARY KEY,
    title      VARCHAR(64) NOT NULL,
    body       VARCHAR(128),
    created_at TIMESTAMP DEFAULT now(),
    person_id  BIGINT REFERENCES person (id)
);

ALTER TABLE note
    ADD COLUMN person_id BIGINT NOT NULL;

ALTER TABLE note
    ADD CONSTRAINT "note_person_id_fk" FOREIGN KEY (person_id) REFERENCES person (id);

INSERT INTO note(title, body, person_id)
VALUES ('my title1', 'my body1', 2);

SELECT first_name, last_name
FROM person p
         JOIN note n ON p.id = n.person_id
GROUP BY first_name, last_name
HAVING count(n.id) > 1;

CREATE TABLE product
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(64) NOT NULL,
    price      DECIMAL(8, 2),
    created_at TIMESTAMP DEFAULT now()
);

INSERT INTO product(name, price)
VALUES ('name2', 93.2);

SELECT name
FROM product
GROUP BY name
HAVING count(name) > 1;

CREATE SEQUENCE "id_sequence" START 20;
SELECT nextval('id_sequence');


SELECT *
FROM pg_constraint cn
         JOIN pg_class ON cn.conrelid = pg_class.oid
WHERE relname = 'person';


CREATE TABLE "user"
(
    id         BIGSERIAL
        CONSTRAINT user_pk PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name  TEXT NOT NULL,
    email      TEXT NOT NULL
        CONSTRAINT user_email_uq UNIQUE
);

CREATE TABLE video
(
    id          BIGSERIAL
        CONSTRAINT video_pk PRIMARY KEY,
    name        TEXT NOT NULL,
    location    TEXT NOT NULL,
    uploaded_at TIMESTAMP DEFAULT now()
);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    id         BIGSERIAL
        CONSTRAINT comment_pk PRIMARY KEY,
    body       TEXT NOT NULL,
    user_id    BIGINT
        CONSTRAINT comment_user_fk REFERENCES "user" (id),
    video_id   BIGINT
        CONSTRAINT comment_video_fk REFERENCES video (id),
    created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE users_friends
(
    user_id   BIGINT
        CONSTRAINT users_friends_user_fk REFERENCES "user" (id),
    friend_id BIGINT
        CONSTRAINT users_friends_friend_fk REFERENCES "user" (id),
    CONSTRAINT users_friends_pk PRIMARY KEY (user_id, friend_id)
);

INSERT INTO "user"(first_name, last_name, email)
VALUES ('user2','user2','user2@mail.com');

INSERT INTO users_friends(user_id, friend_id)
VALUES (1,2);

INSERT INTO video(name, location)
VALUES ('video', 'youtube');

INSERT INTO comment(body, user_id, video_id)
VALUES ('good video', 1, 1);




