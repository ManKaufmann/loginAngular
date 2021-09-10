CREATE SEQUENCE hibernate_sequence INCREMENT BY 1 START WITH 1;

CREATE TABLE user
(
    id       BIGINT NOT NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_frontend
(
    id           BIGINT NOT NULL,
    username     VARCHAR(255) NULL,
    userpassword VARCHAR(255) NULL,
    CONSTRAINT pk_user_frontend PRIMARY KEY (id)
);