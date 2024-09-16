CREATE TABLE IF NOT EXISTS USERS (
    id SMALLSERIAL NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO USERS (name, email, password) VALUES ('Conrado', 'conradoeinsteinpro@gmail.com', '12345');