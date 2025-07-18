CREATE TABLE users (
    id VARCHAR(100) NOT NULL PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL
);

INSERT INTO users VALUES
    (uuid(), 'ujun', 'rahasia'),
    (uuid(), 'ozon', 'rahasia');
