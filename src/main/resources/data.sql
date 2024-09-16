CREATE TABLE IF NOT EXISTS USERS (
    id SMALLSERIAL NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS POSTS (
    id SMALLSERIAL NOT NULL,
    user_id smallint NOT NULL, -- Ajuste o tipo para corresponder ao tipo da chave primária de USERS
    data text NOT NULL,
    time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES USERS(id) -- Atualize a referência para a coluna correta
);

INSERT INTO USERS (name, email, password) VALUES ('Conrado', 'conradoeinsteinpro@gmail.com', '12345');
INSERT INTO POSTS (username, user_id, data) VALUES (1, 1,'Meu nome é Conrado');
